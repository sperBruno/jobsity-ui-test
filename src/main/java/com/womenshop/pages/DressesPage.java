package com.womenshop.pages;

import com.womenshop.core.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;


public class DressesPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title_block'][contains(.,'Dresses')]")
    private WebElement categoryDressBox;

    @FindBy(xpath = "(//a[contains(.,'Summer Dresses')])[3]")
    private WebElement summerDressesOption;

    @FindBy(css = "#selectProductSort")
    private WebElement selectProductSort;

    private CatalogBox catalogBox;
    private ItemsPanel itemsPanel;
    Map<String, String> sortByOptions;

    public DressesPage() {
        this.catalogBox = new CatalogBox();
        this.itemsPanel = new ItemsPanel();
        sortByOptions = new HashMap<>();
        sortByOptions.put("Price: Lowest first", "price:asc");
        sortByOptions.put("Price: Highest first", "price:desc");
    }

    public boolean categoryDressBoxIsDisplayed() {
        return CommonMethods.isElementPresent(categoryDressBox);
    }


    public DressesPage clickSummerDressOption() {
        CommonMethods.clickWebElement(summerDressesOption);
        return this;
    }

    public CatalogBox getCatalogBox() {
        return catalogBox;
    }

    public ItemsPanel getItemsPanel() {
        return itemsPanel;
    }

    public DressesPage selectSortBy(String value) {

        CommonMethods.selectAElementComboBox(selectProductSort, sortByOptions.get(value));
        return this;
    }
}
