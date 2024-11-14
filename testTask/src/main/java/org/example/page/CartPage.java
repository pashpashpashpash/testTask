package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class CartPage extends BasePage {

    private static String locator = "//h2[contains(text(), 'Total')]";
    private TextField priceCell = new TextField("//td[3]", "priceCell");
    private Button placeOrderButton = new Button("//button[contains(text(), 'Place Order')]", "Place order");



    public CartPage(String name) {
        super(locator, name);
    }

    public void placeOrderButtonClick() {
        placeOrderButton.click();
    }

    public String getPrice() {
        return priceCell.getText();
    }

}
