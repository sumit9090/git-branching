package com.Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



import objectsFactory.BasePage;

public class Utility extends BasePage {

	

	public static void Screenshot(String method) throws IOException

	{
	
		File sr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println(driver.getCurrentUrl());
			FileUtils.copyFile(sr,new File("C:/Users/Anmol Kaur/eclipse-workspace/Z2/Screenshot/" +"_" +method + "_"+".png"));
		
		} catch (IOException e) {

			System.out.println("cant take screenshot");
		}

	}
	
	
}
