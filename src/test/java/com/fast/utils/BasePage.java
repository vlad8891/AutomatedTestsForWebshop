package com.fast.utils;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BasePage extends PageObject {

    public static String VALID_USER = "test_account01@email.com";
    public static String VALID_PASSWORD = "testPassword8891";
    public static String INVALID_USER = "test_account02@email";
    public static String INVALID_PASSWORD = randomNumberToString(0,100);
    public static String PRODUCT_NAME = "test_product_01";
    public static String CATEGORY_NAME = "test_cat_01";

    public static int returnRandomNumber(int minRange, int maxRange) {
        int randomNum = ThreadLocalRandom.current().nextInt(minRange, maxRange + 1);
        return randomNum;
    }

    public static String randomNumberToString(int minRange, int maxRange) {
        String randomNumToString = Integer.toString(returnRandomNumber(minRange, maxRange));
        return randomNumToString;
    }

    public WebElementFacade randomItemFromList(List<WebElementFacade> list) {
        WebElementFacade randomItem = list.get(returnRandomNumber(0, list.size() - 1));
        return randomItem;
    }

    public String randomTextGenerator(int stringLength) {
        String generatedString = RandomStringUtils.randomAlphanumeric(stringLength);
        return generatedString;
    }

    public String randomEmailGenerator() {
        String emailPrefix = randomTextGenerator(8);
        return emailPrefix + "@" + "email.com";
    }
}
