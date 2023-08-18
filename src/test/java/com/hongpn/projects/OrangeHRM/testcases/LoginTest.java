package com.hongpn.projects.OrangeHRM.testcases;

import com.hongpn.commons.BaseSetup;
import com.hongpn.logs.LogUtils;
import com.hongpn.projects.OrangeHRM.pages.DashboardPage;
import com.hongpn.projects.OrangeHRM.pages.SignInPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseSetup {
    public SignInPage signInPage;
    public DashboardPage dashboardPage;

    @BeforeMethod
    public void SetUpTest() {
        signInPage = new SignInPage();
    }

    @Test(priority = 0)
    public void SignInHRMPage() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/");

        LogUtils.info("Starting SignInHRMPage");
        signInPage = new SignInPage();
        dashboardPage = signInPage.SignIn("Admin", "admin123");
        //webUI.waitForPageLoaded();
    }
}
