package org.example.testcase.task1;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationApiPositiveTest extends BaseTest {

    @Test
    public void registrationPositiveTest() {
        Response response = apiSteps.registerUser(propertiesUtil.getTestProps().getProperty("validUserEmail"),
                propertiesUtil.getTestProps().getProperty("validUserPassword"));
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    public void registrationNegativeTest() {
        Response response = apiSteps.registerUser(propertiesUtil.getTestProps().getProperty("validUserEmail"), "");
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST);
    }
}
