package com.fast.pages;

import com.fast.utils.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/shop")

public class ShopPage extends BasePage {

    @FindBy (css = "aside form label input[type*=search]")
    private WebElementFacade productSearchTextField;

    @FindBy (css = "h3 a")
    private WebElementFacade testProductLink;

    @FindBy (css = "form div input ")
    private WebElementFacade quantityTextBox;

    @FindBy (css = "form button[name*=cart]")
    private WebElementFacade addToCartButton;

    @FindBy (css = "div#primary div")
    private WebElementFacade addedToCartMessage;

    @FindBy (css = "div#primary div a")
    private WebElementFacade viewCartButton;

    public void typeIntoSearchTextField (String productName) {
        clickOn(productSearchTextField);
        productSearchTextField.typeAndEnter(productName);
    }

    public void clickOnTestProductLink(){
        waitFor(testProductLink);
        clickOn(testProductLink);
    }

    public void clickOnQuantityTextBox() {
        waitFor(quantityTextBox);
        clickOn(quantityTextBox);
    }

    public void typeIntoQuantityTextBox(String quantity) {
        typeInto(quantityTextBox, quantity);
    }

    public void clickOnAddToCartButton(){
        clickOn(addToCartButton);
    }

    public boolean checkIfProductSuccessfullyAddedToCart() {
        waitFor(addedToCartMessage);
        return addedToCartMessage.getText().contains("added");
    }

    public void clickOnViewCartButton() {
        viewCartButton.click();
    }
}
