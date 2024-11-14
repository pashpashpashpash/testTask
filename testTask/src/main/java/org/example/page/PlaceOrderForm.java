package org.example.page;

import org.example.framework.elements.Button;
import org.example.framework.elements.TextField;
import org.example.framework.page.BasePage;

public class PlaceOrderForm extends BasePage {

    private static String locator = "//h5[@id='orderModalLabel']";
    private TextField nameTextField = new TextField("//input[@id='name']", "Name");
    private TextField countryTextField = new TextField("//input[@id='country']", "Country");
    private TextField cityTextField = new TextField("//input[@id='city']", "City");
    private TextField creditCardTextField = new TextField("//input[@id='card']", "CreditCard");
    private TextField monthTextField = new TextField("//input[@id='month']", "Month");
    private TextField yearTextField = new TextField("//input[@id='year']", "Year");
    private Button purchaseButton = new Button("//button[contains(text(), 'Purchase')]", "Purchase");

    public PlaceOrderForm(String name) {
        super(locator, name);
    }

    public void clickPurchaseButton() {
        purchaseButton.click();
    }

    public void inputName(String name) {
        waitForClickable(nameTextField.getLocator());
        nameTextField.setText(name);
    }

    public void inputCountry(String country) {
        waitForClickable(countryTextField.getLocator());
        countryTextField.setText(country);
    }

    public void inputCity(String city) {
        waitForClickable(cityTextField.getLocator());
        cityTextField.setText(city);
    }

    public void inputCreditCard(String creditCard) {
        waitForClickable(creditCardTextField.getLocator());
        creditCardTextField.setText(creditCard);
    }

    public void inputMonth(String month) {
        waitForClickable(monthTextField.getLocator());
        monthTextField.setText(month);
    }

    public void inputYear(String year) {
        waitForClickable(yearTextField.getLocator());
        yearTextField.setText(year);
    }

}
