package pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseTest;




public class CheckOutPage extends BaseTest{

	

	public CheckOutPage() throws IOException {
		super();
		
		PageFactory.initElements(driver,this);
	}


	


	@FindBy (xpath="//input[@placeholder='Select Country']") WebElement countryInputBox;
	By  countryInputBoxBy=By.xpath("//input[@placeholder='Select Country']");
	@FindBy (xpath="//section[@class='ta-results list-group ng-star-inserted']/button[2]") WebElement selectCountryDropDown;
	@FindBy(xpath="//div[@class='actions']/a[text()='Place Order ']") WebElement placeOrder;
	
	
	
	
	public void selectCountryInputBox(String countryName) throws InterruptedException {
		Actions a=new Actions(driver);
		a.sendKeys(countryInputBox,countryName).build().perform();
		//waitForElementPresence(countryInputBoxBy);
		Thread.sleep(3000);
		selectCountryDropDown.click();
		Thread.sleep(3000);

	}

	public ConfirmationPage placeOrder() throws InterruptedException, IOException {
		placeOrder.click();
		Thread.sleep(3000);
		return new ConfirmationPage();
	}

	
}
