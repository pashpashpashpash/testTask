package org.example.page;

import org.example.framework.driver.DriverManager;
import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KnowledgeBasePage extends BasePage {

    private static String locator = "//a[@data-test='articlesCreateButtonContainer']";
    private Button addArticleButton = new Button("//a[@data-test='articlesCreateButtonContainer']", "addArticleButton");
    private Button publishButton = new Button("//button[@data-test='publish-button']", "publishButton");
    private Button selectProjectToPublishButton = new Button("//span[@data-test='ring-list-item-label'][1]", "selectProjectToPublish");
    private TextField newArticleTitleTextField = new TextField("//input[@data-test='summary']", "newArticleTitle");
    private String createdArticleItemLocator = "//span[@data-test='ring-tooltip article-summary' and contains(text(), '%s')]";
    private String deleteItemLocator = "//button[contains(@class, 'delete')]";
    private String confirmDeleteButtonLocator = "//button[@data-test='confirm-ok-button']";
    private String itemMenuLocator = "//button[@data-test='article-menu']";
    private final int RETRY_COUNT = 50;



    public KnowledgeBasePage(String name) {
        super(locator, name);
    }

    public void enterArticleTitle(String title) {
        waitForClickable(newArticleTitleTextField.getLocator());
        newArticleTitleTextField.setText(title);
    }

    public void clickAddArticleButton() {
       addArticleButton.click();
    }

    public void clickPublishButton() {
        publishButton.click();
    }

    public void clickSelectProjectButton() {
        selectProjectToPublishButton.click();
    }

    public void clickDeleteButton(String articleTitle) {
        TextField articleTitleItem = new TextField(String.format(createdArticleItemLocator, articleTitle), "articleItemTitle");
        Actions action = new Actions(DriverManager.getInstance());
        action.moveToElement(articleTitleItem.findElement()).moveToElement(DriverManager.getInstance().findElement(By.xpath(itemMenuLocator))).click().build().perform();
        Button deleteButton = new Button(deleteItemLocator, "deleteButton");
        Button confirmDeleteButton = new Button(confirmDeleteButtonLocator, "confirmDeleteButton");
        deleteButton.click();
        confirmDeleteButton.click();
    }

    public boolean containsArticle(String articleTitle) {
        TextField articleTitleItem = new TextField(String.format(createdArticleItemLocator, articleTitle), "articleItemTitle");
        boolean result = false;
        for(int i = 0; i <= RETRY_COUNT; i++) {
            if (articleTitleItem.findElements().isEmpty()) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }

}
