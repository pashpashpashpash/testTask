package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class CreateIssueForm extends BasePage {

    private static String locator = "//button[@data-test='submit-button']";
    private TextField titleTextField = new TextField("//textarea[@data-test='summary']", "titleTextField");
    private TextField passwordTextField = new TextField("//input[@id='password']", "passwordTextField");
    private Button submitButton = new Button("//button[@data-test='submit-button']", "loginButton");
    private Button closeButton = new Button("//button[@data-test='ring-dialog-close-button']", "closeButton");
    private TextField alertTextField = new TextField("//div[@data-test='alert']", "alert");

    public CreateIssueForm(String name) {
        super(locator, name);
    }

    public void clickSubmitButton() {
        submitButton.click();
        waitForClickable(alertTextField.getLocator());
    }

    public void clickCloseButton() {
        waitForClickable(closeButton.getLocator());
        closeButton.click();
    }

    public void inputTitle(String title) {
        waitForClickable(titleTextField.getLocator());
        titleTextField.setText(title);
    }

}
