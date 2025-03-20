package org.example.testcase.task2;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class PlatformSuite1Test extends BaseTest {

    private String createdQuestionID;

    @Test(priority=1)
    public void authorizationTest() {
        logger.info("Test method started");
        logger.info("Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));
        logger.info("Test method ended");
    }

    @Test(priority=2)
    public void addQuestionTest() {
        logger.info("Test method started");
        logger.info("Step 0: Login");
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
        createdQuestionID = uiSteps.getQuestionId(questionText);

        logger.info("Test method ended");
    }

    @Test(priority=3)
    public void addModuleTest() {
        logger.info("Test method started");
        logger.info("Step 0: Login");
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

    @Test(priority=3)
    public void addQuizTest() {
        logger.info("Test method started");
        logger.info("Step 0: Login");
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

    @Test(priority=3)
    public void addCourseTest() {
        logger.info("Test method started");
        logger.info("Step 0: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));

        logger.info("Step 1: Go to modules page");
        uiSteps.goToModulesPage();

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
