package com.TestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectsFactory.BasePage;
import objectsFactory.DirectSearchPage;
import objectsFactory.HomePage;
import objectsFactory.ObjectResultPage;

public class Scenario3 extends BaseTest {

	HomePage hp;
	DirectSearchPage dsp;
	ObjectResultPage orp;
	SoftAssert as;

	@BeforeMethod
	public void Initialize() throws IOException, InterruptedException {
		hp = new HomePage();
		dsp = hp.EnterDataDirectSearch("echo dot");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		orp = dsp.ClickOnProduct();
		orp.SwitchToCurrentWindow();
		as = new SoftAssert();

	}

	@Test
	public void T1() throws InterruptedException

	{
		Assert.assertEquals(orp.AddToWishlistToolTip(), "Add to Wish List");
		Assert.assertEquals(orp.AddToCartToolTip(), "Add to Shopping Cart");

	}

}
