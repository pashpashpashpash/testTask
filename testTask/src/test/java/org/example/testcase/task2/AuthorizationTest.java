package org.example.testcase.task2;

import org.testng.annotations.Test;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorizationTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the login page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));

        logger.info("Test method ended");
    }
}
