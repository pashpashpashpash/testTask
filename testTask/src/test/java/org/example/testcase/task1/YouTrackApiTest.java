package org.example.testcase.task1;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.example.constant.RequestKey.*;

public class YouTrackApiTest extends BaseTest {

    String issueTitle;
    String issueId;
    String commentId;

    @Test(priority = 1)
    public void createIssueTest() {
        issueTitle = RandomStringUtils.random(10, true, true);
        Response response = apiSteps.createIssue(issueTitle, propertiesUtil.getTestProps().getProperty("projectId"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        JsonPath path = new JsonPath(response.body().asString());
        issueId = path.getString(ID);
        response = apiSteps.getIssue(issueId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        path = new JsonPath(response.body().asString());
        String taskSummary = path.getString(SUMMARY);

        Assert.assertEquals(taskSummary, issueTitle);
    }

    @Test(priority = 2)
    public void commentIssueTest() {
        String commentText = RandomStringUtils.random(10, true, true);
        Response response = apiSteps.commentIssue(issueId, commentText);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        response = apiSteps.getIssueComments(issueId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        JsonPath path = new JsonPath(response.body().asString());
        commentId = path.getString("[0].id");
        String actual = path.getString("[0].text");

        Assert.assertTrue(actual.contains(commentText));
    }

    @Test(priority = 3)
    public void deleteCommentTest() {
        Response response = apiSteps.getComment(issueId, commentId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        response = apiSteps.deleteComment(issueId, commentId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        response = apiSteps.getComment(issueId, commentId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test(priority = 4)
    public void deleteIssueTest() {
        issueTitle = RandomStringUtils.random(10, true, true);
        Response response = apiSteps.deleteIssue(issueId);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        response = apiSteps.getIssue(issueId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
    }

    @Test(priority = 1)
    public void createArticleTest() {
        String articleSummary = RandomStringUtils.random(10, true, true);
        Response response = apiSteps.createArticle(articleSummary, propertiesUtil.getTestProps().getProperty("projectId"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        JsonPath path = new JsonPath(response.body().asString());
        String articleId = path.getString(ID);
        response = apiSteps.getArticle(articleId);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        path = new JsonPath(response.body().asString());
        String summary = path.getString(SUMMARY);

        Assert.assertEquals(articleSummary, summary);
    }
}
