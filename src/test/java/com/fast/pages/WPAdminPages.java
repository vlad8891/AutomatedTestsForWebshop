package com.fast.pages;

import com.fast.utils.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/wp-login.php?redirect_to=http%3A%2F%2Fqa3.fasttrackit.org%3A8008%2Fwp-admin%2F&reauth=1")

public class WPAdminPages extends BasePage {

    @FindBy (id = "user_login")
    private WebElementFacade adminLoginTextField;

    @FindBy (id = "user_pass")
    private WebElementFacade adminPasswordTextField;

    @FindBy (id = "wp-submit")
    private WebElementFacade loginButton;

    @FindBy (css = "#menu-posts-product div:nth-child(2)")
    private WebElementFacade productsPopupMenu;

    @FindBy (css = "#menu-posts-product > ul > li:nth-child(4) > a" )
    private WebElementFacade categoriesLink;

    @FindBy (id = "tag-search-input")
    private WebElementFacade categorySearchTextField;

    @FindBy (css = "td strong a")
    private WebElementFacade previouslyCreatedItem;

    @FindBy (css = "select#bulk-action-selector-top")
    private WebElementFacade bulkActionsCategoryDropDownList;

    @FindBy (css = "select [value*='delete']")
    private WebElementFacade categoryDeleteOption;

    @FindBy (id = "cb-select-all-1")
    private WebElementFacade selectAllCategoriesTickBox;

    @FindBy (css = "div#message p")
    private WebElementFacade itemDeletedMessage;

    @FindBy (id = "newproduct_cat")
    private WebElementFacade categoryNameTextField;

    @FindBy (id = "submit")
    private WebElementFacade submitCategoryButton;

    @FindBy (css = "#menu-posts-product ul li:nth-child(3) a")
    private WebElementFacade addNewProductLink;

    @FindBy (id = "message")
    private WebElementFacade productPublishedMessage;

    @FindBy (id = "title")
    private WebElementFacade productNameTextField;

    @FindBy (id = "_regular_price")
    private WebElementFacade productRegularPriceTextField;

    @FindBy (id = "_sale_price")
    private WebElementFacade productSalePriceTextField;

    @FindBy(id = "product_cat_all")
    private WebElementFacade categoryMenu;

    @FindBy(id = "product_catchecklist")
    private WebElementFacade categoryList;

    @FindBy (css = "input[name=publish]")
    private WebElementFacade publishButton;

    @FindBy (css = "a span.display-name")
    private WebElementFacade adminDropDownList;

    @FindBy (css = "#wp-admin-bar-logout > a")
    private WebElementFacade adminLogOutLink;

    @FindBy (id = "product_cat-add-toggle")
    private WebElementFacade addNewCategoryToggleButton;

    @FindBy (id = "product_cat-add-submit")
    private WebElementFacade addNewCategorySubmitButton;

    @FindBy (css = "#menu-posts-product > ul > li.wp-first-item > a")
    private WebElementFacade productsLink;

    @FindBy (id = "post-search-input")
    private WebElementFacade searchTextField;

    @FindBy (css = "select [value*='trash']")
    private WebElementFacade moveProductToTrashOption;

    @FindBy (css = "span.trash a")
    private WebElementFacade moveProductToTrashAction;

    @FindBy (id = "wp-admin-bar-my-account")
    private WebElementFacade accountPanel;

    @FindBy (css = "#wp-admin-bar-logout > a")
    private WebElementFacade logOutLink;

    @FindBy (css = "#menu-users > a > div.wp-menu-name")
    public WebElementFacade usersPopUpMenu;

    @FindBy (css = "#menu-users > ul > li.wp-first-item > a")
    private WebElementFacade allUsersLink;

    @FindBy (id = "user-search-input")
    private WebElementFacade searchUsersTextField;

    @FindBy (id = "search-submit")
    private WebElementFacade searchButton;

    @FindBy (css = "tr td:nth-child(5)")
    private WebElementFacade registeredUser;

    @FindBy (css = "td div span:nth-child(2) a")
    private WebElementFacade deleteUserLink;

    @FindBy (id = "submit")
    private WebElementFacade confirmDeletionButton;

    @FindBy (id = "message")
    private WebElementFacade userDeletedConfirmationMessage;

    @FindBy (css = "#toplevel_page_woocommerce > a > div.wp-menu-name")
    private WebElementFacade wooCommercePopUpMenu;

    @FindBy (css = "#toplevel_page_woocommerce > ul > li.wp-first-item > a")
    private WebElementFacade ordersLink;

    @FindBy (id = "cb-select-all-1")
    private WebElementFacade selectAllOrdersTickBox;

    @FindBy (id = "bulk-action-selector-top")
    private WebElementFacade bulkActionsOrderDropDownList;

    @FindBy (css = "div select option:nth-child(2)")
    private WebElementFacade moveOrderToTrashAction;

    @FindBy (id = "doaction")
    private WebElementFacade applyButton;

    @FindBy (css = "div#message p")
    private WebElementFacade orderDeletedConfirmationMessage;

    public void typeIntoAdminLoginTextField(String userName) {
        typeInto(adminLoginTextField, userName);
    }

    public void typeIntoAdminPasswordTextField(String password) {
        typeInto(adminPasswordTextField, password);
    }

    public void clickOnLoginButton(){
        clickOn(loginButton);
    }

    public void hoverOverProductsLink() {
        waitFor(productsPopupMenu);
        moveTo("#menu-posts-product div:nth-child(2)");
    }

    public void clickOnAddNewProductLink() {
        clickOn(addNewProductLink);
    }

    public boolean checkIfProductSuccessfulyAdded() {
        waitFor(productPublishedMessage);
        return productPublishedMessage.getText().contains("Product published");
    }

    public void typeIntoProductNameTextField(String productName) {
        waitFor(productNameTextField);
        typeInto(productNameTextField, productName);
    }

    public void typeIntoProductRegularPriceTextField(String productPrice) {
        typeInto(productRegularPriceTextField, productPrice);
    }

    public void clickOnAddNewCategoryToggleButton() {
        clickOn(addNewCategoryToggleButton);
    }

    public void typeIntoCategoryNameTextField(String category) {
        typeInto(categoryNameTextField, category);
    }

    public void clickOnAddNewCategorySubmitButton() {
        clickOn(addNewCategorySubmitButton);
    }

    public boolean checkIfCategorySuccessfullyAdded(String category) {
        waitABit(1000);
        return categoryList.getText().contains(category);
    }

    public void clickOnPublishButton(){
        clickOn(publishButton);
    }

    public void clickOnCategoriesLink() {
        clickOn(categoriesLink);
    }

    public void searchForCategoryName(String category) {
        waitFor(categorySearchTextField);
        typeInto(categorySearchTextField, category);
    }

    public void clickOnSearchItemsButton() {
        clickOn(searchButton);
    }

    public void clickOnSelectAllTickBox() {
        waitFor(previouslyCreatedItem);
        clickOn(selectAllCategoriesTickBox);
    }

    public void moveToBulkActionsDropDownListAndDelete() {
        moveTo("//*[@id=\"bulk-action-selector-top\"]").click();
        moveTo ("select [value*='delete']").click();
    }

    public void clickOnApplyButton() {
        clickOn(applyButton);
    }

    public boolean checkIfCategorySuccessfullyRemoved() {
        waitFor(itemDeletedMessage);
        return itemDeletedMessage.getText().contains("Items deleted.");
    }

    public void clickOnProductsLink() {
        clickOn(productsLink);
    }

    public void searchForProductName(String productName) {
        waitFor(searchTextField);
        typeInto(searchTextField, productName);
        waitFor(previouslyCreatedItem);
    }

    public void hoverOverProductName() {
        moveTo("td strong a");
    }

    public void clickOnMoveToTrashLink() {
        waitFor(moveProductToTrashAction);
        clickOn(moveProductToTrashAction);
        getDriver().switchTo().alert().accept();
    }

    public boolean checkIfProductSuccessfullyRemoved() {
        waitFor(itemDeletedMessage);
        return itemDeletedMessage.getText().contains("product moved to the Trash");
    }

    public void hoverOverAdminPanel() {
        moveTo("#wp-admin-bar-my-account > a");
    }

    public void clickOnLogOutLink() {
        waitFor(logOutLink);
        clickOn(logOutLink);
        waitFor(adminLoginTextField);
    }

    public void hoverOverUsersLink() {
        moveTo("#menu-users > a > div.wp-menu-name");
    }

    public void clickOnAllUsersLink() {
        waitFor(allUsersLink);
        clickOn(allUsersLink);
    }

    public void clickOnUsernameSearchField() {
        waitFor(searchUsersTextField);
        clickOn(searchUsersTextField);
    }

    public void typeIntoUsernameSearchField(String userName) {
        typeInto(searchUsersTextField, userName);
    }

    public void clickOnSearchUsersButton() {
        clickOn(searchButton);
    }

    public void hoverOverRegisteredUsername() {
        //waitFor(registeredUser);
        moveTo("tr td:nth-child(5)");
    }

    public void clickOnDeleteUserLink() {
        clickOn(deleteUserLink);
    }

    public void clickOnConfirmDeletionButton() {
        waitFor(confirmDeletionButton);
        clickOn(confirmDeletionButton);
    }

    public boolean checkIfUserSuccessfullyDeleted() {
        return userDeletedConfirmationMessage.getText().contains("User deleted");
    }

    public void hoverOverWooCommerceLink() {
        moveTo("#toplevel_page_woocommerce > a > div.wp-menu-name");
    }

    public void clickOnOrdersLink() {
        waitFor(ordersLink);
        clickOn(ordersLink);
    }

    public void clickOnSearchOrderTextField() {
        waitFor(searchTextField);
        clickOn(searchTextField);
    }

    public void typeOrderNumberIntoTextField(String orderNumber) {
        typeInto(searchTextField, orderNumber);
    }

    public void clickOnSearchOrdersButton() {
        clickOn(searchButton);
    }

    public void clickOnSelectAllOrdersTickBox() {
        waitFor(selectAllCategoriesTickBox);
        clickOn(selectAllOrdersTickBox);
    }

    public void clickOnBulkActionsAndMoveToTrash() {
        clickOn(bulkActionsOrderDropDownList);
        clickOn(moveOrderToTrashAction);
    }

    public void clickOnApplyOrderActionsButton() {
        clickOn(applyButton);
    }

    public boolean checkIfOrderSuccessfullyDeleted() {
        waitFor(orderDeletedConfirmationMessage);
        return orderDeletedConfirmationMessage.getText().contains("Trash");
    }
}
