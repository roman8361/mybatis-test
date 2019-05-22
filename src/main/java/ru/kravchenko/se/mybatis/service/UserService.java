package ru.kravchenko.se.mybatis.service;

import com.sun.istack.internal.Nullable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.kravchenko.se.mybatis.entity.Project;
import ru.kravchenko.se.mybatis.entity.User;
import ru.kravchenko.se.mybatis.repository.UserRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class UserService extends AbstractService {

    private final UserRepository userRepository;

    public UserService() throws IOException {
        userRepository = sqlSession.getMapper(UserRepository.class);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<String> ids() {
        return userRepository.ids();
    }

    public User findOne(@Nullable final String id) {
        return userRepository.findOne(id);
    }

    public void removeById(@Nullable final String id) {
        userRepository.removeById(id);
    }

    public void insert(@Nullable final User user) {
        userRepository.insert(user);
    }

    public void clear() {
        userRepository.clear();
    }

    public void commit() {
        sqlSession.commit();
    }

    public void roolback() {
        sqlSession.rollback();
    }

}
