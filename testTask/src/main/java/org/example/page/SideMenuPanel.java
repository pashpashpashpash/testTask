package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class SideMenuPanel extends BasePage {

   private static String locator = "//div[contains(@class, 'mainNavigationInflow')]";
   private Button issuesButton = new Button("//a[@href='issues']", "issuesButton");
   private Button articlesButton = new Button("//a[@href='articles']", "articlesButton");
   private Button dashboardButton = new Button("//a[@href='dashboard']", "dashboardButton");
   private Button timeSheetsButton = new Button("//a[@href='timesheets']", "timesheetsButton");
   private Button projectsButton = new Button("//a[@href='projects']", "projectsButton");

    public SideMenuPanel(String name) {
        super(locator, name);
    }


    public void clickIssuesButton() {
        waitForVisibility();
        waitForClickable(issuesButton.getLocator());
        issuesButton.click();
    }

    public void clickArticlesButton() {
        waitForVisibility();
        waitForClickable(articlesButton.getLocator());
        articlesButton.click();
    }

    public void clickTimeSheetsButton() {
        waitForVisibility();
        waitForClickable(timeSheetsButton.getLocator());
        timeSheetsButton.click();
    }

    public void clickDashboardButton() {
        waitForVisibility();
        waitForClickable(dashboardButton.getLocator());
        dashboardButton.click();
    }

    public void clickProjectsButton() {
        projectsButton.click();
    }

   /* public void clickLoginButton() {
        loginButton.click();}

    public void clickCartButton() {
        cartButton.click();
    }*/

}
