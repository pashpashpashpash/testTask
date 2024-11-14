package org.example.framework.browser;

import org.example.framework.driver.DriverManager;

import java.util.ArrayList;

public class TabHelper {

    private String previousTab;

    public void switchToNewTab() {
        String currentTab = DriverManager.getInstance().getWindowHandle();
        ArrayList<String> tabs = new ArrayList<>(DriverManager.getInstance().getWindowHandles());
        int currentTabIndex = tabs.indexOf(currentTab);
        DriverManager.getInstance().switchTo().window(tabs.get(currentTabIndex + 1));
        previousTab = currentTab;
    }

    public void switchToPreviousTab() {
        DriverManager.getInstance().switchTo().window(previousTab);
    }
}
