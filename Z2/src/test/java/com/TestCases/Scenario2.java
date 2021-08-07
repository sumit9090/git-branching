package com.TestCases;

import java.awt.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import objectsFactory.DirectSearchPage;
import objectsFactory.HomePage;
import objectsFactory.ObjectResultPage;

public class Scenario2 extends BaseTest {
	HomePage hp;
	DirectSearchPage dsp;
	ObjectResultPage orp;

	@BeforeMethod
	public void Initialize() throws IOException, InterruptedException {
		hp = new HomePage();
		dsp = hp.EnterDataDirectSearch("echo dot");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		orp = dsp.ClickOnProduct();

		orp.SwitchToCurrentWindow();

	}

	@Test
	public void ValidateQuantity()

	{

		Assert.assertTrue(orp.QuantityisDisplayed());
		System.out.println("choosing quantiy");
		orp.ChooseQuantity("2");
		System.out.println("validating the quantity");
		Assert.assertEquals(2, orp.validateQuantity());

	}

	@Test
	public void displayed() throws InterruptedException {

		Assert.assertTrue(orp.WishListDisplayed());
		Assert.assertTrue(orp.AddToCArtisDisplayed());
		Assert.assertTrue(orp.BuyNowisDisplayed());
	}

	@Test
	public void CheckInboxes() throws InterruptedException {
		java.util.List<WebElement> li = orp.numberCheckBoxes();
		System.out.println(li.size());
		for (WebElement Check : li) {
			Check.click();
		}
		
	}

}
