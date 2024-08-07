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
       INSERT INTO tasks ( name, complete ) 
    VALUES ( #{name}, #{complete} )
        """
    )
    fun insert(entity: Task): Int

    @Select("SELECT * FROM tasks WHERE name = #{name}")
    fun getByName(name: String): List<Task>

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
            complete = #{complete}
        WHERE taskID = #{taskID}
    """
    )
    fun update(taskID: Int, complete: Boolean): Int


    @Delete("DELETE FROM tasks WHERE taskID = #{taskID}")
    fun delete(taskID: Int): Int
}