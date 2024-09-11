package com.example.rest_project.repository


import com.example.rest_project.entity.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import java.util.*


@Mapper
@Repository
interface UserMapper {

   @Insert ("INSERT INTO user ( first_name, last_name, role, userID) VALUES (#{first_name}, #{lastname}, #{role}, #{userID, jdbcType=OTHER})")
   fun insert(user: User)

   @Select("SELECT * FROM user WHERE name LIKE CONCAT('%', #{name}, '%')")
   fun getByName(name: String): List<User>

   @Select(
      """
        <script>
        SELECT * FROM user
        </script>
        """
   )
   fun getAll(): List<User>

   @Update(
      """
        UPDATE user SET
            lastName = #{lastName}
        WHERE userID = #{userID, jdbcType=OTHER}
    """
   )
   fun changeFirstName(userID: UUID, firstName: String)


   @Update(
      """
        UPDATE user SET
            lastName = #{lastName}
        WHERE userID = #{userID, jdbcType=OTHER}
    """
   )
   fun changeLastName(userID: UUID, lastName: String)


   @Delete("DELETE FROM user WHERE userID = #{userID, jdbcType=OTHER}")
   fun delete(userID: UUID)

}