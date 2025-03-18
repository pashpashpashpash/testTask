package org.example.steps;

import org.example.framework.driver.DriverManager;
import org.example.page.*;
import org.testng.Assert;

public class UiSteps {

    LoginForm loginForm = new LoginForm("LoginForm");
    MonitoringPage monitoringPage = new MonitoringPage("monitoringPage");
    SideMenuPanel sideMenuPanel = new SideMenuPanel("sideMenuPanel");
    IssuesPage issuesPage = new IssuesPage("issuesPage");
    CreateIssueForm createIssueForm = new CreateIssueForm("createIssueForm");
    IssuePage issuePage = new IssuePage("IssuePage");
    ProjectsPage projectsPage = new ProjectsPage("ProjectsPage");
    ProjectPage projectPage = new ProjectPage("ProjectPage");
    KnowledgeBasePage knowledgeBasePage = new KnowledgeBasePage("KnowledgePage");
    ProjectTeamAddWidgetForm projectTeamAddWidgetForm = new ProjectTeamAddWidgetForm("projectTeamAddWidgetForm");

    public void login(String username, String password) {
        loginForm.inputUserName(username);
        loginForm.inputPassword(password);
        loginForm.clickLoginButton();

        Assert.assertTrue(monitoringPage.isDisplayed());
    }

    public void addIssue(String title) {
        sideMenuPanel.clickIssuesButton();
        Assert.assertTrue(issuesPage.isDisplayed());

        issuesPage.clickCreateIssueButton();
        Assert.assertTrue(createIssueForm.isDisplayed());

        createIssueForm.inputTitle(title);
        createIssueForm.clickSubmitButton();
        createIssueForm.clickCloseButton();

        Assert.assertTrue(issuesPage.isContainsIssue(title));
    }

    public void deleteIssue(String title) {
        sideMenuPanel.clickIssuesButton();
        Assert.assertTrue(issuesPage.isDisplayed());

        issuesPage.clickIssueItem(title);

        Assert.assertTrue(issuePage.isDisplayed());

        issuePage.clickMenuButton();
        issuePage.clickDeleteButton();
        issuePage.clickConfirmDeleteButton();

        Assert.assertTrue(issuesPage.isDisplayed());

        DriverManager.getInstance().navigate().refresh();

        Assert.assertTrue(issuesPage.isDisplayed());
        Assert.assertFalse(issuesPage.isContainsIssue(title));
    }

    public void addComment(String taskTitle, String comment) {
        sideMenuPanel.clickIssuesButton();

        Assert.assertTrue(issuesPage.isDisplayed());

        issuesPage.clickIssueItem(taskTitle);

        Assert.assertTrue(issuePage.isDisplayed());

        issuePage.enterCommentText(comment);
        issuePage.clickPostCommentButton();

        Assert.assertTrue(issuePage.containsComment(comment));
    }

    public void addArticle(String title) {
        sideMenuPanel.clickArticlesButton();

        Assert.assertTrue(knowledgeBasePage.isDisplayed());

        knowledgeBasePage.clickAddArticleButton();
        knowledgeBasePage.enterArticleTitle(title);
        knowledgeBasePage.clickPublishButton();
        knowledgeBasePage.clickSelectProjectButton();

        Assert.assertTrue(knowledgeBasePage.containsArticle(title));
    }

    public void deleteArticle(String title) {
        sideMenuPanel.clickArticlesButton();

        Assert.assertTrue(knowledgeBasePage.isDisplayed());

        knowledgeBasePage.clickDeleteButton(title);

        Assert.assertFalse(knowledgeBasePage.containsArticle(title));
    }

    public void addWidget(String widgetName) {
        sideMenuPanel.clickDashboardButton();

        Assert.assertTrue(monitoringPage.isDisplayed());

        int widgetCountBefore = monitoringPage.getWidgetCount();
        monitoringPage.clickAddWidgetButton();
        monitoringPage.selectWidgetItem(widgetName);
        int widgetCountAfter = monitoringPage.getWidgetCount();

        Assert.assertEquals(widgetCountAfter, widgetCountBefore + 1);

    }

    public void addProject(String projectName) {
        sideMenuPanel.clickProjectsButton();

        Assert.assertTrue(projectsPage.isDisplayed());

        projectsPage.clickCreateProjectButton();
        projectsPage.clickDefaultTemplateButton();
        projectsPage.clickAcceptButton();
        projectsPage.enterProjectName(projectName);
        projectsPage.clickCreateButton();

        Assert.assertTrue(projectPage.isDisplayed());

        Assert.assertEquals(projectName, projectPage.getProjectName());

    }

    public void deleteProject(String projectName) {
        sideMenuPanel.clickProjectsButton();

        Assert.assertTrue(projectsPage.isDisplayed());

        projectsPage.clickProjectMenuButton(projectName);
        projectsPage.clickDeleteButton();
        projectsPage.enterProjectNameToDelete(projectName);
        projectsPage.clickConfirmDeleteButton();

        Assert.assertFalse(projectsPage.isContainsProject(projectName));
    }

}
