package com.womenshop.pages;

import com.womenshop.core.utils.CommonMethods;
import org.openqa.selenium.By;

public class CartPage extends BasePage{

    public boolean isItemPresent(String itemText) {
        return CommonMethods.isElementPresent(driver.findElement(By.linkText(itemText)));
    }
}
