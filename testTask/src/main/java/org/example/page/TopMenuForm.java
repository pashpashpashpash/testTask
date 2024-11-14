package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class TopMenuForm extends BasePage {

    private static String locator = "//div[@id='navbarExample']";
    private Button loginButton = new Button("//a[@id='login2']", "loginButton");
    private Button cartButton = new Button("//a[@id='cartur']", "cartButton");

    public TopMenuForm(String name) {
        super(locator, name);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

}
