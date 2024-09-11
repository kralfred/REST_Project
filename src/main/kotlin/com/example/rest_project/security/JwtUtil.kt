package com.example.rest_project.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

//@Component
//class JwtUtil {
//    private val secretKey = "mysecretkey"
//
//    // Generate JWT Token
//    fun generateToken(username: String): String {
//        val claims = HashMap<String, Any>()
//        return Jwts.builder()
//            .setClaims(claims)
//            .setSubject(username)
//            .setIssuedAt(Date(System.currentTimeMillis()))
//            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours validity
//            .signWith(SignatureAlgorithm.HS256, secretKey)
//            .compact()
//    }
//
//    // Validate JWT Token
//    fun validateToken(token: String, username: String): Boolean {
//        val tokenUsername = extractUsername(token)
//        return (tokenUsername == username && !isTokenExpired(token))
//    }
//
//    // Extract username from token
//    fun extractUsername(token: String): String {
//        return extractClaims(token).subject
//    }
//
//    // Extract all claims from token
//    private fun extractClaims(token: String): Claims {
//        return Jwts.parser()
//            .setSigningKey(secretKey)
//            .parseClaimsJws(token)
//            .body
//    }
//
//    // Check if token has expired
//    private fun isTokenExpired(token: String): Boolean {
//        return extractClaims(token).expiration.before(Date())
//    }
//}
