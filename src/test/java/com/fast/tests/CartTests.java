package com.fast.tests;

import com.fast.steps.CartSteps;
import com.fast.steps.RegisterSteps;
import com.fast.steps.TestSetup;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)

public class CartTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    TestSetup testSetup;
    CartSteps cartSteps;
    RegisterSteps registerSteps;

    @Test
    public void addProductToCart(){
        testSetup.logIntoAdminAccount();
        testSetup.addNewProductInNewCategory();
        testSetup.logOutOfAdminAccount();
        registerSteps.goToHomepage();
        registerSteps.goToMyAccountPage();
        registerSteps.registerValidAccount();
        registerSteps.checkIfSuccessfullyRegistered();
        cartSteps.goToShopPage();
        cartSteps.searchForTestProduct();
        cartSteps.selectTestProduct();
        cartSteps.enterProductQuantity();
        cartSteps.addProductToCart();
        cartSteps.checkIfTestProductSuccessfullyAdded();
        cartSteps.viewCart();
        cartSteps.checkIfTestProductIsInCart();
        cartSteps.checkOut();
        cartSteps.checkIfOrderedProductIsPresentAtCheckout();
        cartSteps.fillInShipmentDetails();
        cartSteps.placeOrder();
        cartSteps.checkIfOrderPlaced();
        testSetup.goToWPAdminPage();
        testSetup.logIntoAdminAccount();
        testSetup.removeProductAndCategory();
        testSetup.deleteRegisteredUser();
        testSetup.deletePlacedOrder();
        testSetup.logOutOfAdminAccount();
    }
}
