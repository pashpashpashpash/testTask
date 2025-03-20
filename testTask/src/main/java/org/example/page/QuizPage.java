package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class QuizPage extends BasePage {

    private static String locator = "//button[contains(text(), 'Квиз')]";
    private Button addButton = new Button("//button[contains(text(), '+ Добавить')]", "addButton");
    private String quizTableLocator = "//span[contains(text(), '%s')]";

    public QuizPage(String name) {
        super(locator, name);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public boolean isQuizPresent(String name) {
        Button quizButton = new Button(String.format(quizTableLocator, name), "quizButton");
        return quizButton.findElement().isDisplayed();
    }

}
