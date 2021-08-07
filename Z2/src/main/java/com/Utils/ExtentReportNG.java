package com.Utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectsFactory.BasePage;

public class ExtentReportNG extends BasePage {
	
	public static ExtentReports extent;
	@BeforeMethod
	public static ExtentReports getExtentReportObj()
	{
    String path=System.getProperty("user.dir")+"\\REPORTS\\index.html";
	
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("TEST CASES REPORT");
	reporter.config().setReportName("AMAZON TEST CASES REPORT");
	
	// now we need to have ExtentReport extent;
	 extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "ANMOL");
	return extent;
	
	
}
	
	
}
	
