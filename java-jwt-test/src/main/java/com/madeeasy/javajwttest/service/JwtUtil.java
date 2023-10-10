package com.madeeasy.javajwttest.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class JwtUtil {

    private static final String SECRET_KEY =
            "YXNkamY7aWE7ZW9mO2Fsc2RrajtsYWlqc2Q7b2lmYXNkZmFzZGxma2FzZjtqYWxpc2pkO2ZvaXdhZWpsa2FzZGo7Zmxpc2FqZDtmb2lhajtsZWlqO2ZhcG9panNkbGZpYWo7ZW9pcGZqO2Fsc2lkamY=";

    public String generateToken(String username) {
        return Jwts.builder()
                .id(UUID.randomUUID().toString())
                .subject(username)
                .issuer("MadeEasy")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
                .signWith(getSigningKey())
                .compact();
    }

    public Claims getAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // SecretKey from javax.crypto.SecretKey

    private SecretKey getSigningKey() {
        byte[] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }

    public boolean validateToken(String token) {
        return false;
    }


    // get token expiration
    public Date getExpiration(String token) {
        return getAllClaims(token).getExpiration();
    }


    public String getUsername(String token) {
        return getAllClaims(token).getSubject();
    }

    // isTokenExpired
    public boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    // isValidToken
    // validity depends on 1) token expiration 2) token subject
    public boolean isValidToken(String token, String subject) {
        return !isTokenExpired(token) && getUsername(token).equals(subject);
    }
}
