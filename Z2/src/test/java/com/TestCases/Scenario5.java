package com.TestCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objectsFactory.DirectSearchPage;
import objectsFactory.HomePage;
import objectsFactory.ObjectResultPage;

public class Scenario5 extends BaseTest {

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
		//.sleep(5000);
		orp.SwitchToCurrentWindow();
		as = new SoftAssert();

	}

	@Test
	public void T1() throws InterruptedException { // String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		orp.ClickFaceBook();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		orp.ClickTwitter();
		
		orp.ClickPinterest();
		
		ArrayList<String> actual = orp.StoreTitle(); // storing the titles in the arrayList

		List<String> expected = new ArrayList<>();
		//expected.add(
				//"Echo Dot (3rd Gen) - #1 smart speaker brand in India with Alexa (Black) : Amazon.in: Electronics");
		         
		
		expected.add("Pinterest");
		expected.add("Twitter");
		expected.add("Facebook");

		// Verifying that both Lists are same:
		Assert.assertEquals(actual, expected);

	}
}
