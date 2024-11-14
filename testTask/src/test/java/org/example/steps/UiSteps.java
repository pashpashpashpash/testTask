package org.example.steps;

import org.example.page.CartPage;
import org.example.page.CatalogItemPage;
import org.example.page.ConfirmedPurchaseAlert;
import org.example.page.HomePage;
import org.example.page.LoginForm;
import org.example.page.PlaceOrderForm;
import org.example.page.TopMenuForm;

public class UiSteps {

    TopMenuForm topMenuForm = new TopMenuForm("TopMenuForm");
    LoginForm loginForm = new LoginForm("LoginForm");
    HomePage homePage = new HomePage("HomePage");
    CartPage cartPage = new CartPage("CartPage");
    CatalogItemPage catalogItemPage = new CatalogItemPage("CatalogItemPage");
    PlaceOrderForm placeOrderForm = new PlaceOrderForm("PlaceOrderForm");
    ConfirmedPurchaseAlert confirmedPurchaseAlert = new ConfirmedPurchaseAlert("ConfirmedPurchaseAlert");

    public void login(String username, String password) {
        topMenuForm.clickLoginButton();
        loginForm.inputUserName(username);
        loginForm.inputPassword(password);
        loginForm.clickLoginButton();
        loginForm.waitForLoginFormInactivate();
    }

    public void goToCatalogItemPage(int catalogItemNumber) {
        homePage.catalogItemClick(1);
    }

    public String addItemToCart() {
        String itemPrice = catalogItemPage.getPriceValue();
        catalogItemPage.clickAddToCartButton();
        catalogItemPage.getAlert().accept();
        return itemPrice;
    }

    public void goToCart() {
        topMenuForm.clickCartButton();
    }

    public String getItemPriceFromCart() {
        return cartPage.getPrice();
    }

    public String placeOrder(String name,String country, String city, String card, String month, String year) {
        cartPage.placeOrderButtonClick();
        placeOrderForm.inputName(name);
        placeOrderForm.inputCountry(country);
        placeOrderForm.inputCity(city);
        placeOrderForm.inputCreditCard(card);
        placeOrderForm.inputMonth(month);
        placeOrderForm.inputYear(year);
        placeOrderForm.clickPurchaseButton();
        return confirmedPurchaseAlert.getPriceValue();
    }

}
