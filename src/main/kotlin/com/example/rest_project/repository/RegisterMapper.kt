package com.example.rest_project.repository

import org.apache.ibatis.annotations.*
import com.example.rest_project.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository
import java.util.UUID


@Mapper
@Repository
interface RegisterMapper {

    @Insert("INSERT INTO \"user\" (name, email, role, userid, password) VALUES (#{name}, #{email}, #{role}, #{userID, jdbcType=OTHER}, #{password})")
    fun createUser(user: User)




}