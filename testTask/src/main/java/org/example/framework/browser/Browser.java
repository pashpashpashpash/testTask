package org.example.framework.browser;

import org.example.framework.driver.DriverManager;

public class Browser {

    private TabHelper tabHelper = new TabHelper();

    public void goToUrl(String url) {
        DriverManager.getInstance().get(url);
        DriverManager.getInstance().manage().window().maximize();

    }

    public void switchToNewTab(){
        tabHelper.switchToNewTab();
    }

    public void switchToPreviousTab(){
        tabHelper.switchToPreviousTab();
    }
}
