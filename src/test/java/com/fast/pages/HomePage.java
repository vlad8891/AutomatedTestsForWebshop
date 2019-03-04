package com.fast.pages;

import com.fast.utils.BasePage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/")
public class HomePage extends BasePage {

    @FindBy(css = "a[title='Login']")
    private WebElementFacade signInLink;

    public void clickOnSignInLink(){
        clickOn(signInLink);
    }
}
