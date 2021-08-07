package com.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import objectsFactory.HomePage;
import objectsFactory.SignInEmailPage;
import objectsFactory.SignInPasswordPage;

public class Scenario6 extends BaseTest {
	HomePage h;
	SignInEmailPage em;
	SignInPasswordPage pw;
	String UserName = "Anmol";

	@BeforeMethod
	@Parameters({"Email","Password"})
	public void Signin(String email,String password) throws IOException {
		h = new HomePage();
		em = h.ClickSignIn();
		em.EnterEmail(email);
		pw = em.ClickContinue();
		pw.EnterPassword(password);
		h = pw.ClickOnSignIn();
	}

	@Test
	public void SignIn() throws IOException, InterruptedException {

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		String name[] = h.UserName().split(",");
		Thread.sleep(10);
		String Name = name[1].trim();
		Assert.assertEquals(UserName, Name);

	}

	@Test
	public void SignOut() throws IOException, InterruptedException {

		h.ClickOnnAccounts();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
		@Test
	public void WrongCredentials()
	{
		
	}

}
