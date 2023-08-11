package com.hongpn.projects.OrangeHRM.testcases;

import com.hongpn.commons.BaseSetup;
import com.hongpn.logs.Log;
import com.hongpn.projects.OrangeHRM.pages.DashboardPage;
import com.hongpn.projects.OrangeHRM.pages.PIMPage;
import com.hongpn.projects.OrangeHRM.pages.SignInPage;
import com.hongpn.tools.ExcelHelpers;
import com.hongpn.tools.PropertiesHelpers;
import com.hongpn.utils.listeners.ReportListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReportListener.class)
@Epic("Regression Test HRM")
@Feature("Project Test")
public class PimtTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;
    private ExcelHelpers excelHelpers;
    //private WebUI webUI;
    @BeforeClass
    @Description("Init browser and corresppding classes")
    public void setupBrowser(){
        this.driver = getDriver();
        excelHelpers=new ExcelHelpers();
        PropertiesHelpers.setPropertiesFile();
    }
    @Test(priority = 0, description = "Sign in to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
    @Step("Sign in page to HRM page")
    public void SignInHRMPage() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opensource-demo.orangehrmlive.com/");
        Log.info("Starting SignInHRMPage");
        signInPage = new SignInPage(this.driver);
        dashboardPage= signInPage.SignIn("Admin", "admin123");
        //webUI.waitForPageLoaded();
    }
    @Test(priority = 1, description = "Search PIM")
    @Step("Click Pim filters")
    public void SearchEmployee() throws InterruptedException {
        //webUI.waitForPageLoaded();
        Log.info("Starting SearchEmployee");
        pimPage= dashboardPage.openPimMenu();
        pimPage.ClickToJobTitle();
        pimPage.ClickToElementStatus();
        pimPage.ClickToSubUnit();
        pimPage.ClickToInclude();
        pimPage.ClickSearch();
    }
}
