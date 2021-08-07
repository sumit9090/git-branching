package com.Utils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Utility implements ITestListener {
	static ExtentReports extent=ExtentReportNG.getExtentReportObj();
	//public static ExtentTest test=extent.createTest(",");
	public static ExtentTest test;
	
	
	@Override
	public void onTestStart(ITestResult result) {
			
		test= extent.createTest("Starting the test"+ result.getName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Got Passed"+ result.getName() );
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.log(Status.FAIL,"The Test Got Failed"+result.getMethod().getMethodName());
		test.fail(result.getThrowable()); //to get the error;
		
		
	String method=result.getMethod().getMethodName();
	try {
		System.out.println("the test case got failed.."+method);
		Screenshot(method);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
	extent.flush();	
		
	}

}
