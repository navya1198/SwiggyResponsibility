package com.swiggy.reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportClass {

	public ExtentHtmlReporter extentHtmlReporter;
	public static ExtentTest extentTest;
	public ExtentReports extentReports;
	
	public ExtentReportClass()
	{
		Date date=new Date();
		SimpleDateFormat file=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String fileName=file.format(date);
		extentHtmlReporter=new ExtentHtmlReporter("C://AutomationFrameworkHeaderAndFooter//SwiggyAutomation//Screenshot//"+fileName+".html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}
	
	public void extentreport(String result)
	{
		extentTest=extentReports.createTest(result);
	}

	public void getFlush()
	{
		extentReports.flush();
	}

}
