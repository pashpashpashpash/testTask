package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class AddInterviewModal extends BasePage {

    private static String locator = "//h3[contains(text(), 'Создать запись')]";
    private TextField nameTextField = new TextField("//input[@placeholder='Название']", "nameTextField");
    private Button createButton = new Button("//button[contains(text(), 'Создать')]", "createButton");

    public AddInterviewModal(String name) {
        super(locator, name);
    }

    public void clickCreateButton() {
        createButton.click();

    }

    public void inputName(String name) {
      //  waitForClickable(userNameTextField.getLocator());
        nameTextField.setText(name);
    }
}
