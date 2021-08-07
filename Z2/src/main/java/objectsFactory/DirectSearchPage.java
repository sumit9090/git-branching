package objectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;

public class DirectSearchPage  extends BasePage{

	Action a =new Action();
	@FindBy(xpath="(//a[@class='a-link-normal s-no-outline'])[1]")
		WebElement FirstProduct;
	
	public DirectSearchPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public ObjectResultPage ClickOnProduct()
	{
		a.click(driver, FirstProduct);
		return new ObjectResultPage();
	}
	
	
	
	
	
}
