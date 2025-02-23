package org.example.testcase.task2;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class AddInterviewTest extends BaseTest {

    @Test
    public void addInterviewTest() {
        logger.info("Test method started");
        logger.info("Step 0: Login");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));

        logger.info("Step 1: Go to interviews page");
        uiSteps.goToInterviewsPage();

        logger.info("Step 2: Click ADD button");
        uiSteps.clickAddInterviewButton();
        logger.info("Step 3: enter interview name and click create button");

        String interviewName = RandomStringUtils.randomAlphabetic(10);
        uiSteps.createInterview(interviewName);

        logger.info("Step 4: check created interview");
        uiSteps.checkInterviewPresent(interviewName);

        logger.info("Test method ended");
    }
}
