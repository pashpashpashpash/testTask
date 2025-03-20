package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class AddQuestionModal extends BasePage {

    private static String locator = "//h3[contains(text(), 'Создать запись')]";
    private TextField questionTextField = new TextField("//textarea[contains(@class, 'text-input')]", "questionTextField");
    private Button createButton = new Button("//button[contains(text(), 'Создать')]", "createButton");

    public AddQuestionModal(String name) {
        super(locator, name);
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void inputQuestion(String question) {
      //  waitForClickable(userNameTextField.getLocator());
        questionTextField.setText(question);
    }
}
