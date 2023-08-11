package com.hongpn.projects.OrangeHRM.pages;

import com.hongpn.commons.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {
    WebDriver driver;
    WebUI helper;
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        helper=new WebUI(this.driver);
    }
    private final By UsernameInput=By.xpath("//input[@placeholder='Username']");
    private final By PasswordInput=By.xpath("//input[@placeholder='Password']");
    private final By LoginBtn=By.xpath("//button[normalize-space()='Login']");

    public DashboardPage SignIn(String usernameValue, String passwordValue) throws InterruptedException {
        // verify whether we're in login page or not
        helper.waitForJQueryLoaded();
        Assert.assertTrue(helper.verifyTxtElement(LoginBtn, "Login"),"Access wrong login page!");
        helper.setText(UsernameInput,usernameValue);
        helper.setText(PasswordInput,passwordValue);
        helper.clickElement(this.LoginBtn);
        return new DashboardPage(this.driver);
    }
}
