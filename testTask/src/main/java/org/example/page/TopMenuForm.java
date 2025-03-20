package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class TopMenuForm extends BasePage {

    private static String locator = "//a[@class='ib']";
    private Button interviewsButton = new Button("//a[contains(text(), 'Интервью')]", "interviewsButton");
    private Button questionsButton = new Button("//a[contains(text(), 'Вопросы')]", "questionsButton");
    private Button quizButton = new Button("//a[contains(text(), 'Квизы')]", "quizButton");
    private Button modulesButton = new Button("//a[contains(text(), 'Модули')]", "modulesButton");


    public TopMenuForm(String name) {
        super(locator, name);
    }

    public void clickInterviewsButton() {
        interviewsButton.click();
    }

    public void clickQuestionsButton() {
        questionsButton.click();
    }

    public void clickQuizButton() {
        quizButton.click();
    }

    public void clickModulesButton() {
        modulesButton.click();
    }

}
