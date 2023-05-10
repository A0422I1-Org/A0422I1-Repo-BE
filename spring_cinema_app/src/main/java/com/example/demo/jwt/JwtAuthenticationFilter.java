package com.example.demo.jwt;

import com.example.demo.service.impl.account.JwtAccountDetailServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private JwtAccountDetailServiceImpl jwtAccountDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain)
            throws ServletException, IOException {
            final String headerAuth = httpServletRequest.getHeader("Authorization");

            String accountName = null;
            String jwtToken = null;
            if (headerAuth != null && headerAuth.startsWith("Bearer ")) {
                jwtToken = headerAuth.substring(7);
                try {
                    accountName = jwtTokenProvider.getUsernameFromJwtToken(jwtToken);
                } catch (IllegalArgumentException e) {
                    logger.error("Unable to get JWT Token");
                } catch (ExpiredJwtException e) {
                    logger.error("JWT Token has expired");
                }
            } else {
                logger.warn("JWT Token does not begin with Bearer String");
            }

            if (accountName != null && SecurityContextHolder.getContext().getAuthentication() != null) {

                UserDetails userDetails = jwtAccountDetailService.loadUserByUsername(accountName);

                if (jwtTokenProvider.validateToken(jwtToken, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
