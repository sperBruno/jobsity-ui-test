package com.womenshop.pages;

import com.google.common.collect.Ordering;
import com.womenshop.core.utils.CommonMethods;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ItemsPanel extends BasePage {

    private static final Logger LOGGER = Logger.getLogger(ItemsPanel.class.getSimpleName());
    private List<WebElement> items;

    @FindBy(id = "homefeatured")
    private WebElement itemsPanel;

    public boolean isItemPresent(String itemTitle) {
        return CommonMethods.isElementPresent(driver.findElement(By.cssSelector(".right-block a[title='" + itemTitle + "']")));
    }

    public ItemPage selectItem(String itemTitle) {
        if(isItemPresent(itemTitle)){
            CommonMethods.clickWebElement(driver.findElement(By.cssSelector("img[title='" + itemTitle + "']")));
        }
        return new ItemPage();
    }

    public List<WebElement> itemsList() {
        items = driver.findElements(By.cssSelector(".product-container"));
        return items;
    }

    public boolean itemExistsWithPrice(String itemTitle, String price) {
        boolean itemExists = false;
        for (WebElement item : items) {
            if (item.getText().contains(itemTitle) && item.getText().contains(price)) {
                itemExists = true;
                break;
            }
        }
        return itemExists;
    }

    public List<Double> getPricesList() {
        List<Double> itemsPricesList = new ArrayList<>();
        List<WebElement> itemsPrices = driver.findElements(By.cssSelector(".product-container .right-block .price.product-price"));
        for (WebElement item : itemsPrices) {
            itemsPricesList.add(Double.parseDouble(item.getText().replace("$", "")));
        }

        return itemsPricesList;
    }

    public boolean itemsAreInAscendantOrder() {
        List<Double> pricesList = getPricesList();
        return Ordering.natural().isOrdered(pricesList);
    }

    public boolean itemsContainsWord(String word){
        List<WebElement> itemsList = itemsList();
        for (WebElement element: itemsList) {
            String itemText = element.getText();
            if (itemText.toLowerCase().contains(word.toLowerCase()) == false){
                LOGGER.info(itemText + " != " + word);
                return false;
            }
        }
        return true;
    }

    public boolean itemsPanelIsDisplayed(){
        return CommonMethods.isElementPresent(this.itemsPanel);
    }
}
