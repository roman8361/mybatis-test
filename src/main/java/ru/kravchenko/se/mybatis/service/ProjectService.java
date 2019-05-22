package ru.kravchenko.se.mybatis.service;

import com.sun.istack.internal.Nullable;
import ru.kravchenko.se.mybatis.entity.Project;
import ru.kravchenko.se.mybatis.repository.ProjectRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class ProjectService extends AbstractService {

    private final ProjectRepository projectRepository;

    public ProjectService() throws IOException {
        projectRepository = sqlSession.getMapper(ProjectRepository.class);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<String> ids() {
        return projectRepository.ids();
    }

    public Project findOne(@Nullable final String id) {
        return projectRepository.findOne(id);
    }

    public void removeById(@Nullable final String id) {
        projectRepository.removeById(id);
    }

    public void insert(@Nullable final Project project) {
        projectRepository.insert(project);
    }

    public void clear() {
        projectRepository.clear();
    }

    public void commit() {
        sqlSession.commit();
    }

    public void roolback() {
        sqlSession.rollback();
    }

    public List<Project> findAllProjectByUserId(@Nullable final String userId) {
        return projectRepository.findAllProjectByUserId(userId);
    }

    public void removeAllProjectByUserId(@Nullable final String userId) {
        projectRepository.removeAllProjectByUserId(userId);
    }

}
