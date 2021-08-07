package objectsFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BasePage
{
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log;
	public WebDriver InitializeDriver() throws IOException {
		log=LogManager.getLogger(BasePage.class.getName());
		prop = new Properties();
		String path=System.getProperty("user.dir")+"\\src\\main\\java\\com\\Utils\\prop.properties";
		
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
        //  ChromeOptions options=new ChromeOptions();
         /* options.addArguments("--disable-blink-features=AutomationControlled");
          options.addArguments("ignore-certificate-errors");
          options.addArguments("--no-sandbox"); 
         // options.add_experimental_option("excludeSwitches", ["enable-automation"]);
          options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
          options.setExperimentalOption("useAutomationExtension",false);
          options.addArguments("--disable-blink-features=AutomationControlled");*/
         
        
		
		if (browser.equalsIgnoreCase("Chrome")) {
			/*System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Anmol Kaur\\Downloads\\chromedriver_win32\\chromedriver.exe");*/
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
		}
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.firefox.driver", "url");
			
		}
		
		String urlName = prop.getProperty("url");
		driver.get(urlName);
		
		driver.manage().window().maximize();

		return driver;
		

	}

	
	 
	  public void CloseBrowser() 
	  
	  {
		  if(driver!=null) 
		  driver.quit();
	  }

}