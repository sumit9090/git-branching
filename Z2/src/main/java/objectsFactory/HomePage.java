package objectsFactory;


import java.io.IOException;
import java.util.List;

import javax.naming.directory.SearchResult;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;

public class HomePage extends BasePage {

	Action a = new Action();
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;

	@FindBy(css = "input[value='Go']")
	WebElement SearchButton;

	@FindBy(xpath = "//span[@class='hm-icon-label']")
	WebElement All;

	@FindBy(xpath = "//*[contains(text(),'TV, Appliances, Electronics')]")
	WebElement TV;

	@FindBy(xpath = "//*[contains(text(),'DSLR Cameras')]")
	WebElement DSLR;

	@FindAll({ @FindBy(xpath = "//div[@id='nav-flyout-searchAjax']/div/div //div[@data-type='a9']") })
	public java.util.List<WebElement> ListObj;

	@FindBy(id = "navFooter")
	WebElement Footer;
	
	@FindBy(xpath="(//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine'])[2]")
	WebElement CountryLinks;
	
	@FindBy(xpath="//a[@data-nav-role='signin']")
	WebElement SignIn;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	WebElement UserName;
	
	@FindBy(id="nav-link-accountList")
	WebElement Accounts;
	
	//@FindBy(xpath="//*[contains(text(), 'Sign Out')]")
	@FindBy(id="nav-item-signout")
	WebElement Signout;

	public HomePage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public Boolean textBoxDisplayed() {
		return a.isDisplayed(searchBox);
	}

	public Boolean SearchButton() {
		return a.isDisplayed(SearchButton);
	}

	public void EnterData(String data) {
		a.type(searchBox, data);
	}
	
	public DirectSearchPage EnterDataDirectSearch(String data)
	{
		a.type(searchBox, data);
		a.click(driver,SearchButton);
		
		return new DirectSearchPage();
	}

	public java.util.List<WebElement> ListObjects() {
		return ListObj;
	}

	public CameraPage Clickable() throws InterruptedException {
		
		a.click(driver, All);
		a.click(driver, TV);
		a.click(driver, DSLR);
		return new CameraPage();
	}
	
	public  java.util.List<WebElement> Footer()
	{
		 // List foo1=(List) Footer.findElements(By.tagName("a"));
		  //return  (java.util.List<WebElement>) foo1;
		return Footer.findElements(By.tagName("a"));
		
	}
	public List<WebElement> CountryLinks()
	{
		return CountryLinks.findElements(By.tagName("a"));
		
	}
	public  SignInEmailPage ClickSignIn()
	{
		 a.click(driver,SignIn) ;
		 return new SignInEmailPage();
	}
	
	public String UserName()
	{
		return UserName.getText();
	}
	public void ClickOnnAccounts()
	{
		a.mouseHover(driver, Accounts);
	}
	public void Signout()
	{
		
		a.mouseHover(driver, Signout);
		a.click(driver, Signout);
		
	}
	
}
