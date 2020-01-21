package com.womenshop.pages;

import com.womenshop.core.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends BasePage {
    @FindBy(id = "add_to_cart")
    WebElement addCartButton;

    @FindBy(css = "a[title='Proceed to checkout']")
    WebElement proceedButton;

    public void clickAddToCartButton(){
        CommonMethods.clickWebElement(addCartButton);
    }

    public CartPage clickProceedButton(){
        CommonMethods.clickWebElement(proceedButton);
        return new CartPage();
    }
    public boolean isItemImagePresent(String itemTitle) {
        return CommonMethods.isElementPresent(driver.findElement(By.cssSelector("img[title='" + itemTitle + "']")));
    }
}
