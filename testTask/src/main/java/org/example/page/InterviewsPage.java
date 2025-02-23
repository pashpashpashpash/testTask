package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class InterviewsPage extends BasePage {

    private static String locator = "//button[contains(text(), 'Оффер')]";
    private Button addButton = new Button("//button[contains(text(), '+ Добавить')]", "addButton");
    private String interviewTableLocator = "//span[contains(text(), '%s')]";

    public InterviewsPage(String name) {
        super(locator, name);
    }



    public void clickAddButton() {
        addButton.click();
    }

    public boolean isInterviewPresent(String name) {
        Button interviewButton = new Button(String.format(interviewTableLocator, name), "interviewButton");
        return interviewButton.findElement().isDisplayed();
    }

}
