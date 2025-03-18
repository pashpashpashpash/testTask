package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class ProjectsPage extends BasePage {

    private static String locator = "//a[@href='projects/create']";
    private Button createProjectButton = new Button("//a[@href='projects/create']", "CreateProject");
    private Button defaultTemplateButton = new Button("//button[@data-test='template'][1]", "defaultTemplate");
    private Button acceptButton = new Button("    //button[@data-test='accept-button']", "accept");
    private TextField projectName = new TextField("//input[@data-test='project-name']", "projectName");
    private Button createButton = new Button("//button[@data-test='create-button']", "create");
    private String projectMenuLocator = "//div[@data-test-name='%s']//div[@data-test='ring-dropdown project-app']";
    private Button deleteProjectButton = new Button("//span[contains(@class, 'delete')]//button", "delete");
    private TextField projectNameToDelete = new TextField("//div[@role='dialog']//input", "projectNameToDelete");
    private Button confirmDeleteProjectButton = new Button("    //button[@class='ring-ui-button_bc66 ring-ui-heightS_de02 ring-ui-primary_ea44']", "confirmDelete");

    private final int TRY_COUNT = 100;

    public ProjectsPage(String name) {
        super(locator, name);
    }

    public void clickCreateProjectButton() {
        createProjectButton.click();
    }

    public void clickAcceptButton() {
        acceptButton.click();
    }

    public void clickDefaultTemplateButton() {
        defaultTemplateButton.click();
    }

    public void enterProjectName(String projectTitle) {
        projectName.setText(projectTitle);
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void clickProjectMenuButton(String projectName) {
        Button projectMenuButton = new Button(String.format(projectMenuLocator, projectName), "projectMenu");
        projectMenuButton.click();
    }

    public void clickDeleteButton() {
        deleteProjectButton.click();
    }

    public void enterProjectNameToDelete(String projectName) {
        projectNameToDelete.setText(projectName);
    }

    public void clickConfirmDeleteButton() {
        confirmDeleteProjectButton.click();
    }

    public boolean isContainsProject(String projectTitle) {
        boolean result = false;
        Button projectMenuButton = new Button(String.format(projectMenuLocator, projectName), "projectMenu");
        for (int i = 0; i <= TRY_COUNT; i++) {
             if (projectMenuButton.findElements().isEmpty()) {
                 result = false;
             }
             else {
                 result = true;
             }
        }
        return result;
    }

}
