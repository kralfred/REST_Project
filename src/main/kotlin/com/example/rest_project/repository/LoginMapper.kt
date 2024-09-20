package com.example.rest_project.repository

import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface LoginMapper {

    @Select("select * from user where  = #{id}")
    fun loginCheck()



}