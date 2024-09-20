package com.example.rest_project.repository


import com.example.rest_project.entity.RefreshToken
import org.apache.ibatis.annotations.Delete
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository
import java.util.*

@Mapper
@Repository
interface RefreshTokenMapper {

    @Insert("""
        INSERT INTO refresh_tokens (id, token, user_id, expiry_date) 
        VALUES (#{id, jdbcType=OTHER}, #{token}, #{userId, jdbcType=OTHER}, #{expirationDate})
    """)
    fun insert(refreshToken: RefreshToken): Int

    @Select("""
        SELECT * FROM refresh_tokens 
        WHERE token = #{token}
    """)
    fun findByToken(token: String): RefreshToken?

    @Delete("""
        DELETE FROM refresh_tokens 
        WHERE token = #{token}
    """)
    fun deleteByToken(token: String): Int

    @Delete("""
        DELETE FROM refresh_tokens 
        WHERE user_id = #{userId, jdbcType=OTHER}
    """)
    fun deleteByUserId(userId: UUID): Int
}