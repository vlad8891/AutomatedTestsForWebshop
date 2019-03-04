package com.fast.pages;

import com.fast.utils.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl ("http://qa3.fasttrackit.org:8008/cart")

public class CartPage extends BasePage {

    @FindBy (css = "tr td:nth-child(3)")
    private WebElementFacade testProduct;

    @FindBy (css = "form div input")
    private WebElementFacade quantityTextBox;

    @FindBy (css = "button[type*=submit]")
    private WebElementFacade updateCartButton;

    @FindBy (css = "div[class*=checkout] a[href*=checkout]")
    private WebElementFacade checkoutButton;

    public boolean checkIfTestProductIsInCart() {
        waitFor(testProduct);
        return testProduct.isPresent();
    }

    public void modifyProductQuantity(String quantity) {
        quantityTextBox.click();
        typeInto(quantityTextBox, quantity);
    }

    public void clickOnUpdateCartButton() {
        clickOn(updateCartButton);
    }

    public void clickOnCheckoutButton() {
        clickOn(checkoutButton);
    }
}
