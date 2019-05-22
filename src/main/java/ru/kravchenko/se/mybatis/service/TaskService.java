package ru.kravchenko.se.mybatis.service;

import com.sun.istack.internal.Nullable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import ru.kravchenko.se.mybatis.entity.Task;
import ru.kravchenko.se.mybatis.repository.TaskRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kravchenko
 */
public class TaskService extends AbstractService {

    private final TaskRepository taskRepository;

    public TaskService() throws IOException {
        taskRepository = sqlSession.getMapper(TaskRepository.class);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public List<String> ids() {
        return taskRepository.ids();
    }

    public Task findOne(@Nullable final String id) {
        return taskRepository.findOne(id);
    }

    public List<Task> findAllTaskByUserId(@Nullable final String userId) {
        return taskRepository.findAllTaskByUserId(userId);
    }

    public void removeById(@Nullable final String id) {
        taskRepository.removeById(id);
    }

    public void removeAllTaskByUserId(@Nullable final String userId) {
        taskRepository.removeAllTaskByUserId(userId);
    }

    public void insert(@Nullable final Task task) {
        taskRepository.insert(task);
    }

    public void clear() {
        taskRepository.clear();
    }

    public void commit() {
        sqlSession.commit();
    }

    public void roolback() {
        sqlSession.rollback();
    }

}
