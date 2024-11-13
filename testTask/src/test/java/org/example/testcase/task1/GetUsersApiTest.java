package org.example.testcase.task1;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.steps.AssertionSteps;
import org.example.util.JsonHelper;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GetUsersApiTest extends BaseTest {

    @Test
    public void checkUsersEmailsIsValidTest() {
        Response response = apiSteps.getAllUsers(propertiesUtil.getTestProps().getProperty("usersCount"));

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        AssertionSteps.assertUsersEmailsIsValid(JsonHelper.parseUsersEmails(response));
    }
}
