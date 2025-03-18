package org.example.page;

import org.example.framework.driver.DriverManager;
import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class MonitoringPage extends BasePage {

    private static String locator = "//button[@data-test='add-widget-button']";
    private Button addWidgetButton = new Button("//button[@data-test='add-widget-button']", "addWidget");
    private String widgetListItemLocator = "//span[contains(text(), '%s')]";
    private TextField widgetFrameLocator = new TextField("//div[@data-test='grid-item']", "widgetFrameLocator");
    private final int TRY_COUNT =100;

    public MonitoringPage(String name) {
        super(locator, name);
    }

    public void clickAddWidgetButton() {
        addWidgetButton.click();
    }

    public void selectWidgetItem(String widgetName) {
        Button widgetItemButton = new Button(String.format(widgetListItemLocator, widgetName), widgetName);
        widgetItemButton.click();
    }

    public int getWidgetCount() {
        int result = 0;
        for (int i = 0; i <= TRY_COUNT; i++) {
            result = widgetFrameLocator.findElements().size();
        }
        return result;
    }

}
