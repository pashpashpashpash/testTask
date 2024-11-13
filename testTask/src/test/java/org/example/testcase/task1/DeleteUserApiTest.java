package org.example.testcase.task1;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteUserApiTest extends BaseTest {


    @Test
    public void deleteUserTest() {
        Response response = apiSteps.deleteUser(propertiesUtil.getTestProps().getProperty("deleteUserId"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NO_CONTENT);
    }
}
