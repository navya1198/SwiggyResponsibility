package com.maven.SwiggyAutomation;

import java.lang.reflect.Method;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.swiggy.Base.BaseClass;
import com.swiggy.pages.ActivitiesSwiggy;
import com.swiggy.pages.HomePage;
import com.swiggy.reports.ExtentReportClass;
import com.swiggy.reports.Screenshots;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ExecutionClass extends BaseClass {

	AndroidDriver<MobileElement> driver1 = null;
	ActivitiesSwiggy activities;
	HomePage hp;
	static ExtentReportClass report = new ExtentReportClass();
	// ExtentTest extentTest;

	@BeforeClass
	public void beforeClass() throws Exception {
		driver1 = setUP_Android("Android", "10", "52953f4", "http://0.0.0.0:4723/wd/hub");
	}

	@BeforeMethod
	public void beforeMethod(Method result) {
		driver1.launchApp();
		hp = new HomePage(driver1);
		activities = new ActivitiesSwiggy(driver1);
	}

	@Test(priority = 1)
	public void verify_VerifyHomePageOfSwiggy(Method result) throws Exception {
		try {
			Thread.sleep(10000);

			report.extentreport(result.getName());
			ExtentReportClass.extentTest.log(Status.PASS, "App launched");
			hp.homePageVerifications();
			ExtentReportClass.extentTest.log(Status.PASS, "App launched and Verified HomePage of Swiggy");
			hp.verifyFooterInHomePage();
			ExtentReportClass.extentTest.log(Status.PASS, "All the footers in the home Page is Verified");
			hp.selectItemFromRestaurant();
			ExtentReportClass.extentTest.log(Status.PASS, "Items are added to Cart");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			String fileName = Screenshots.takeScreeShot(driver1);
			ExtentTest path = ExtentReportClass.extentTest.addScreenCaptureFromPath(fileName);
			path.log(Status.FAIL, "Home page failed");
		}
	}
	
/*	@Test(priority = 1)
	public void verify_VerifySwiggyFooter(Method result) throws Exception {
		try {
			Thread.sleep(10000);

			report.extentreport(result.getName());
			ExtentReportClass.extentTest.log(Status.PASS, "Home Page Displayed");
			hp.verifyFooterInHomePage();
			ExtentReportClass.extentTest.log(Status.PASS, "All the footers in the home Page is Verified");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			String fileName = Screenshots.takeScreeShot(driver1);
			ExtentTest path = ExtentReportClass.extentTest.addScreenCaptureFromPath(fileName);
			path.log(Status.FAIL, "All the footers in the home Page is not Displayed");
		}
	}
	*/
	

	@AfterClass
	public void afterSuite() {

		report.extentReports.flush();
	}

}
