package objectsFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;





public class CameraPage extends BasePage{

	Action a =new Action();

	@FindAll({@FindBy(css=".octopus-pc-item.octopus-pc-item-v3")})
	public java.util.List <WebElement> ListObj;
	
	
	public CameraPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnSearchresult()
	{
		a.click(driver, null);
	}
	public List<WebElement> ListObj()
	{
		return ListObj;
	}
}
