package ru.kravchenko.se;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import ru.kravchenko.se.mybatis.entity.Status;
import ru.kravchenko.se.mybatis.entity.User;
import ru.kravchenko.se.mybatis.service.UserService;

import java.io.IOException;

/**
 * @author Roman Kravchenko
 */

public class UserTest {

    private final UserService userDAO = new UserService();

    private final Lorem lorem = LoremIpsum.getInstance();

    public UserTest() throws IOException {
    }

    @Test
    public void addAnyUserTest() {
        for (int i = 0; i < 10; i++) addOneUser();
    }

    public void addOneUser() {
        final User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(DigestUtils.md5Hex(lorem.getWords(1)));
        userDAO.insert(user);
        userDAO.commit();
    }

    @Test
    public void clear() {
        userDAO.clear();
        userDAO.commit();
    }

    @Test
    public void findAll() {
        for (User u : userDAO.findAll()) System.out.println(u.getLogin());
    }

    @Test
    public void ids() {
        for (String s : userDAO.ids()) System.out.println(s);
    }

    @Test
    public void findOne() {
        final User user = userDAO.findOne("09c77545-f838-4905-8037-2d2c44213046");
        final Status status = user.getRole();
        System.out.println(status);
    }

    @Test
    public void removeById() {
        userDAO.removeById("21042d6b-0a04-4305-a423-dbfd0487baf0");
        userDAO.commit();
    }

}
