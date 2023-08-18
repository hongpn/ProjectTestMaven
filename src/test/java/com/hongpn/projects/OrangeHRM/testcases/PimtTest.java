package com.hongpn.projects.OrangeHRM.testcases;

import com.hongpn.commons.BaseSetup;
import com.hongpn.listeners.TestListener;
import com.hongpn.logs.LogUtils;
import com.hongpn.projects.OrangeHRM.pages.DashboardPage;
import com.hongpn.projects.OrangeHRM.pages.PIMPage;
import com.hongpn.projects.OrangeHRM.pages.SignInPage;
import com.hongpn.helpers.ExcelHelpers;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Epic("Regression Test HRM")
@Feature("Project Test")
public class PimtTest extends BaseSetup {

    public SignInPage signInPage;
    public DashboardPage dashboardPage;
    private PIMPage pimPage;
    private ExcelHelpers excelHelpers;
    //private WebUI webUI;
    @BeforeMethod
    @Description("Init browser and corresppding classes")
    @Step("Init parameters and browser")
    public void SetUpTest(){
        signInPage = new SignInPage();
        excelHelpers=new ExcelHelpers();
        excelHelpers.setExcelFile("datatest/Login.xlsx", "Sheet1");
    }
    @Test(priority = 0, description = "Sign in to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
    @Step("Sign in page to HRM page")
    public void SignInHRMPage() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/");

        LogUtils.info("Starting SignInHRMPage");
        signInPage = new SignInPage();
        dashboardPage= signInPage.SignIn("Admin", "admin123");
        //webUI.waitForPageLoaded();
    }
    @Test(priority = 1, description = "Search PIM")
    @Step("Click Pim filters")
    public void SearchEmployee() throws InterruptedException {
        //webUI.waitForPageLoaded();
        LogUtils.info("Starting SearchEmployee");
        pimPage= dashboardPage.openPimMenu();
        pimPage.ClickToJobTitle();
        pimPage.ClickToElementStatus();
        pimPage.ClickToSubUnit();
        pimPage.ClickToInclude();
        pimPage.ClickSearch();
    }
}
