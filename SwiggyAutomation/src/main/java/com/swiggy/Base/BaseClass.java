package com.swiggy.Base;

import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static AndroidDriver<MobileElement> driver;

	static Properties prop;

	public static int TotalCount = 0;
	public static int countPass = 0;
	public static int countFail = 0;
	public static int status = 0;


	public AndroidDriver<MobileElement> setUP_Android(String pName, String pVersion, String devicename, String url)
			throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, pVersion);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, pName);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, devicename);
		capabilities.setCapability("appPackage", "in.swiggy.android");
		capabilities.setCapability("appActivity", "in.swiggy.android.activities.HomeActivity"); //activities.HomeActivity"
		URL url1 = new URL(url);
		driver = new AndroidDriver<MobileElement>(url1, capabilities);
		System.out.println("App launched");
		return driver;
	}

	public static String getData(String row, String col) throws FilloException  {
		Fillo fillo = new Fillo();
		Connection connection = fillo.getConnection(
				"C:/AutomationFrameworkHeaderAndFooter/SwiggyAutomation/SwiggyTestData.xlsx");
		String val = "";
		String strQuery = "Select * from Swiggy where TestCase = " + "'" + row + "'";
		Recordset recordset = connection.executeQuery(strQuery);
		
		while (recordset.next()) {
			System.out.println(recordset.getField(col));
			val = recordset.getField(col);

		}
		// recordset.close();
		// connection.close();
		return val;

	}
	
	
}
