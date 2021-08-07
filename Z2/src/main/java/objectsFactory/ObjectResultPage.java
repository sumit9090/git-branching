package objectsFactory;

//wrong IMPORT    import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ActionListener.Action;

public class ObjectResultPage extends BasePage {
	Action a = new Action();
	@FindBy(css = "#quantity")
	WebElement Quantity;

	@FindAll({ @FindBy(xpath = "//input[@type='checkbox']") })
	public java.util.List<WebElement> Checkbox;

	// @FindBy(id = "submit.add-to-cart")
	@FindBy(css = "#add-to-cart-button")
	WebElement AddToCart;

	@FindBy(xpath = "//span[@class='a-button-inner'] //a[@name='submit.add-to-registry.wishlist.unrecognized']")
	WebElement WishList;

	@FindBy(id = "buy-now-button")
	WebElement BuyNow;

	@FindBy(id = "facebook")
	WebElement FB;

	@FindBy(id = "twitter")
	WebElement Twitter;

	@FindBy(id = "pinterest")
	WebElement Pinterest;

	@FindBy(id = "a-autoid-5-announce")
	WebElement Dialoguebox;

	@FindBy(xpath = "//button[@data-action='a-popover-close']")
	WebElement Close;

	@FindBy(id = "priceblock_ourprice")
	WebElement Price;

	public ObjectResultPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean QuantityisDisplayed() {
		return a.isDisplayed(Quantity);
	}

	public Boolean WishListDisplayed() {
		return a.isDisplayed(WishList);
	}

	public Boolean BuyNowisDisplayed() {
		return a.isDisplayed(BuyNow);
	}

	public Boolean AddToCArtisDisplayed() {
		return a.isDisplayed(AddToCart);
	}

	public void SwitchToCurrentWindow() {
		a.SwitchToChildWindow(driver);
	}

	public void ChooseQuantity(String value) {
		Select s = new Select(Quantity);
		s.selectByVisibleText(value);

	}

	public String validateQuantity() {
		Select s = new Select(Quantity);
		return s.getFirstSelectedOption().getText();
	}

	public Boolean preSelectCheckBox() {
		return ((WebElement) Checkbox).isSelected();
	}

	public Boolean SelectedCheckBox() {
		return ((WebElement) Checkbox).isSelected();
	}

	public java.util.List<WebElement> numberCheckBoxes() {
		return Checkbox;
	}

	public String AddToCartToolTip() {
		a.mouseHover(driver, AddToCart);

		return a.toolTip(AddToCart);
		// return AddToCart.getAttribute("title");

	}

	public String AddToWishlistToolTip() {
		a.mouseHover(driver, WishList);
		return a.toolTip(WishList);
		// return WishList.getAttribute("title");
	}

	public void ClickFaceBook() {
		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		// a.click(driver, FB);
		FB.sendKeys(clickOnLink);
	}

	public void ClickTwitter() {
		// a.click(driver, Twitter);
		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		Twitter.sendKeys(clickOnLink);
	}

	public void ClickPinterest() {
		// a.click(driver, Pinterest);
		String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
		Pinterest.sendKeys(clickOnLink);

	}
	public String returnPrice()
	{
		return Price.getText();
	}

	// Storing the opened tabs's title in a window
	public ArrayList StoreTitle() {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		List<String> actualTitleList = new ArrayList<>();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			// Storing the names in the Array list:
			actualTitleList.add(driver.getTitle());

		}
		actualTitleList.remove(0);
		return (ArrayList) actualTitleList;

	}

	public ArrayList StoreURL() {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		List<String> actualURLList = new ArrayList<>();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			// Storing the URL in the Array list:
			actualURLList.add(driver.getCurrentUrl());

		}
		actualURLList.remove(0);
		actualURLList.remove(1);
		actualURLList.remove(2);
		
		return (ArrayList) actualURLList;
	}

	public void ClickAddToCart() {
		a.click(driver, AddToCart);
	}

	public AddToCart ValidateDilogBox() {

		/*if (Close.isDisplayed()) {
			a.click(driver, Close);
		}*/
		return new AddToCart();
	}

}
