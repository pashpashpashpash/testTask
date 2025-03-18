package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class ProjectPage extends BasePage {

    private static String locator = "//h1[@data-test='project-heading']";
    private TextField projectTitle = new TextField("//h1[@data-test='project-heading']", "projectTitle");

    public ProjectPage(String name) {
        super(locator, name);
    }

    public String getProjectName() {
        return projectTitle.getText();
    }
}
