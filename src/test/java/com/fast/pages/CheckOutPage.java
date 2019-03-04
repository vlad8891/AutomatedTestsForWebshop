package com.fast.pages;

import com.fast.utils.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/checkout")

public class CheckOutPage extends BasePage {

    @FindBy (css = "tbody tr")
    private WebElementFacade yourOrderedProduct;

    @FindBy (id = "billing_first_name")
    private WebElementFacade firstNameTextField;

    @FindBy (id = "billing_last_name")
    private WebElementFacade lastNameTextField;

    @FindBy (id = "select2-billing_country-container")
    private WebElementFacade countryDropDownList;

    @FindBy (css = "span[class*=search--dropdown] ")
    private WebElementFacade filterCountryTextField;

    @FindBy (id = "billing_address_1")
    private WebElementFacade streetAddressTextField;

    @FindBy (id = "billing_city")
    private WebElementFacade cityTextField;

    @FindBy (id = "billing_state")
    private WebElementFacade billingStateTextField;

    @FindBy (id = "billing_postcode")
    private WebElementFacade postCodeTextField;

    @FindBy (id = "billing_email")
    private WebElementFacade emailTextField;

    @FindBy (id = "billing_phone")
    private WebElementFacade phoneTextField;

    @FindBy (id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy (css = "div p[class*=thankyou]")
    private WebElementFacade thankYouMessage;

    @FindBy (css = "#select2-billing_country-container")
    private WebElementFacade countryFromDropDown;

    @FindBy (css = "#select2-billing_state-container")
    private WebElementFacade billingState;

    @FindBy (css = "li[class*=order] strong")
    private static WebElementFacade ORDER_NUMBER_TEXT;

    public boolean checkIfOrderedProductIsPresentAtCheckout(String productName) {
        return yourOrderedProduct.getText().contentEquals(productName);
    }

    public void typeIntoFirstNameTextField(String firstName) {
        typeInto(firstNameTextField, firstName);
    }

    public void typeIntoLastNameTextField(String lastName) {
        typeInto(lastNameTextField, lastName);
    }

    public void clickOnCountryDropDownList() {
        clickOn(countryDropDownList);
    }

    public void selectCountryFromList() {
        clickOn(filterCountryTextField);
        clickOn(countryFromDropDown);
    }

    public void typeIntoStreetAddressTextField(String streetAddress) {
        typeInto(streetAddressTextField, streetAddress);
    }

    public void typeIntoCityTextField(String cityName) {
        typeInto(cityTextField, cityName);
    }

    public void selectStateFromList() {
        clickOn(billingStateTextField);
        clickOn(billingState);
    }

    public void typeIntoPostCodeTextField(String postCode) {
        typeInto(postCodeTextField, postCode);
    }

    public void typeIntoPhoneTextField(String phoneNumber) {
        typeInto(phoneTextField, phoneNumber);
    }

    public void typeIntoEmailAddressTextField(String emailAddress) {
        typeInto(emailTextField, emailAddress);
    }

    public void clickOnPlaceOrderButton() {
        clickOn(placeOrderButton);
    }

    public boolean checkIfOrderPlaced() {
        waitFor(ORDER_NUMBER_TEXT);
        return thankYouMessage.getText().contains("Thank you");
    }

    public static String getOrderNo() {
        String orderNo = ORDER_NUMBER_TEXT.getText();
        return orderNo;
    }
}
