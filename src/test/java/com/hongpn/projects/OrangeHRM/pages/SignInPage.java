package com.hongpn.projects.OrangeHRM.pages;

import com.hongpn.commons.WebUI1;
import com.hongpn.drivers.DriverManager;
import com.hongpn.helpers.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {

    private final By UsernameInput=By.xpath("//input[@placeholder='Username']");
    private final By PasswordInput=By.xpath("//input[@placeholder='Password']");
    private final By LoginBtn=By.xpath("//button[normalize-space()='Login']");

    public DashboardPage SignIn(String usernameValue, String passwordValue) throws InterruptedException {
        WebUI.openURL("https://opensource-demo.orangehrmlive.com/");
        // verify whether we're in login page or not
        WebUI.waitForPageLoaded();
        //Assert.assertTrue(helper.verifyTxtElement(LoginBtn, "Login"),"Access wrong login page!");
        WebUI.setText(UsernameInput,usernameValue);
        WebUI.setText(PasswordInput,passwordValue);
        WebUI.clickElement(this.LoginBtn);
        return new DashboardPage();
    }
}
