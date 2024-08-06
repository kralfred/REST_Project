package com.example.rest_project.repository

import com.example.rest_project.entity.Task
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import java.util.*

@Mapper
@Repository
interface TaskMapper {
    @Insert(
        """
        INSERT INTO tasks ( name ) 
        VALUES ( #{name} )
        """
    )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    fun insert(entity: Task): UUID

    @Select("SELECT * FROM tasks WHERE id = #{itemId}")
    fun getById(itemId: Int): Task?

    @Select(
        """
        <script>
        SELECT * FROM TASKS
        </script>
        """
    )
    fun getAll(): List<Task>

    @Update(
        """
        UPDATE tasks SET
            name = #{name}
        WHERE id = #{id}
    """
    )
    fun update(entity: Task): Int


    @Delete("DELETE FROM tasks WHERE id = #{itemId}")
    fun delete(itemId: Int): Int
}