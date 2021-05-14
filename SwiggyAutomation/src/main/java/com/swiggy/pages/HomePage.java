package com.swiggy.pages;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.codoid.products.exception.FilloException;
import com.swiggy.Base.BaseClass;
import com.swiggy.reports.ExtentReportClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends BaseClass {

	public HomePage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		this.driver = driver;

	}

	@AndroidFindBy(id = "set_location_text")
	MobileElement locationButton;

	@AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	MobileElement permissionPopup;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.TextView")
	MobileElement turnOnLocationButton;

	@AndroidFindBy(id = "google_place_search_title_text1")
	MobileElement confirmLocation;

	@AndroidFindBy(id = "bottom_bar_explore")
	MobileElement searchButton;

	@AndroidFindBy(id = "bottom_bar_restaurant_title")
	MobileElement footerSwiggyButton;

	@AndroidFindBy(id = "bottom_bar_cart_title")
	MobileElement cartButton;

	@AndroidFindBy(id = "bottom_bar_account_title")
	MobileElement myAccountButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText")
	MobileElement searchBar;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
	MobileElement foodItem;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]")
	MobileElement restaurantButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[4]")
	MobileElement selectItem;

	WebDriverWait wait = new WebDriverWait(driver, 100);

	public void homePageVerifications() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		locationButton.click();
		permissionPopup.click();
		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOf(confirmLocation));
		confirmLocation.click();
		if (searchButton.isDisplayed())
			ExtentReportClass.extentTest.log(Status.PASS, "Home Page of Swiggy Displayed");
		else
			ExtentReportClass.extentTest.log(Status.FAIL, "Home Page of Swiggy Failed");

	}

	public void verifyFooterInHomePage() throws InterruptedException {
		Thread.sleep(2000);
		if (searchButton.isDisplayed() && footerSwiggyButton.isDisplayed() && cartButton.isDisplayed()
				&& myAccountButton.isDisplayed())
			ExtentReportClass.extentTest.log(Status.PASS, "All the footers in the Home Page of Swiggy Displayed");
		else
			ExtentReportClass.extentTest.log(Status.FAIL,
					"All the footers in the Home Page of Swiggy is not Displayed");
	}

	public void verifySearchItem(ExtentReportClass report, String className) throws InterruptedException, FilloException {

		Thread.sleep(3000);
		searchButton.click();
		System.out.println("Clicked");
		ExtentReportClass.extentTest.log(Status.PASS, "Search Button is clicked");
		Thread.sleep(3000);
		searchBar.sendKeys(getData(className, "FoodItem"));
		wait.until(ExpectedConditions.visibilityOf(foodItem));
		ExtentReportClass.extentTest.log(Status.PASS, "Food item sent to Search Text box=" + "Samosa Party");

		foodItem.click();
		wait.until(ExpectedConditions.visibilityOf(restaurantButton));
		if (restaurantButton.isDisplayed()) {
			restaurantButton.click();
			ExtentReportClass.extentTest.log(Status.PASS, "Restaurant item button clicked to select item");
		} else
			ExtentReportClass.extentTest.log(Status.PASS, "Restaurant item button is not selected");
	}

	public void selectItemFromRestaurant() throws InterruptedException {

		Thread.sleep(3000);

		if (selectItem.isDisplayed()) {
			selectItem.click();
			ExtentReportClass.extentTest.log(Status.PASS, "Item has been selected from Restaurant");

		} else
			ExtentReportClass.extentTest.log(Status.PASS, "Item has not selected from Restaurant");

	}

}
