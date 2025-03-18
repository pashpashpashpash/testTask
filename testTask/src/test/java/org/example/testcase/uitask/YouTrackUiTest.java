package org.example.testcase.uitask;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;


public class YouTrackUiTest extends BaseTest {

    String taskTitle;
    String articleTitle;
    String projectName;

    @Test(priority = 1)
    public void loginTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));

    }

    @Test(priority = 2)
    public void addTaskTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Add issue");
        taskTitle = RandomStringUtils.random(10, true, true);
        uiSteps.addIssue(taskTitle);
    }


    @Test(priority = 3)
    public void addCommentTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Add comment");
        String comment = RandomStringUtils.random(10, true, true);
        uiSteps.addComment(taskTitle, comment);
    }

    @Test(priority = 4)
    public void deleteTaskTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Delete issue");

        uiSteps.deleteIssue(taskTitle);
    }

    @Test(priority = 5)
    public void createArticleTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Add article");
        String articleTitle = RandomStringUtils.random(10, true, true);
        uiSteps.addArticle(articleTitle);
    }

    @Test(priority = 6)
    public void deleteArticleTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Delete article");
        uiSteps.deleteArticle(articleTitle);
    }

    @Test(priority = 7)
    public void addWidgetTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Add widget");
        uiSteps.addWidget(dataUtil.getTestProps().getProperty("addWidgetName"));
    }

    @Test(priority = 8)
    public void addProjectTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Add project");
        projectName = RandomStringUtils.random(10, true, true);
        uiSteps.addProject(projectName);
    }

    @Test(priority = 9)
    public void deleteProjectTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Step 3: Delete project");
        uiSteps.deleteProject(projectName);
    }

}
