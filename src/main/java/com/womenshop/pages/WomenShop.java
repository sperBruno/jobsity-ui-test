package com.womenshop.pages;

import com.womenshop.core.utils.CommonMethods;
import com.womenshop.core.utils.PropertiesInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenShop extends BasePage {
    private NavigationBar navigationBar;
    private ItemsPanel itemsPanel;

    @FindBy(id = "search_query_top")
    private WebElement searchTextBox;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(className = "logo img-responsive")
    private WebElement logoIcon;

    @FindBy(className = "shopping_cart")
    private WebElement cartDropdown;

    @FindBy(className = "header_user_info")
    private WebElement userInfoBar;

    public WomenShop() {
        driver.get(PropertiesInfo.getInstance().getUrl());
        navigationBar = new NavigationBar();
        itemsPanel = new ItemsPanel();
    }

    public void closeWindows() {
        driver.close();
        driver.quit();
    }

    public ItemsPanel searchItem(String item){
        CommonMethods.setWebElement(searchTextBox, item);
        CommonMethods.clickWebElement(searchButton);
        return new ItemsPanel();
    }

    public boolean searchItemIsDisplayed() {
        return CommonMethods.isElementPresent(searchButton);
    }

    public boolean navigationBarIsDisplayed(){
        return this.navigationBar.navigationBarPresent();
    }

    public boolean logoIconIsDisplayed(){
        return CommonMethods.isElementPresent(logoIcon);
    }

    public boolean itemsPanelIsDisplayed(){
        return this.itemsPanel.itemsPanelIsDisplayed();
    }

    public DressesPage navigateToDressesTab() {
        return this.navigationBar.navigateToDresses();
    }

    public boolean cartDropdownIsDisplayed() {
        return CommonMethods.isElementPresent(this.cartDropdown);
    }

    public boolean userInfoBarIsDisplayed(){
        return CommonMethods.isElementPresent(this.userInfoBar);
    }
}
