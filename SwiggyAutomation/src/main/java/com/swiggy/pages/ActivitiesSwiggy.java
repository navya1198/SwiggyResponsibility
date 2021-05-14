package com.swiggy.pages;

import org.openqa.selenium.support.PageFactory;

import com.swiggy.Base.BaseClass;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ActivitiesSwiggy extends BaseClass{

	
	public ActivitiesSwiggy(AndroidDriver<MobileElement> driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
     	this.driver = driver;
	}

}
