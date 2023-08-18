package com.hongpn.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.hongpn.contants.ConstantGlobal;

public class ExtentReportManager {
    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(ConstantGlobal.EXTENT_REPORT_PATH);
        reporter.config().setReportName("Extent Report | Anh Tester");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java Course 04/2022 | Anh Tester");
        extentReports.setSystemInfo("Author", ConstantGlobal.AUTHOR);
        return extentReports;
    }
}
