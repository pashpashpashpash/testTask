package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.page.BasePage;

public class HomePage extends BasePage {

    private static String locator = "//a[@id='cat']";
    private static String catalogItemLinkLocator = "//div[@class='col-lg-4 col-md-6 mb-4'][%s]//a[1]";
    private Button catalogItemLink;

    public HomePage(String name) {
        super(locator, name);
    }

    public void catalogItemClick(int id) {
        catalogItemLink = new Button(String.format(catalogItemLinkLocator, id), "CatalogItem#" + id +" Link");
        catalogItemLink.click();
    }

}
