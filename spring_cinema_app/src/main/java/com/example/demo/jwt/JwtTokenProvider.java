package com.example.demo.jwt;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

@Component
public class JwtTokenProvider implements Serializable {

    private String JWT_SECRET = "secretkey";

    private long JWT_EXPIRATION = 604800000L;

    /**
     * Pham Trung Hieu
     * @param username
     * @return new token for user
     */
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    /**
     * Pham Trung Hieu
     * @param token
     * @return get username from token after login
     */
    public String getUsernameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody().getSubject();
    }

    /**
     * Pham Trung Hieu
     * @param authToken
     * @return validator token
     */
    public Boolean validateToken(String authToken, UserDetails userDetails) {
        final String username = getUsernameFromJwtToken(authToken);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(authToken));
    }

    /**
     * Pham Trung Hieu
     * @param token
     * @return status expired token
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    /**
     * Pham Trung Hieu
     * @param token
     * @return date expired from token
     */
    public Date getExpirationDateFromToken(String token) {
        final Claims claims = getAllClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * Pham Trung Hieu
     * @param token
     * @return all claim from token
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
    }
}
