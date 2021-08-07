package objectsFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionListener.Action;

public class UploadFiles extends BasePage {
	Action a = new Action();

	
	@FindBy(id = "dropzone")
	WebElement UploadOption;

	@FindBy(id = "upload")
	WebElement UploadButton;
	
	@FindBy(xpath="//div[@class='upload-success']/h5")
	WebElement Success;
	

	public UploadFiles() {
		PageFactory.initElements(driver, this);
	}

	public void Clickk() 
	{ // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
													// UploadOption);
													// UploadOption.sendKeys(file);
		a.click(driver, UploadOption);
	}

	public void ClickOnUploadButton() {
		a.click(driver, UploadButton);
	}
	
	public WebElement UploadBox()
	{
		return UploadOption;
	}
public WebElement SuccessMsg()
{
	return Success;
	}
	
}
