package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class AddModuleModal extends BasePage {

    private static String locator = "//h3[contains(text(), 'Создать запись')]";
    private TextField nameTextField = new TextField("//input[@placeholder='Название']", "nameTextField");
    private Button createButton = new Button("//button[contains(text(), 'Создать')]", "createButton");
    private Button moveByIdButton = new Button("//button[contains(text(), 'Переместить по Id')]", "moveByIdButton");
    private TextField questionIdTextField = new TextField("//input[@placeholder='ID для перемещения']", "questionIdTextField");



    public AddModuleModal(String name) {
        super(locator, name);
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void clickMoveByIdButton() {
        moveByIdButton.click();
    }

    public void inputModuleName(String name) {
      //  waitForClickable(userNameTextField.getLocator());
        nameTextField.setText(name);
    }

    public void inputQuestionId(String id) {
        //  waitForClickable(userNameTextField.getLocator());
        questionIdTextField.setText(id);
    }
}
