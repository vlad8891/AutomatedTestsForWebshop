package com.fast.steps;

import com.fast.pages.CartPage;
import com.fast.pages.CheckOutPage;
import com.fast.pages.ShopPage;
import com.fast.utils.BasePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class CartSteps extends BasePage {

    ShopPage shopPage;
    CartPage cartPage;
    CheckOutPage checkOutPage;
    BasePage basePage;

    public static String ORDER_NUMBER;

    @Step
    public void goToShopPage() {
        shopPage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void searchForTestProduct() {
        shopPage.typeIntoSearchTextField(BasePage.PRODUCT_NAME);
    }

    @Step
    public void selectTestProduct() {
        shopPage.clickOnTestProductLink();
    }

    @Step
    public void enterProductQuantity(){
        shopPage.clickOnQuantityTextBox();
        shopPage.typeIntoQuantityTextBox(BasePage.randomNumberToString(1,5));
    }

    @Step
    public void addProductToCart(){
        shopPage.clickOnAddToCartButton();
    }

    @Step
    public void checkIfTestProductSuccessfullyAdded(){
        Assert.assertTrue(shopPage.checkIfProductSuccessfullyAddedToCart());
    }

    @Step
    public void viewCart(){
        shopPage.clickOnViewCartButton();
    }

    @Step
    public void checkIfTestProductIsInCart() {
        Assert.assertTrue(cartPage.checkIfTestProductIsInCart());
    }

    @Step
    public void checkOut() {
        cartPage.clickOnCheckoutButton();
    }

    @Step
    public void checkIfOrderedProductIsPresentAtCheckout(){
        checkOutPage.checkIfOrderedProductIsPresentAtCheckout(BasePage.PRODUCT_NAME);
    }

    @Step
    public void enterFirstName() {
        checkOutPage.typeIntoFirstNameTextField(basePage.randomTextGenerator(5));
    }

    @Step
    public void enterLastName() {
        checkOutPage.typeIntoLastNameTextField(basePage.randomTextGenerator(8));
    }

    @Step
    public void selectCountryFromList() {
        checkOutPage.clickOnCountryDropDownList();
        checkOutPage.selectCountryFromList();
    }

    @Step
    public void enterStreetAddress(){
        checkOutPage.typeIntoStreetAddressTextField(basePage.randomTextGenerator(5));
    }

    @Step
    public void enterCityName() {
        checkOutPage.typeIntoCityTextField(basePage.randomTextGenerator(6));
    }

    @Step
    public void enterAreaPostCode() {
        checkOutPage.typeIntoPostCodeTextField(BasePage.randomNumberToString(6000,10000));
    }

    @Step
    public void enterPhoneNumber() {
        checkOutPage.typeIntoPhoneTextField(randomNumberToString(6000,10000));
    }

    @Step
    public void enterEmailAddress() {
        checkOutPage.typeIntoEmailAddressTextField(basePage.randomEmailGenerator());
    }

    @StepGroup
    public void fillInShipmentDetails() {
        enterFirstName();
        enterLastName();
        selectCountryFromList();
        enterStreetAddress();
        enterCityName();
        enterAreaPostCode();
        enterPhoneNumber();
        enterEmailAddress();
    }

    @Step
    public void placeOrder(){
        checkOutPage.clickOnPlaceOrderButton();
    }

    @Step
    public void getOrderNo() {
        CheckOutPage.getOrderNo();
    }

    @Step
    public static void storeOrderedNo() {
        ORDER_NUMBER = CheckOutPage.getOrderNo();
    }

    @Step
    public void checkIfOrderPlaced() {
        Assert.assertTrue(checkOutPage.checkIfOrderPlaced());
        getOrderNo();
        storeOrderedNo();
    }
}
