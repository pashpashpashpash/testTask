package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class CatalogItemPage extends BasePage {

    private static String locator = "//h2[@class='name']";
    private TextField priceTextField = new TextField("//h3[@class='price-container']", "priceTextField");
    private Button addToCartButton = new Button("//a[contains(text(), 'Add to cart')]", "addToCart");


    public CatalogItemPage(String name) {
        super(locator, name);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getPriceValue() {
        return priceTextField.getText().replaceAll("[^0-9.,]+","");
    }

}
