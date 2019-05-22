package ru.kravchenko.se;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;
import ru.kravchenko.se.mybatis.entity.Session;
import ru.kravchenko.se.mybatis.service.SessionService;

import java.io.IOException;
import java.util.Date;

/**
 * @author Roman Kravchenko
 */

public class SessionTest {

    private final SessionService sessionDAO = new SessionService();

    private final Lorem lorem = new LoremIpsum();

    public SessionTest() throws IOException {
    }

    @Test
    public void addSession() {
        for (int i = 0; i < 5; i++) addOne();
    }

    private void addOne() {
        final Session session = new Session();
        session.setSignature(lorem.getUrl());
        session.setTimestamp(new Date());
        //    session.setUserId("35a22b46-f8b6-4187-9963-efb7eb880226");
        sessionDAO.insert(session);
        sessionDAO.commit();
    }

    @Test
    public void ids() {
        for (String s : sessionDAO.ids()) System.out.println(s);
    }

    @Test
    public void findAll() {
        for (Session s : sessionDAO.findAll()) System.out.println(s.getSignature());
    }

    @Test
    public void findOne() {
        System.out.println(sessionDAO.findOne("6838cded-d343-4182-be9b-cce783d075c7").getSignature());
    }

    @Test
    public void removeById() {
        sessionDAO.removeById("6838cded-d343-4182-be9b-cce783d075c7");
        sessionDAO.commit();
    }

    @Test
    public void clear() {
        sessionDAO.clear();
        sessionDAO.commit();
    }


}
