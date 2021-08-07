package objectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;

public class Cart extends BasePage {
Action a =new Action();
	@FindBy(className="a-dropdown-prompt")
	WebElement DropDown;
	
	@FindBy(id="dropdown1_0")
	WebElement Delete;
	
	@FindBy(id="nav-cart-count")
	WebElement cart;
	
	public Cart()
	{
		PageFactory.initElements(driver, this);
	}
	public void ClickDropdown()
	{
		a.click(driver, DropDown);
	}
		
	
	public Boolean ValidateCartTotal()
	{
	 a.click(driver, Delete);
	 
	 if(cart.getText().equals("0"))
	 {
		 return true;
	 }
	 else return false;
	}
	
}
