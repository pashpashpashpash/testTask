package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;
import org.openqa.selenium.Keys;

public class ProjectTeamAddWidgetForm extends BasePage {

    private static String locator = "//span[contains(text(), 'Project Team')]";
    private Button projectSearchButton = new Button("//div[@data-test='ring-select']", "projectSearch");
    private Button saveButton = new Button("//div[@data-test='apply-button']/button[1]", "save");
    private TextField projectSearchField = new TextField("//input[@data-test-custom='ring-select-popup-filter-input']", "projectSearch");



    public ProjectTeamAddWidgetForm(String name) {
        super(locator, name);
    }

    public void clickProjectSearchButton() {
        projectSearchButton.click();
    }

    public void enterProjectName(String projectName) {
       projectSearchField.setText(projectName);
       projectSearchField.findElement().sendKeys(Keys.ENTER);
    }

    public void clickSaveButton() {
        saveButton.click();
    }


}
