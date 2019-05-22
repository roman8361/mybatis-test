package ru.kravchenko.se.mybatis.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.kravchenko.se.mybatis.entity.Project;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface ProjectRepository {

    @Select("SELECT * FROM `project`")
    List<Project> findAll();

    @Select("SELECT id FROM `project`")
    List<String> ids();

    @Select("SELECT * FROM `project` WHERE id = #{id}")
    Project findOne(String id);

    @Select("SELECT * FROM `project` WHERE user_id = #{userId}")
    List<Project> findAllProjectByUserId(String userId);

    @Delete("DELETE FROM `project` WHERE id = #{id}")
    void removeById(String id);

    @Delete("DELETE FROM `project` WHERE user_id = #{userId}")
    void removeAllProjectByUserId(String userId);

    @Insert("INSERT INTO `project`(`id`, `name`, `description`, `dateBegin`, `dateEnd`, `user_id`, `status`) " +
            "VALUES (#{id}, #{name}, #{description}, #{dateBegin}, #{dateEnd}, #{userId}, #{status})")
    void insert(Project project);

    @Delete("DELETE FROM `project`")
    void clear();

}
