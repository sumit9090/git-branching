package com.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Utils.Utility;

import objectsFactory.BasePage;
import objectsFactory.UploadFiles;

public class Scenario8 extends BaseTest {
	
	@Test
	public void UploadFile() throws InterruptedException, IOException {
		driver.get("https://easyupload.io");
		//DesiredCapabilities ch=DesiredCapabilities.chrome();
		//ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		UploadFiles a=new UploadFiles();
		
		WebElement UploadBox=a.UploadBox();
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(590,75)");
		Thread.sleep(5000);
		UploadBox.click();
		//a.Clickk();
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Runtime.getRuntime().exec("C:\\Users\\Anmol Kaur\\Documents\\FileUpload.exe");
		Thread.sleep(5000);
		a.ClickOnUploadButton();
		WebDriverWait wait= new WebDriverWait(driver,300);
		WebElement msg=a.SuccessMsg();
		wait.until(ExpectedConditions.visibilityOf(msg));
		Assert.assertEquals(msg.getText(),"Your file has been uploaded successfully.");
		
		
		
	
		
	}
	
	
} 
