package com.fast.steps;

import com.fast.pages.WPAdminPages;
import com.fast.utils.BasePage;
import com.fast.pages.HomePage;
import com.fast.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class TestSetup extends BasePage {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private WPAdminPages adminPage;
    BasePage basePage;
    public String adminUsername = "admin";
    public String adminPassword = "parola11";

    @Step
    public void goToWPAdminPage() {
        adminPage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void goToHomePage() {
        homePage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void goToMyAccountPage() {
        myAccountPage.open();
        getDriver().manage().window().maximize();
    }

    @Step
    public void checkIfCategoryAdded() {
        Assert.assertTrue(adminPage.checkIfCategorySuccessfullyAdded(CATEGORY_NAME));
    }

    @Step
    public void checkIfCategorySuccessfullyRemoved() {
        Assert.assertTrue((adminPage.checkIfCategorySuccessfullyRemoved()));
    }

    @Step
    public void checkIfProductSuccessfullyAdded() {
        Assert.assertTrue(adminPage.checkIfProductSuccessfulyAdded());
    }

    @Step
    public void checkIfProductSuccessfullyRemoved() {
        Assert.assertTrue(adminPage.checkIfProductSuccessfullyRemoved());
    }

    @Step
    public void logOutOfAdminAccount() {
        adminPage.hoverOverAdminPanel();
        adminPage.clickOnLogOutLink();
    }

    @StepGroup
    public void logIntoAdminAccount() {
        goToWPAdminPage();
        adminPage.typeIntoAdminLoginTextField(adminUsername);
        adminPage.typeIntoAdminPasswordTextField(adminPassword);
        adminPage.clickOnLoginButton();
    }

    @StepGroup
    public void addNewProductInNewCategory() {
        adminPage.hoverOverProductsLink();
        adminPage.clickOnAddNewProductLink();
        adminPage.typeIntoProductRegularPriceTextField(randomNumberToString(10,200));
        adminPage.clickOnAddNewCategoryToggleButton();
        adminPage.typeIntoCategoryNameTextField(CATEGORY_NAME);
        adminPage.clickOnAddNewCategorySubmitButton();
        checkIfCategoryAdded();
        adminPage.typeIntoProductNameTextField(PRODUCT_NAME);
        adminPage.clickOnPublishButton();
        checkIfProductSuccessfullyAdded();
    }

    @StepGroup
    public void removeProductAndCategory() {
        adminPage.hoverOverProductsLink();
        adminPage.clickOnCategoriesLink();
        adminPage.searchForCategoryName(CATEGORY_NAME);
        adminPage.clickOnSearchItemsButton();
        adminPage.clickOnSelectAllTickBox();
        adminPage.moveToBulkActionsDropDownListAndDelete();
        adminPage.clickOnApplyButton();
        checkIfCategorySuccessfullyRemoved();
        adminPage.hoverOverProductsLink();
        adminPage.clickOnProductsLink();
        adminPage.searchForProductName(PRODUCT_NAME);
        adminPage.clickOnSearchItemsButton();
        adminPage.hoverOverProductName();
        adminPage.clickOnMoveToTrashLink();
        checkIfProductSuccessfullyRemoved();
    }

    @StepGroup
    public void deleteRegisteredUser() {
        adminPage.hoverOverUsersLink();
        adminPage.clickOnAllUsersLink();
        adminPage.clickOnUsernameSearchField();
        adminPage.typeIntoUsernameSearchField(RegisterSteps.PREV_REGISTERED_USERNAME);
        adminPage.clickOnSearchUsersButton();
        adminPage.hoverOverRegisteredUsername();
        adminPage.clickOnDeleteUserLink();
        adminPage.clickOnConfirmDeletionButton();
        Assert.assertTrue(adminPage.checkIfUserSuccessfullyDeleted());
    }

    @StepGroup
    public void deletePlacedOrder() {
        adminPage.hoverOverWooCommerceLink();
        adminPage.clickOnOrdersLink();
        adminPage.clickOnSearchOrderTextField();
        adminPage.typeOrderNumberIntoTextField(CartSteps.ORDER_NUMBER);
        adminPage.clickOnSearchOrdersButton();
        adminPage.clickOnSelectAllOrdersTickBox();
        adminPage.clickOnBulkActionsAndMoveToTrash();
        adminPage.clickOnApplyOrderActionsButton();
        Assert.assertTrue(adminPage.checkIfOrderSuccessfullyDeleted());
    }
}
