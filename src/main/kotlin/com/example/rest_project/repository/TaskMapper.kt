package com.example.rest_project.repository

import com.example.rest_project.entity.Task
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import java.util.UUID



@Mapper
@Repository
interface TaskMapper {
    @Insert("INSERT INTO task (name, complete, date, taskid) VALUES (#{name}, #{complete}, #{date}, #{taskID, jdbcType=OTHER})")
    fun insert(task: Task)



    @Select("SELECT * FROM task WHERE name LIKE CONCAT('%', #{name}, '%')")
    fun getByName(name: String): List<Task>

    @Select(
        """
        <script>
        SELECT * FROM TASK
        </script>
        """
    )
    fun getAll(): List<Task>

    @Update(
        """
        UPDATE task SET
            complete = #{complete}
        WHERE taskid = #{taskID, jdbcType=OTHER}
    """
    )
    fun update(complete: Boolean, taskID: UUID )


    @Delete("DELETE FROM task WHERE taskid = #{taskID, jdbcType=OTHER}")
    fun delete(taskID: UUID)
}