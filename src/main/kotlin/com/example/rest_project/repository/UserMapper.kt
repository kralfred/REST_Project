package com.example.rest_project.repository


import com.example.rest_project.entity.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import java.util.*


@Mapper
@Repository
interface UserMapper {




   @Select("SELECT * FROM \"user\" WHERE name LIKE CONCAT('%', #{name}, '%')")
   fun getByName(name: String): List<User>

   @Select(
      """
        <script>
        SELECT * FROM "user" 
        </script>
        """
   )
   fun getAll(): List<User>



   @Select("SELECT * FROM \"user\" WHERE email LIKE CONCAT('%', #{email}, '%')")
   fun getAllByEmail(email: String): List<User>




   @Select("SELECT * FROM \"user\" WHERE email LIKE CONCAT('%', #{email}, '%')")
   fun getByEmail(email: String): User?




   @Delete("DELETE FROM \"user\" WHERE userID = #{userID, jdbcType=OTHER}")
   fun delete(userID: UUID)






   // FOR LATER EXPANSION


//   @Update(
//      """
//        UPDATE user SET
//            firstName = #{firstName}
//        WHERE userID = (#{userID, jdbcType=OTHER})
//    """
//   )
//   fun changeFirstName(firstName: String, userID: UUID)
//
//
//
//   @Update(
//      """
//        UPDATE user SET
//            lastName = #{lastName}
//        WHERE userID = #{userID, jdbcType=OTHER}
//    """
//   )
//   fun changeLastName( lastName: String, userID: UUID)






}








