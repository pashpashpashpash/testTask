package org.example.framework.elements;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.framework.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseElement {

    protected static final Logger logger = LogManager.getLogger();
    private static final int RETRY_NUMBER = 1500;

    private By locator;
    private String xPathLocator;
    private String name;

    public BaseElement(String locator, String name) {
        xPathLocator = locator;
        this.locator = By.xpath(locator);
        this.name = name;
    }

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public void click() {
        for (int i = 1; i <= RETRY_NUMBER; i++) {
            try {
                findElement().click();
                return;
            }
            catch (StaleElementReferenceException ex) {
                logger.info("StaleElementReferenceException was thrown: try #"+ i +"/" + RETRY_NUMBER);
            }
        }
        logger.info(name + " click");
    }

    public WebElement findElement() {

        for (int i = 1; i <= RETRY_NUMBER; i++) {
            try {
                logger.info("Trying to find element " + name);
                return DriverManager.getInstance().findElement(locator);
            }
            catch (NoSuchElementException ex) {
                logger.info("NoSuchElementException was thrown: try #"+ i +"/" + RETRY_NUMBER);
            }
        }
        return DriverManager.getInstance().findElement(locator);
    }

    public List<WebElement> findElements() {
        logger.info("Trying to find element " + name);
        return DriverManager.getInstance().findElements(locator);
    }

    public By getLocator() {
        return locator;
    }

    public void setLocator(By locator) {
        this.locator = locator;
    }

    public String getXPathLocator() {
        return xPathLocator;
    }

    public void setXPathLocator(String locator) {
        this.xPathLocator = locator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
