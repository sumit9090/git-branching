package com.ActionListener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	//public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public void click(WebDriver driver, WebElement ele);
	public boolean isDisplayed(WebElement ele);
	public void type(WebElement ele, String text);
	public String toolTip(WebElement ele);
	public void SwitchToChildWindow(WebDriver driver);
	public void mouseHover(WebDriver driver,WebElement ele);
	

}
