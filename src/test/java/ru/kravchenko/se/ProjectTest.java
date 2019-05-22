package ru.kravchenko.se;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Assert;
import org.junit.Test;
import ru.kravchenko.se.mybatis.entity.Project;
import ru.kravchenko.se.mybatis.service.ProjectService;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Unit test for simple App.
 */

public class ProjectTest {

    private final ProjectService projectDAO = new ProjectService();

    public ProjectTest() throws IOException {
    }

    @Test
    public void testInsertFindAll() {
        final Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setName("123");
        projectDAO.insert(project);
        projectDAO.commit();
        final List<Project> tasks = projectDAO.findAll();
        System.out.println(tasks.get(0).getName());
        Assert.assertNotNull(tasks);
    }

    @Test
    public void testClearDate() {
        projectDAO.clear();
        projectDAO.commit();
    }

    @Test
    public void addDate() {
        for (int i = 0; i < 10; i++) {
            final Lorem lorem = LoremIpsum.getInstance();
            final Project project = new Project();
            project.setName(lorem.getName());
            project.setDescription(lorem.getWords(4));
            project.setDateBegin(new Date());
            project.setDateEnd(new Date());
            projectDAO.insert(project);
            projectDAO.commit();
        }
    }

    @Test
    public void addOneProject() {
        final Lorem lorem = LoremIpsum.getInstance();
        final Project project = new Project();
        project.setName(lorem.getName());
        project.setDescription(lorem.getWords(4));
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        projectDAO.insert(project);
        projectDAO.commit();
    }

    @Test
    public void removeById() {
        projectDAO.removeById("abebdee0-27c6-457b-aaa9-85ee2559f31b");
        projectDAO.commit();
    }

    @Test
    public void findAllProjectByUserId() {
        final List<Project> list = projectDAO.findAllProjectByUserId("1");
        for (Project p : list) {
            System.out.println("ID: " + p.getId() + " NAME: " + p.getName() + " DESC: " + p.getDescription());
        }
    }

    @Test
    public void findById() {
        final Project project = projectDAO.findOne("59d52f2d-02d3-462f-bee8-d84814cd8420");
        System.out.println(project.getStatus());

    }

    @Test
    public void removeAllByUserId() {
        projectDAO.removeAllProjectByUserId("1");
        projectDAO.commit();
    }

    @Test
    public void updateDate() {
        final Project project = projectDAO.findOne("03b37a77-1a0d-48db-8a9e-ce8c45913969");
        project.setName("ROMANOO");
        projectDAO.removeById(project.getId());
        projectDAO.commit();
        projectDAO.insert(project);
        projectDAO.commit();
    }

    @Test
    public void findAllId() {
        for (String s : projectDAO.ids()) System.out.println(s);
    }

}
