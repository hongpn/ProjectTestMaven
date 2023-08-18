package com.hongpn.listeners;

import com.aventstack.extentreports.Status;
import com.hongpn.contants.ConstantGlobal;
import com.hongpn.helpers.CaptureHelpers;
import com.hongpn.helpers.PropertiesHelpers;
import com.hongpn.logs.LogUtils;
import com.hongpn.reports.AllureManager;
import com.hongpn.reports.ExtentReportManager;
import com.hongpn.reports.ExtentTestManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener  implements ITestListener {
    public String getTestName(ITestResult result) {
        return result.getTestName() != null ? result.getTestName() : result.getMethod().getConstructorOrMethod().getName();
    }

    public String getTestDescription(ITestResult result) {
        return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
    }

    @Override
    public void onStart(ITestContext result) {
        PropertiesHelpers.loadAllFiles();

        LogUtils.info("Starting Suite: " + result.getStartDate());
        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelpers.startRecord(result.getName());
        }
    }

    @Override
    public void onFinish(ITestContext result) {
        LogUtils.info("Finish Suite: " + result.getEndDate());
        if (ConstantGlobal.RECORD_VIDEO.equals("yes")) {
            CaptureHelpers.stopRecord();
        }
        ExtentReportManager.getExtentReports().flush(); //Kết thúc và thực thi xuất report ra file
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTestManager.saveToReport(getTestName(result), getTestDescription(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (ConstantGlobal.SCREENSHOT_PASS.equals("yes")) {
            CaptureHelpers.takeScreenshot(result); //Chụp màn hình khi Fail
        }

        LogUtils.info(result.getName() + " is pass.");
        ExtentTestManager.logMessage(Status.PASS, result.getName() + " is passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        if (ConstantGlobal.SCREENSHOT_FAIL.equals("yes")) {
            CaptureHelpers.takeScreenshot(result); //Chụp màn hình khi Fail
        }

        LogUtils.error(result.getThrowable().toString());
        LogUtils.error(result.getName() + " is fail.");

        //Extent Report
        ExtentTestManager.addScreenShot(result.getName());
        ExtentTestManager.logMessage(Status.FAIL, result.getThrowable().toString());
        ExtentTestManager.logMessage(Status.FAIL, result.getName() + " is failed.");

        //Allure Report
        AllureManager.saveTextLog(result.getName() + " is failed.");
        AllureManager.saveScreenshotPNG();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (ConstantGlobal.SCREENSHOT_FAIL.equals("yes")) {
            CaptureHelpers.takeScreenshot(result); //Chụp màn hình khi Skip
        }
        LogUtils.warn(result.getName() + " is skipped.");
        ExtentTestManager.logMessage(Status.SKIP, result.getThrowable().toString());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }
}
