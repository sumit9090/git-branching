package objectsFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;

public class SignInEmailPage extends BasePage {
	Action a=new Action();
	
	public SignInEmailPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="ap_email")
	WebElement Email;
	 
	@FindBy(id="continue")
	WebElement Continue;
	
	public void EnterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	public SignInPasswordPage ClickContinue()
	{
		a.click(driver, Continue);
		return new SignInPasswordPage();
	}
	
	

}
