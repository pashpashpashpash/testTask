package org.example.framework.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.framework.util.DataUtil;
import org.openqa.selenium.WebDriver;

import java.util.List;

/*
* Class implements singleton pattern for webDriver
*/

public class DriverManager {

    protected static final Logger logger = LogManager.getLogger();

    private static WebDriver driver = null;

    private static DataUtil dataUtil = new DataUtil();

    private static List<String> options;

    private DriverManager(){}

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = createInstance(dataUtil.getAppProps().getProperty("driverName"));
        }
        return driver;
    }

    public static WebDriver createInstance(String driverName) {
        logger.info("Trying to create driver instance");
        driver =  DriverFactory.valueOf(driverName).createDriver();
        return driver;
    }


    public static void quit() {
        logger.info("Closing driver instance");
        driver.quit();
        driver = null;
    }

}
