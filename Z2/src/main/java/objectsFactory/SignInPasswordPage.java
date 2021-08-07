package objectsFactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;

public class SignInPasswordPage extends BasePage {
	Action a =new Action();
	public SignInPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ap_password")
	WebElement Password;
	
	@FindBy(id="signInSubmit")
	WebElement SignInButton;
	
	public void EnterPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	public HomePage ClickOnSignIn() throws IOException
	{
		a.click(driver, SignInButton);
		return new HomePage();
	}
	

}
