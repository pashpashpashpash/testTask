package org.example.steps;

import org.example.page.*;
import org.testng.Assert;

public class UiSteps {

     TopMenuForm topMenuForm = new TopMenuForm("TopMenuForm");
    LoginForm loginForm = new LoginForm("LoginForm");
    InterviewsPage interviewsPage = new InterviewsPage("InterviewsPage");
    AddInterviewModal addInterviewModal = new AddInterviewModal("addInterviewModal");
    AddQuestionModal addQuestionModal = new AddQuestionModal("addQuestionModal");
    AddQuizModal addQuizModal = new AddQuizModal("addQuizModal");
    QuestionsPage questionsPage = new QuestionsPage("QuestionsPage");
    QuizPage quizPage = new QuizPage("QuizPAge");
    ModulesPage modulesPage = new ModulesPage("ModulesPAge");
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

    public void goToQuestionsPage() {
        topMenuForm.clickQuestionsButton();

        Assert.assertTrue(questionsPage.isDisplayed());
    }

    public void goToQuizPage() {
        topMenuForm.clickQuizButton();

        Assert.assertTrue(quizPage.isDisplayed());
    }

    public void goToModulesPage() {
        topMenuForm.clickModulesButton();

     //   Assert.assertTrue(coursesPage.isDisplayed());
    }

    public void clickAddInterviewButton() {
        interviewsPage.clickAddButton();

        Assert.assertTrue(addInterviewModal.isDisplayed());
    }

    public void clickAddQuestionButton() {
        questionsPage.clickAddButton();

        Assert.assertTrue(addQuestionModal.isDisplayed());
    }

    public void clickAddQuizButton() {
        quizPage.clickAddButton();

        Assert.assertTrue(addQuizModal.isDisplayed());
    }

    public void clickAddModuleButton() {
        modulesPage.clickAddButton();

        Assert.assertTrue(addModuleModal.isDisplayed());
    }

    public void createInterview(String interviewName) {
        addInterviewModal.inputName(interviewName);
        addInterviewModal.clickCreateButton();
      //  Assert.assertFalse(addInterviewModal.isDisplayed());
    }

    public void createQuestion(String questionText) {
        addQuestionModal.inputQuestion(questionText);
        addQuestionModal.clickCreateButton();
        //  Assert.assertFalse(addInterviewModal.isDisplayed());
    }

    public void createQuiz(String quizText) {
        addQuizModal.inputQuiz(quizText);
        addQuizModal.clickCreateButton();
        //  Assert.assertFalse(addInterviewModal.isDisplayed());
    }

    public void checkInterviewPresent(String name) {
        Assert.assertTrue(interviewsPage.isInterviewPresent(name));
    }

    public void checkQuestionPresent(String question) {
        Assert.assertTrue(questionsPage.isQuestionPresent(question));
    }

    public String getQuestionId(String question) {
        return questionsPage.getQuestionId(question);
    }

    public void checkQuizPresent(String quiz) {
        Assert.assertTrue(quizPage.isQuizPresent(quiz));
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
