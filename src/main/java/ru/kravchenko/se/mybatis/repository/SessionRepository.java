package ru.kravchenko.se.mybatis.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.kravchenko.se.mybatis.entity.Session;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface SessionRepository {

    @Select("SELECT * FROM `session`")
    List<Session> findAll();

    @Select("SELECT id FROM `session`")
    List<String> ids();

    @Select("SELECT * FROM `session` WHERE id = #{id}")
    Session findOne(String id);

    @Delete("DELETE FROM `session` WHERE id = #{id}")
    void removeById(String id);

    @Insert("INSERT INTO `session`(`id`, `signature`, `timestamp`, `user_id`) " +
            "VALUES (#{id}, #{signature}, #{timestamp}, #{userId})")
    void insert(Session session);

    @Delete("DELETE FROM `session`")
    void clear();

}
