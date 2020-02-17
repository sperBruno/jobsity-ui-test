package com.womenshop.pages;

        import com.womenshop.core.utils.CommonMethods;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

public class SocialiveDashboard {

    @FindBy(className = "account-nav")
    private WebElement userNavBar;

    public boolean isUserNavBarDisplayed(){
        return CommonMethods.isElementPresent(this.userNavBar);
    }
}
