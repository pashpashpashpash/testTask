package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;
import org.openqa.selenium.By;

public class LoginForm extends BasePage {

    private static String locator = "//div[contains(@class, 'login')]";
    private TextField userNameTextField = new TextField("//input[@id='username']", "loginTextField");
    private TextField passwordTextField = new TextField("//input[@id='password']", "passwordTextField");
    private Button loginButton = new Button("//button[contains(@class, 'auth')]", "loginButton");

    public LoginForm(String name) {
        super(locator, name);
    }

    public void clickLoginButton() {
        loginButton.click();

    }

    public void inputUserName(String username) {
        waitForClickable(userNameTextField.getLocator());
        userNameTextField.setText(username);
    }

    public void inputPassword(String password) {
        waitForClickable(userNameTextField.getLocator());
        passwordTextField.setText(password);
    }

}
