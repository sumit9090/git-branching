package com.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectsFactory.AddToCart;
import objectsFactory.Cart;
import objectsFactory.DirectSearchPage;
import objectsFactory.HomePage;
import objectsFactory.ObjectResultPage;

public class Scenario4 extends BaseTest {
	HomePage hp;
	DirectSearchPage dsp;
	ObjectResultPage orp;
	SoftAssert as;
	AddToCart at;
	Cart c;

	@BeforeMethod
	public void Initialize() throws IOException, InterruptedException {
		hp = new HomePage();
		dsp = hp.EnterDataDirectSearch("echo dot");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		orp = dsp.ClickOnProduct();
		
		orp.SwitchToCurrentWindow();
		as = new SoftAssert();

	}

	@Test(priority=0)
	public void ValidateLabel() throws InterruptedException {
		orp.ClickAddToCart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		at = orp.ValidateDilogBox();
		Assert.assertTrue(at.ValidateText());
		Thread.sleep(5000);

	}

	@Test(priority=1)
	public void ValidateCount() throws InterruptedException {
		orp.ClickAddToCart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		at = orp.ValidateDilogBox();
		Assert.assertTrue(at.ValidateCount());
		Thread.sleep(5000);
	}

	@Test(priority=2)
	public void DeleteItems() throws InterruptedException {
		orp.ClickAddToCart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		at = orp.ValidateDilogBox();
		c = at.ClickonCart();
		c.ClickDropdown();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(c.ValidateCartTotal());

	}

	@Test(priority=3)
	public void validatePrice() throws InterruptedException {
		String a = orp.returnPrice();
		String z[] = a.split(" ");
		String price1 = z[1].trim();
		orp.ClickAddToCart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		at = orp.ValidateDilogBox();
		String b = at.returnPrice();
		String x[] = b.split("₹");
		String price2 = x[1];
		Assert.assertEquals(price1, price2);
	}
}
