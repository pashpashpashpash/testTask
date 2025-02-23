package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class TopMenuForm extends BasePage {

    private static String locator = "//a[@class='ib']";
    private Button interviewsButton = new Button("//a[contains(text(), 'Интервью')]", "interviewsButton");
 //   private Button cartButton = new Button("//a[@id='cartur']", "cartButton");

    public TopMenuForm(String name) {
        super(locator, name);
    }

   /* public void clickLoginButton() {
        loginButton.click();
    }*/

    public void clickInterviewsButton() {
        interviewsButton.click();
    }

}
