package org.example.steps;

import org.example.page.AddInterviewModal;
import org.example.page.CartPage;
import org.example.page.CatalogItemPage;
import org.example.page.ConfirmedPurchaseAlert;
import org.example.page.InterviewsPage;
import org.example.page.LoginForm;
import org.example.page.PlaceOrderForm;
import org.example.page.TopMenuForm;
import org.testng.Assert;

public class UiSteps {

     TopMenuForm topMenuForm = new TopMenuForm("TopMenuForm");
    LoginForm loginForm = new LoginForm("LoginForm");
    InterviewsPage interviewsPage = new InterviewsPage("InterviewsPage");
    AddInterviewModal addInterviewModal = new AddInterviewModal("addInterviewModal");
   // HomePage homePage = new HomePage("HomePage");
   // CartPage cartPage = new CartPage("CartPage");
   // CatalogItemPage catalogItemPage = new CatalogItemPage("CatalogItemPage");
   // PlaceOrderForm placeOrderForm = new PlaceOrderForm("PlaceOrderForm");
   // ConfirmedPurchaseAlert confirmedPurchaseAlert = new ConfirmedPurchaseAlert("ConfirmedPurchaseAlert");

    public void login(String username, String password) {
      //  topMenuForm.clickLoginButton();

        Assert.assertTrue(loginForm.isDisplayed());

        loginForm.inputUserName(username);
        loginForm.inputPassword(password);
        loginForm.clickLoginButton();
       // loginForm.waitForLoginFormInactivate();
        Assert.assertTrue(topMenuForm.isDisplayed());
    }

    public void goToInterviewsPage() {
        topMenuForm.clickInterviewsButton();

        Assert.assertTrue(interviewsPage.isDisplayed());
    }

    public void clickAddInterviewButton() {
        interviewsPage.clickAddButton();

        Assert.assertTrue(addInterviewModal.isDisplayed());
    }

    public void createInterview(String interviewName) {
        addInterviewModal.inputName(interviewName);
        addInterviewModal.clickCreateButton();
      //  Assert.assertFalse(addInterviewModal.isDisplayed());
    }

    public void checkInterviewPresent(String name) {
        Assert.assertTrue(interviewsPage.isInterviewPresent(name));
    }


   /* public String addItemToCart() {
        String itemPrice = catalogItemPage.getPriceValue();
        catalogItemPage.clickAddToCartButton();
        catalogItemPage.getAlert().accept();
        return itemPrice;
    }

    public void goToCart() {
        topMenuForm.clickCartButton();

        Assert.assertTrue(cartPage.isDisplayed());
    }

    public String getItemPriceFromCart() {
        return cartPage.getPrice();
    }

    public String placeOrder(String name,String country, String city, String card, String month, String year) {
        cartPage.placeOrderButtonClick();

        Assert.assertTrue(placeOrderForm.isDisplayed());

        placeOrderForm.inputName(name);
        placeOrderForm.inputCountry(country);
        placeOrderForm.inputCity(city);
        placeOrderForm.inputCreditCard(card);
        placeOrderForm.inputMonth(month);
        placeOrderForm.inputYear(year);
        placeOrderForm.clickPurchaseButton();
        return confirmedPurchaseAlert.getPriceValue();
    }*/

}
