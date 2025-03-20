package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class AddQuizModal extends BasePage {

    private static String locator = "//h3[contains(text(), 'Создать запись')]";
    private TextField quizTextField = new TextField("//textarea[contains(@class, 'text-input')]", "quizTextField");
    private Button createButton = new Button("//button[contains(text(), 'Создать')]", "createButton");

    public AddQuizModal(String name) {
        super(locator, name);
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void inputQuiz(String quizName) {
      //  waitForClickable(userNameTextField.getLocator());
        quizTextField.setText(quizName);
    }
}
