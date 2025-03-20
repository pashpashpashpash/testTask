package org.example.testcase.task2;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class AddModuleTest extends BaseTest {

    @Test
    public void addModuleTest() {
        logger.info("Test method started");
        logger.info("Step 0: Login");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));

        logger.info("Step 1: Go to quiz page");
        uiSteps.goToQuizPage();

        logger.info("Step 2: Click ADD button");
        uiSteps.clickAddQuizButton();
        logger.info("Step 3: enter quiz name and click create button");

        String quizText = RandomStringUtils.randomAlphabetic(10);
        uiSteps.createQuiz(quizText);

        logger.info("Step 4: check created quiz");
        uiSteps.checkQuizPresent(quizText);

        logger.info("Test method ended");
    }
}
