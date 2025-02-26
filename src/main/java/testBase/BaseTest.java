package testBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;



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

	
	

	

/*	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		intializeDriver();
		LandingPage landingPage=new LandingPage();
		return landingPage;
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}*/
	
}
