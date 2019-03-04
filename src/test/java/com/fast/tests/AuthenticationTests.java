package com.fast.tests;
import com.fast.steps.LoginSteps;
import com.fast.steps.RegisterSteps;
import com.fast.steps.TestSetup;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AuthenticationTests {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    RegisterSteps registerSteps;

    @Steps
    TestSetup testSetup;

    @Steps
    LoginSteps loginSteps;

    @Test
    public void registerValidAccount(){
        registerSteps.goToHomepage();
        registerSteps.goToMyAccountPage();
        registerSteps.enterValidUserName();
        registerSteps.enterValidPassword();
        registerSteps.clickOnRegisterButton();
        registerSteps.checkIfSuccessfullyRegistered();
        registerSteps.getRegisteredUserName();
        RegisterSteps.storePreviouslyRegisteredUsername();
        registerSteps.clickOnLogoutButton();
        testSetup.goToWPAdminPage();
        testSetup.logIntoAdminAccount();
        testSetup.deleteRegisteredUser();
        testSetup.logOutOfAdminAccount();
    }

    @Test
    public void registerWithInvalidUser() {
        registerSteps.goToHomepage();
        registerSteps.goToMyAccountPage();
        registerSteps.enterInvalidUserName();
        registerSteps.clickOnRegisterButton();
        registerSteps.checkForInvalidUsernameError();
    }

    @Test
    public void registerWithInvalidPassword() {
        registerSteps.goToHomepage();
        registerSteps.goToMyAccountPage();
        registerSteps.enterVeryWeakPassword();
        registerSteps.checkIfRegisterButtonIsActive();
        registerSteps.checkForVeryWeakPasswordText();
        registerSteps.enterWeakPassword();
        registerSteps.checkIfRegisterButtonIsActive();
        registerSteps.checkForWeakPasswordText();
    }

    @Test
    public void logInWithValidAccount() {
        loginSteps.goToHomepage();
        loginSteps.goToMyAccountPage();
        loginSteps.enterValidUserName();
        loginSteps.enterValidPassword();
        loginSteps.pressLoginButton();
        loginSteps.checkIfSuccessfullyLoggedIn();
    }

    @Test
    public void logInWithInvalidUsername() {
        loginSteps.goToHomepage();
        loginSteps.goToMyAccountPage();
        loginSteps.enterInvalidUserName();
        loginSteps.enterValidPassword();
        loginSteps.pressLoginButton();
        loginSteps.checkForInvalidUsernameError();
    }

    @Test
    public void logInWithInvalidPassword() {
        loginSteps.goToHomepage();
        loginSteps.goToMyAccountPage();
        loginSteps.enterValidUserName();
        loginSteps.enterInvalidPassword();
        loginSteps.pressLoginButton();
        loginSteps.checkForInvalidPasswordError();
    }
}



