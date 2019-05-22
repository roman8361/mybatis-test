package ru.kravchenko.se.mybatis.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.kravchenko.se.mybatis.entity.Task;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface TaskRepository {

    @Select("SELECT * FROM `task`")
    List<Task> findAll();

    @Select("SELECT id FROM `task`")
    List<String> ids();

    @Select("SELECT * FROM `task` WHERE id = #{id}")
    Task findOne(String id);

    @Select("SELECT * FROM `task` WHERE user_id = #{userId}")
    List<Task> findAllTaskByUserId(String userId);

    @Delete("DELETE FROM `task` WHERE id = #{id}")
    void removeById(String id);

    @Delete("DELETE FROM `task` WHERE user_id = #{userId}")
    void removeAllTaskByUserId(String userId);

    @Insert("INSERT INTO `task`(`id`, `name`, `description`, `project_id`, `user_id`, `dateBegin`, `dateEnd`, `status`) " +
            "VALUES (#{id}, #{name}, #{description}, #{projectId}, #{userId}, #{dateBegin}, #{dateEnd}, #{status})")
    void insert(Task task);

    @Delete("DELETE FROM `task`")
    void clear();

}
