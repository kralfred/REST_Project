package com.example.rest_project.service

import com.example.rest_project.entity.RefreshToken
import com.example.rest_project.repository.RefreshTokenMapper
import org.springframework.stereotype.Service
import java.util.*



@Service
class RefreshTokenService(
    private val refreshTokenMapper: RefreshTokenMapper
) {

    fun save(refreshToken: RefreshToken): Int {
        return refreshTokenMapper.insert(refreshToken)
    }

    fun findByToken(token: String): RefreshToken? {
        return refreshTokenMapper.findByToken(token)
    }

    fun deleteByToken(token: String): Int {
        return refreshTokenMapper.deleteByToken(token)
    }

    fun deleteByUserId(userId: UUID): Int {
        return refreshTokenMapper.deleteByUserId(userId)
    }
}
