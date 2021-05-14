package com.swiggy.reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;

public class Screenshots {

	public static String takeScreeShot(AppiumDriver<?> driver) throws Exception{
		String timeStamp = new SimpleDateFormat("yyyymmdd_HHmmss").format(new Date());
		String fileName = System.getProperty("user.dir")+"/Screenshots/report"+timeStamp+".png";
		File destFile = new File(fileName);
		TakesScreenshot ss= ((TakesScreenshot)driver);
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, destFile);
		
		return fileName;
	}
}
