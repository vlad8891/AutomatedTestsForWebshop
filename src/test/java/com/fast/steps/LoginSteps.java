package com.fast.steps;

import com.fast.pages.HomePage;
import com.fast.pages.MyAccountPage;
import com.fast.utils.BasePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class LoginSteps extends BasePage {

    private HomePage homePage;
    private MyAccountPage myAccountPage;

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
        myAccountPage.typeIntoLogInUsernameField(VALID_USER);

    }

    @Step
    public void enterValidPassword() {
        myAccountPage.typeIntoLogInPassField(BasePage.VALID_PASSWORD);
    }

    @Step
    public void checkIfSuccessfullyLoggedIn() {
        Assert.assertTrue(myAccountPage.checkIfSuccessfullyRegistered());
    }

    @Step
    public void enterInvalidPassword() {
        myAccountPage.typeIntoLogInPassField(BasePage.INVALID_PASSWORD);
    }

    @Step
    public void enterInvalidUserName() {
        myAccountPage.typeIntoLogInUsernameField(BasePage.INVALID_USER);
    }

    @Step
    public void pressLoginButton() {
        myAccountPage.clickOnLogInButton();
    }

    @Step
    public void logOutOfAccount() {
        myAccountPage.clickOnLogOutButton();
    }

    @Step
    public void checkForInvalidUsernameError() {
        Assert.assertTrue(myAccountPage.checkForInvalidUserOnLogin());
    }

    @Step
    public void checkForInvalidPasswordError() {
        Assert.assertTrue(myAccountPage.checkForInvalidPasswordOnLogin());
    }

    @StepGroup
    public void validAccountLogIn() {
        goToHomepage();
        goToMyAccountPage();
        enterValidUserName();
        enterValidPassword();
        pressLoginButton();
        checkIfSuccessfullyLoggedIn();
        logOutOfAccount();
    }

    @StepGroup
    public void loginWithInvalidUsername() {
        goToHomepage();
        goToMyAccountPage();
        enterInvalidUserName();
        enterValidPassword();
        pressLoginButton();
        checkForInvalidUsernameError();
    }

    @StepGroup
    public void loginWithInvalidPassword() {
        goToHomepage();
        goToMyAccountPage();
        enterValidUserName();
        enterInvalidPassword();
        pressLoginButton();
        checkForInvalidPasswordError();
    }
}
