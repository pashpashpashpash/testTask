package org.example.page;

import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class ConfirmedPurchaseAlert extends BasePage {

    private static String locator = "//h2[contains(text(),'Thank you for your purchase!')]";
    private TextField purchaseInfoTextField = new TextField("//p[@class='lead text-muted ']", "PurchaseInfo");

    public ConfirmedPurchaseAlert(String name) {
        super(locator, name);
    }

    public String getPriceValue() {
        String[] strarr = purchaseInfoTextField.getText().split("\n");
        return strarr[1].replaceAll("[^0-9.,]+","");
    }

}
