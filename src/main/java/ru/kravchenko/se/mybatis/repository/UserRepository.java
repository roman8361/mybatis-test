package ru.kravchenko.se.mybatis.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.kravchenko.se.mybatis.entity.User;

import java.util.List;

/**
 * @author Roman Kravchenko
 */

public interface UserRepository {

    @Select("SELECT * FROM `user`")
    List<User> findAll();

    @Select("SELECT id FROM `user`")
    List<String> ids();

    @Select("SELECT * FROM `user` WHERE id = #{id}")
    User findOne(String id);

    @Delete("DELETE FROM `user` WHERE id = #{id}")
    void removeById(String id);

    @Insert("INSERT INTO `user`(`id`, `login`, `passwordHash`, `role`, `locked`) " +
            "VALUES (#{id}, #{login}, #{passwordHash}, #{role}, #{locked})")
    void insert(User user);

    @Delete("DELETE FROM `user`")
    void clear();

}
