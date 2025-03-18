package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class IssuePage extends BasePage {

    private static String locator = "//h1[@data-test='ticket-summary']";
    private TextField commentTextField = new TextField("//div[@data-test='wysiwyg-editor-content']", "commentTextField");
    private String postedCommentLocator = "//p[contains(text(), '%s')]";
    private Button postCommentButton = new Button("//button[@data-test='post-comment']", "postCommentButton");
    private Button menuButton = new Button("//div[@class='summaryToolbar__c231']/div/span[4]", "menuButton");
    private Button deleteTaskButton = new Button("//button[contains(@class, 'deleteIcon')]", "deleteTaskButton");
    private Button confirmDeleteButton = new Button("//button[@data-test='confirm-ok-button']", "confirmDeleteButton");


    public IssuePage(String name) {
        super(locator, name);
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickDeleteButton() {
        deleteTaskButton.click();
    }

    public void clickConfirmDeleteButton() {
        confirmDeleteButton.click();
    }

    public void enterCommentText(String comment) {
        waitForClickable(commentTextField.getLocator());
        commentTextField.setText(comment);
    }

    public void clickPostCommentButton() {
       postCommentButton.click();
    }

    public boolean containsComment(String comment) {
        TextField postedComment = new TextField(String.format(postedCommentLocator, comment), "postedCommentText");
        if (postedComment.findElements().isEmpty()) {
            return false;
        }
        else {
            return true;
        }
    }

}
