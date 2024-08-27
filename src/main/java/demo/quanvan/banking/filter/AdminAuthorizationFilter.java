package demo.quanvan.banking.filter;

import demo.quanvan.banking.config.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;

public class AdminAuthorizationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public AdminAuthorizationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String requestURI = request.getRequestURI();

        // Check if the request is for an admin-only endpoint
        if (!isAdminOnlyEndpoints(requestURI)) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization header is missing or malformed");
            return;
        }

        String token = authHeader.substring(7);
        if (!jwtUtil.validateToken(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
            return;
        }

        String role = jwtUtil.extractRole(token);
        if (!"ROLE_ADMIN".equals(role)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: Insufficient permissions");
            return;
        }

        String username = jwtUtil.extractUsername(token);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                username, null, Collections.singletonList(() -> "ROLE_ADMIN"));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Continue with the filter chain
        filterChain.doFilter(request, response);
    }

    private boolean isAdminOnlyEndpoints(String requestURI) {
        return requestURI.equals("/api/accounts") ||
                requestURI.equals("/api/account-types") ||
                requestURI.equals("/api/transactions") ||
                requestURI.equals("/api/transaction-types") ||
                requestURI.equals("/api/roles") ||
                requestURI.equals("/api/users");
    }
}
