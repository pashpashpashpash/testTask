package org.example.steps;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.api.RestUtil;
import org.example.model.CreateEntityRequest;
import org.example.model.Project;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.example.constant.PathConstants.*;
import static org.example.constant.RequestKey.*;

public class ApiSteps {

    private RestUtil restUtil = new RestUtil();

    public Response createIssue(String issueTitle, String projectId) {
        CreateEntityRequest createEntityRequestBody = new CreateEntityRequest(issueTitle, new Project(projectId));
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(createEntityRequestBody);
        return request.post(ISSUES_PATH);
    }

    public Response getIssue(String issueId) {
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam(FIELDS, SUMMARY);
        return request.get(ISSUES_PATH + "/" + issueId);
    }

    public Response deleteIssue(String issueId) {
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
        return request.delete(ISSUES_PATH + "/" + issueId);
    }

    public Response commentIssue(String issueId, String commentText) {
        Map<String, String> params = new HashMap<>();
        params.put(TEXT, commentText);
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(params);
        return request.post(ISSUES_PATH + "/" + issueId + COMMENTS_PATH);
    }

    public Response getIssueComments(String issueId) {
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .urlEncodingEnabled(false)
                .accept(ContentType.JSON)
                .queryParam(FIELDS, TEXT + "," + ID);
        return request.get(ISSUES_PATH + "/" + issueId + COMMENTS_PATH);
    }

    public Response deleteComment(String issueId, String commentId) {
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
        return request.delete(ISSUES_PATH + "/" + issueId + COMMENTS_PATH + "/" + commentId);
    }

    public Response getComment(String issueId, String commentId) {
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);
        return request.get(ISSUES_PATH + "/" + issueId + COMMENTS_PATH + "/" + commentId);
    }

    public Response createArticle(String articleSummary, String projectId) {
        CreateEntityRequest createEntityRequestBody = new CreateEntityRequest(articleSummary, new Project(projectId));
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(createEntityRequestBody);
        return request.post(ARTICLES_PATH);
    }

    public Response getArticle(String articleId) {
        RequestSpecification request = given(restUtil.getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .queryParam(FIELDS, SUMMARY);
        return request.get(ARTICLES_PATH + "/" + articleId);
    }

}
