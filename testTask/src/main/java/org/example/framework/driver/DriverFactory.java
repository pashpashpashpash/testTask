package org.example.framework.driver;

import org.example.framework.util.DataUtil;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public enum DriverFactory {
    CHROME {
        @Override
        public WebDriver createDriver() {
            DataUtil dataUtil = new DataUtil();
            System.setProperty("webdriver.chrome.driver", dataUtil.getDriversPath() + "chromedriver.exe");
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            return chromeOptions;
        }
    },
    FIREFOX {
        @Override
        public WebDriver createDriver() {
            DataUtil dataUtil = new DataUtil();
            System.setProperty("webdriver.gecko.driver", dataUtil.getDriversPath() + "geckodriver.exe");
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions fireFoxOptions = new FirefoxOptions();
            fireFoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
            return fireFoxOptions;
        }
    };

    public abstract WebDriver createDriver();

    public abstract AbstractDriverOptions<?> getOptions();
}