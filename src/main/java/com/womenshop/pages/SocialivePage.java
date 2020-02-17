package com.womenshop.pages;

import com.womenshop.core.utils.CommonMethods;
import com.womenshop.core.utils.PropertiesInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SocialivePage extends BasePage{
    @FindBy(id = "userName")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id =  "submitButton")
    private WebElement loginButton;

    public void setUsername(String username) {
        CommonMethods.setWebElement(this.username, username);
    }

    public void setPassword(String password) {
        CommonMethods.setWebElement(this.password, password);
    }

    public SocialiveDashboard clickLoginButton(){
        CommonMethods.clickWebElement(this.loginButton);
        return new SocialiveDashboard();
    }

    public void navigateToSocialive(){
        this.driver.get(PropertiesInfo.getInstance().getUrl());
    }
}
