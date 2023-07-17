package com.example.alumni.filter;

import com.example.alumni.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    private final UserDetailsService userDetailsService;

    public JwtFilter(JwtUtil jwtUtil, UserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        System.out.println(request.getRequestURL().toString().toLowerCase());

        var token = extractTokenFromRequest(request);

        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                SecurityContextHolder.getContext().setAuthentication(jwtUtil.getAuthentication(token));
            } else if(!request.getRequestURL().toString().toLowerCase().endsWith("/uaa/refreshtoken")){
                response.setStatus(HttpStatus.UNAUTHORIZED.value()); // Set HTTP 401 Unauthorized status
                return;
            }
        }


        filterChain.doFilter(request, response);
    }

    /**
     * Helper method
     *
     * @param request
     * @return
     */
    public String extractTokenFromRequest(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            var token = authorizationHeader.substring(7);
            if(!token.equals("null")){
                return token;
            }
        }
        return null;
    }
}

