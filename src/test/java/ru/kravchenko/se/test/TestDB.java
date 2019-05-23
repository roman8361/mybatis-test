package ru.kravchenko.se.test;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Assert;
import org.junit.Test;
import ru.kravchenko.se.mybatis.entity.Project;
import ru.kravchenko.se.mybatis.service.ProjectService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class TestDB {

    private final Lorem lorem = new LoremIpsum();

    private final ProjectService projectDAO = new ProjectService();

    public TestDB() throws IOException { }

    @Test
    public void testCRUD() throws IOException {
        final List<Project> projectList = projectDAO.findAll();
        final Project project = new Project();
        project.setName(lorem.getFirstName());
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setDescription(lorem.getWords(4));

        projectDAO.insert(project);
        projectDAO.commit();

        final Project projectInsert = projectDAO.findOne(project.getId());
        Assert.assertNotNull(projectInsert);

        projectDAO.removeById(project.getId());
        projectDAO.commit();
        Assert.assertNull(projectDAO.findOne(project.getId()));
    }

}
