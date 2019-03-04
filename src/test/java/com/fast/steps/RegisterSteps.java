package com.fast.steps;

import com.fast.pages.HomePage;
import com.fast.pages.MyAccountPage;
import com.fast.utils.BasePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class RegisterSteps extends BasePage {

    HomePage homePage;
    MyAccountPage myAccountPage;
    BasePage basePage;

    public static String PREV_REGISTERED_USERNAME;

    @Step
    public void goToHomepage() {
        homePage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void goToMyAccountPage() {
        homePage.clickOnSignInLink();
    }

    @Step
    public void enterValidUserName() {
        myAccountPage.typeIntoRegUsernameField(randomEmailGenerator());
    }

    @Step
    public void enterValidPassword() {
        myAccountPage.typeIntoRegPasswordField(BasePage.VALID_PASSWORD);
    }

    @Step
    public void clickOnRegisterButton() {
        myAccountPage.clickOnRegisterButton();
    }

    @Step
    public void enterInvalidUserName() {
        myAccountPage.typeIntoRegUsernameField(BasePage.INVALID_USER);
    }

    @Step
    public void enterVeryWeakPassword() {
        myAccountPage.typeIntoRegPasswordField(basePage.randomTextGenerator(1));
    }

    @Step
    public void enterWeakPassword() {
        myAccountPage.typeIntoRegPasswordField(basePage.randomTextGenerator(5));
    }

    @Step
    public void checkIfSuccessfullyRegistered() {
        Assert.assertTrue(myAccountPage.checkIfSuccessfullyRegistered());
    }

    @Step
    public void clickOnLogoutButton() {
        myAccountPage.clickOnLogOutButton();
    }

    @Step
    public void checkForInvalidUsernameError() {
        myAccountPage.checkForInvalidUserOnReg();
    }

    @Step
    public void checkForVeryWeakPasswordText() {
        myAccountPage.checkForWeakPassOnReg("Very");
    }

    @Step
    public void checkForWeakPasswordText() {
        myAccountPage.checkForWeakPassOnReg("Weak");
    }

    @Step
    public void checkIfRegisterButtonIsActive() {
        myAccountPage.checkIfRegisterButtonIsActive();
    }

    @Step
    public void getRegisteredUserName() {
        MyAccountPage.getRegisteredUsername();
    }

    @Step
    public static void storePreviouslyRegisteredUsername() {
        PREV_REGISTERED_USERNAME = MyAccountPage.getRegisteredUsername();
    }

    @StepGroup
    public void registerValidAccount() {
        goToHomepage();
        goToMyAccountPage();
        enterValidUserName();
        enterValidPassword();
        clickOnRegisterButton();
        checkIfSuccessfullyRegistered();
        getRegisteredUserName();
        storePreviouslyRegisteredUsername();
    }

    @StepGroup
    public void registerWithInvalidUsername() {
        goToHomepage();
        goToMyAccountPage();
        enterInvalidUserName();
        clickOnRegisterButton();
        checkForInvalidUsernameError();
    }

    @StepGroup
    public void registerWithInvalidPassword() {
        goToHomepage();
        goToMyAccountPage();
        enterVeryWeakPassword();
        checkForVeryWeakPasswordText();
        enterWeakPassword();
        checkForWeakPasswordText();
    }
}
