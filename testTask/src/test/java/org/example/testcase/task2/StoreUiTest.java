package org.example.testcase.task2;

import org.testng.Assert;
import org.testng.annotations.Test;


public class StoreUiTest extends BaseTest {

   /* @Test
    public void purchaseTest() {
        logger.info("Test method started");
        logger.info("Step 1: Go to the main page");
        browser.goToUrl(dataUtil.getTestProps().getProperty("mainPageUrl"));

        logger.info("Step 2: Login");
        uiSteps.login(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("password"));

        logger.info("Step 3: Go to the item page");
        uiSteps.goToCatalogItemPage(1);

        logger.info("Step 4: Add item to cart and compare page and cart prices");
        String itemPriceFromItemPage = uiSteps.addItemToCart();
        uiSteps.goToCart();
        String itemPriceFromCart = uiSteps.getItemPriceFromCart();

        Assert.assertEquals(itemPriceFromItemPage, itemPriceFromCart,
                "Prices from item page and cart should be equal");

        logger.info("Step 5: Place order and compare page and purchase prices");
        String itemPriceFromPurchase = uiSteps.placeOrder(dataUtil.getTestProps().getProperty("userName"),
                dataUtil.getTestProps().getProperty("country"),
                dataUtil.getTestProps().getProperty("city"),
                dataUtil.getTestProps().getProperty("card"),
                dataUtil.getTestProps().getProperty("month"),
                dataUtil.getTestProps().getProperty("year"));

        Assert.assertEquals(itemPriceFromPurchase, itemPriceFromItemPage,
                "Prices from item page and purchase should be equal");

        logger.info("Test method ended");
    }*/
}
