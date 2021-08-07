package com.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Utils.ExtentReportNG;
import com.Utils.Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectsFactory.HomePage;

public class Scenario7 extends BaseTest {
	
	HomePage h;
	ExtentTest test;


	@BeforeMethod
	public void initialize() throws IOException {
		h = new HomePage();
		test=Listeners.test;

	}

	@Test
	public void fOOTERLINKS() {
		List<WebElement> Links = h.Footer();

		for (WebElement li : Links) {
			System.out.println(li.getText());
			
			test.log(Status.INFO, li.getText());
			
		}
		

	}
	@Test
	public void CountryLinks()
	{
		List<WebElement> Country=h.CountryLinks();
		for(WebElement count:Country)
			{
			System.out.println(count.getText());
			}}

}
