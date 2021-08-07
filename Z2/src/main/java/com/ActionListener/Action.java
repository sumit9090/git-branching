package com.ActionListener;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import objectsFactory.BasePage;

public class Action extends BasePage implements ActionInterface {

	@Override
	public void click(WebDriver driver, WebElement ele) {
		
		Actions a =new Actions(driver);
		a.moveToElement(ele).click().build().perform();
	}

	@Override
	public boolean isDisplayed( WebElement ele) {
		
		Boolean flag=false;
		if( ele.isDisplayed())
	{flag=true;
	}
		return flag;
	}

	@Override
	public void type(WebElement ele, String text) {
		ele.isDisplayed();
		ele.clear();
		ele.sendKeys(text);
		
	}

	@Override
	public void SwitchToChildWindow(WebDriver driver) {
		
		Set<String> s=driver.getWindowHandles();
		Iterator<String>itr=s.iterator();
		while(itr.hasNext())
		{
			String Parent=itr.next();
			String child=itr.next();
			driver.switchTo().window(child);
		}
	}

	
	 
	

	@Override
	public void mouseHover(WebDriver driver, WebElement ele) {
		Actions a =new Actions(driver);
		a.moveToElement(ele).build().perform();
		
	}

	@Override
	public String toolTip(WebElement ele) {
		return ele.getAttribute("title");
	}

	

	
}

	
	


