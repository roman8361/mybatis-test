package ru.kravchenko.se.mybatis.service;

import com.sun.istack.internal.Nullable;
import ru.kravchenko.se.mybatis.entity.Session;
import ru.kravchenko.se.mybatis.repository.SessionRepository;

import java.io.IOException;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class SessionService extends AbstractService {

    private final SessionRepository sessionRepository;

    public SessionService() throws IOException {
        sessionRepository = sqlSession.getMapper(SessionRepository.class);
    }

    public List<Session> findAll() {
        return sessionRepository.findAll();
    }

    public List<String> ids() {
        return sessionRepository.ids();
    }

    public Session findOne(@Nullable final String id) {
        return sessionRepository.findOne(id);
    }

    public void removeById(@Nullable final String id) {
        sessionRepository.removeById(id);
    }

    public void insert(@Nullable final Session session) {
        sessionRepository.insert(session);
    }

    public void clear() {
        sessionRepository.clear();
    }

    public void commit() {
        sqlSession.commit();
    }

    public void roolback() {
        sqlSession.rollback();
    }

}
