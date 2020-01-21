package com.womenshop.pages;

import com.womenshop.core.utils.CommonMethods;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogBox extends BasePage {

    @FindBy(xpath = "//p[@class='title_block'][contains(.,'Catalog')]")
    private WebElement catalogBoxElement;

    @FindBy(xpath = "//input[@value='3_1']")
    private WebElement sizeL;

    @FindBy(xpath = "//input[@value='2_1']")
    private WebElement sizeM;

    @FindBy(id = "layered_id_attribute_group_16")
    private WebElement colorYellow;

    @FindBy(id = "layered_id_attribute_group_15")
    private WebElement colorGreen;

    public void setSize(final String value) {
        switch (value.toUpperCase()) {
            case "L":
                CommonMethods.setCheckBox(sizeL, true);
                break;
            case "M":
                CommonMethods.setCheckBox(sizeM, true);
                break;
            default:
                throw new WebDriverException("Element Not Found");
        }

    }

    public boolean categoryCatalogBoxIsDisplayed() {
        return CommonMethods.isElementPresent(catalogBoxElement);
    }

    public void setColor(String color) {

        switch (color.toUpperCase()) {
            case "GREEN":
                CommonMethods.setCheckBox(colorGreen, true);
                break;
            case "YELLOW":
                CommonMethods.setCheckBox(colorYellow, true);
                break;
            default:
                throw new WebDriverException("Element Not Found");
        }

    }
}
