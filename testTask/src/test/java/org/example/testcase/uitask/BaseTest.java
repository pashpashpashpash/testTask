package org.example.testcase.uitask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.framework.browser.Browser;
import org.example.framework.driver.DriverManager;
import org.example.framework.util.DataUtil;
import org.example.steps.UiSteps;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected static final Logger logger = LogManager.getLogger();
    protected DataUtil dataUtil = new DataUtil();
    protected Browser browser = new Browser();
    protected UiSteps uiSteps = new UiSteps();

    @BeforeMethod
    public void setup() {
        logger.info("before method execution");
    }

    @AfterMethod
    public void cleanUp() {
        logger.info("cleanUp method execution");
        DriverManager.quit();
    }
}
