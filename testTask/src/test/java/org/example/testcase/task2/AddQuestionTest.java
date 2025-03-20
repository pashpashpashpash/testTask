package org.example.testcase.task2;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class AddQuestionTest extends BaseTest {





    @Test
    public void addQuestionTest() {
        logger.info("Test method started");
        logger.info("Step 0: Login");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));

        logger.info("Step 1: Go to questions page");
        uiSteps.goToQuestionsPage();

        logger.info("Step 2: Click ADD button");
        uiSteps.clickAddQuestionButton();
        logger.info("Step 3: enter question name and click create button");

        String questionText = RandomStringUtils.randomAlphabetic(10);
        uiSteps.createQuestion(questionText);

        logger.info("Step 4: check created question");
        uiSteps.checkQuestionPresent(questionText);

        logger.info("Test method ended");
    }
}
