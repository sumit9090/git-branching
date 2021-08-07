package com.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import objectsFactory.BasePage;

public class BaseTest extends BasePage  {

	@BeforeMethod
	public void setup() throws IOException {
		
		InitializeDriver();
		
	}
	@AfterMethod
	public void close() {
		
		CloseBrowser();
	}

}
