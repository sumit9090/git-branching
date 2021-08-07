package com.TestCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import objectsFactory.CameraPage;
import objectsFactory.HomePage;

public class Scenario1 extends BaseTest {

	HomePage ah;
	CameraPage sp;
	int j;

	@BeforeMethod()
	public void InitiializeObj() throws IOException {
		ah = new HomePage();
		sp = new CameraPage();
	}

	@Test
	public void T1() {

		Assert.assertEquals(true, ah.textBoxDisplayed());

		Assert.assertEquals(true, ah.SearchButton());

	}

	@Test

	public void T2_T3() throws IOException, InterruptedException {

		ah.EnterData("Echo dot");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> li = ah.ListObjects();

		for (WebElement lis : li) {
			{driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println(lis.getText());
				Assert.assertTrue(lis.getText().contains("echo dot"));

			}
		}
	}

	@Test
	public void T4() throws InterruptedException {
		sp = ah.Clickable();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 List<WebElement> li = sp.ListObj();

		 int Num = li.size();
		 System.out.println(Num);

	}

}
