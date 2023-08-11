package com.hongpn.projects.OrangeHRM.pages;

import com.hongpn.commons.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends Menu {
    private WebDriver driver;
    private WebUI helper;

    //url Dashboard
    private  final String urlDashboard="/dashboard";
    //Header Page
    private final By headerPage=By.xpath("//h6[normalize-space()='Dashboard']");
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        helper = new WebUI(driver);
        setParameters(headerPage,urlDashboard,"Dashboard");
    }
}
