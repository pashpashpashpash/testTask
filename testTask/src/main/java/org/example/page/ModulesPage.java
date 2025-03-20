package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class ModulesPage extends BasePage {

    private static String locator = "//button[contains(text(), 'Избранное')]";
    private Button addButton = new Button("//button[contains(text(), '+ Добавить')]", "addButton");
    private String questionIdTableLocator = "//div[contains(text(), '%s')]/parent::td/parent::tr//td[13]//span";

    public ModulesPage(String name) {
        super(locator, name);
    }



    public void clickAddButton() {
        addButton.click();
    }

    public boolean isQuestionPresent(String name) {
        Button questionButton = new Button(String.format(questionIdTableLocator, name), "questionIdButton");
        return questionButton.findElement().isDisplayed();
    }

    public String getQuestionId(String name) {
        Button questionButton = new Button(String.format(questionIdTableLocator, name), "questionIdButton");
        return questionButton.findElement().getText();

    }

}
