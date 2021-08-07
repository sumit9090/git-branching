package objectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;

public class AddToCart extends BasePage {
 
	@FindBy(css=".a-size-medium.a-text-bold")
	WebElement AddToCartText;
	 Action a =new Action();
	 
	 @FindBy(id="nav-cart-count")
	 WebElement count;
	 @FindBy(css="#hlb-view-cart-announce")
	 WebElement Cart;
	 
	 @FindBy(css=".a-color-price.hlb-price.a-inline-block.a-text-bold")
	 WebElement Price;
	  
	 public AddToCart()
	 {
		 PageFactory.initElements(driver,this);
		 Action a =new Action();
	 }
	 
	 public Boolean ValidateText()
	 { return a.isDisplayed(AddToCartText);
		 
	 }
	 
	 public String returnPrice()
	 {
		 return Price.getText();
	 }
	 public Boolean ValidateCount()
	 {
		 int a=Integer.parseInt(count.getText());
		 System.out.println(a);
		 if(a>=1)
		 { return true;}
		 else {return false;}
		}
	 
	public Cart ClickonCart()
	
	{
		a.click(driver,Cart);
		return new Cart();
		
	}
}
