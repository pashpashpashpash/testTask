package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class IssuesPage extends BasePage {

    private static String locator = "//a[@data-test='createIssueButton']";
    private Button createIssueButton = new Button("//a[@data-test='createIssueButton']", "CreateIssueButton");
    private String issueItemLocator = "//a[contains(@href, '%s')]";
    private String issueItemLinkLocator = "//a[contains(@href, '%s') and @data-test='ring-link ticket-id']";
    private Button catalogItemLink;
    private final int RETRY_COUNT = 50;

    public IssuesPage(String name) {
        super(locator, name);
    }

    public void clickCreateIssueButton() {
        createIssueButton.click();
    }

    public boolean isContainsIssue(String title) {
        TextField issueItem = new TextField(String.format(issueItemLocator, title), "issue " + title);
        boolean result = false;
        for(int i = 0; i <= RETRY_COUNT; i++) {
            if (issueItem.findElements().isEmpty()) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }

    public void clickIssueItem(String title) {
        TextField issueItem = new TextField(String.format(issueItemLinkLocator, title), "issue " + title);
        waitForClickable(issueItem.getLocator());
        issueItem.click();
    }

}
