package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageObjects.LandingPage;
import pageObjects.ProductCatalogPage;

public class BaseTest {
	public static WebDriver driver;
	public static  Properties prop;
	

	public BaseTest() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		prop.load(fis);
	}


     
	public static void intializeDriver()  {
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");

		switch(browserName) {
		case "chrome":
			driver=new ChromeDriver(); break;
		case "edge":
			driver=new EdgeDriver(); break;
		case "firefox":
			driver=new FirefoxDriver(); break;
		default:
			System.out.println("invalid browser");
		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
		
	}

	
	

	public void waitForElementToAppear(By findBy ) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementPresence(By findBy ) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(findBy));
	}
	public void waitForElemenToBeClickable(By findBy ) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeSelected(findBy));
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		intializeDriver();
		LandingPage landingPage=new LandingPage();
		return landingPage;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
