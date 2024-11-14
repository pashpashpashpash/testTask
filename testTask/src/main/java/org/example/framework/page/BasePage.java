package org.example.framework.page;

import org.example.framework.driver.DriverManager;
import org.example.framework.elements.BaseElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private String locator;
    private String name;
    private final long TIME_OUT_IN_SECONDS = 10;
    private WebDriverWait wait = new WebDriverWait(DriverManager.getInstance(), Duration.ofSeconds(TIME_OUT_IN_SECONDS));

    public BasePage(String locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public boolean isDisplayed() {
       waitForVisibility();
       return new BaseElement(locator, name).findElement().isDisplayed();
    };

    public String getLocator() {
        return locator;
    }

    protected void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForVisibility() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    protected void waitForNotDisplayed(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public Alert getAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return DriverManager.getInstance().switchTo().alert();
    }
}
