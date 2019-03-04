package com.fast.pages;

import com.fast.utils.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/my-account")

public class MyAccountPage extends BasePage {

    private String userRegErrorMessage = "Error: Please provide a valid email address.";
    private String userLoginErrorMessage = "ERROR: Invalid username.";
    private String passwordLoginErrorMessage = "ERROR: The password you entered for the email address " +
            VALID_USER + " is incorrect. Lost your password?";

    @FindBy (id = "reg_email")
    private WebElementFacade regUserNameTextField;

    @FindBy (id = "reg_password")
    private WebElementFacade regPasswordTextField;

    @FindBy (id = "username")
    private WebElementFacade loginUsernameTextField;

    @FindBy (id = "password")
    private WebElementFacade loginPasswordTextField;

    @FindBy (css = "button[name = 'register']")
    private WebElementFacade registerButton;

    @FindBy (css = "button[name = 'login']")
    private WebElementFacade loginButton;

    @FindBy (css = "li > a[href*='customer-logout']")
    private WebElementFacade logOutButton;

    @FindBy (css = "#post-13 > div > div > ul > li")
    private WebElementFacade invalidCredentialsError;

    @FindBy (css = "#customer_login > div.u-column2.col-2 > form > p:nth-child(2) > div")
    private WebElementFacade passwordWeakText;

    @FindBy (css = "div p strong")
    private static WebElementFacade registeredUserName;

    public void typeIntoRegUsernameField(String userName) {
        typeInto(regUserNameTextField, userName);
    }

    public void typeIntoRegPasswordField(String regPass) {
        typeInto(regPasswordTextField, regPass);
    }

    public String validUsernameFromRegUsernameTextField() {
        return regPasswordTextField.getText();
    }

    public void typeIntoLogInUsernameField(String userName) {
        typeInto (loginUsernameTextField, userName);
    }

    public void typeIntoLogInPassField(String logInPass) {
        typeInto (loginPasswordTextField, logInPass);
    }

    public void clickOnRegisterButton() {
        clickOn(registerButton);
    }

    public void clickOnLogInButton() {
        clickOn(loginButton);
    }

    public void clickOnLogOutButton() {
        clickOn(logOutButton);
    }

    public boolean checkIfSuccessfullyRegistered() {
        waitFor(logOutButton);
        return logOutButton.isDisplayed();
    }

    public boolean checkForInvalidUserOnReg() {
        waitFor(invalidCredentialsError);
        String errorMessage = invalidCredentialsError.getText();
        return errorMessage.contentEquals(userRegErrorMessage);
    }

    public boolean checkForWeakPassOnReg(String passStrength){
        return passwordWeakText.getText().contains(passStrength);
    }

    public boolean checkIfRegisterButtonIsActive() {
        return registerButton.isEnabled();
    }

    public boolean checkForInvalidUserOnLogin() {
        waitFor(invalidCredentialsError);
        String errorMessage = invalidCredentialsError.getText();
        return errorMessage.contains(userLoginErrorMessage);
    }

    public boolean checkForInvalidPasswordOnLogin() {
        waitFor(invalidCredentialsError);
        String errorMessage = invalidCredentialsError.getText();
        return errorMessage.contentEquals(passwordLoginErrorMessage);
    }

    public static String getRegisteredUsername() {
        String userName = registeredUserName.getText();
        return userName;
    }
}

