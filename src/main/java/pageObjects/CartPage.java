package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseTest;




public class CartPage  extends BaseTest{

	
	public CartPage() throws IOException {
		
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath="//div[@class='cartSection']/h3") List<WebElement> cartProducts;
	By cartProductsBy= By.xpath("//div[@class='cartSection']/h3");
	@FindBy (xpath="//ul/li/button[@class='btn btn-primary']") WebElement checkOut;
	By checkOutBy=By.xpath("//ul/li/button[@class='btn btn-primary']");
	

	
	public Boolean verifyProductDisplay(String productName) throws InterruptedException {
		//waitForElementToAppear(cartProductsBy );
		Thread.sleep(3000);	
		boolean status=cartProducts.stream().anyMatch(f->f.getText().equals(productName));
		return status;
	}

	public CheckOutPage clickCheckOut() throws IOException, InterruptedException {
	//	waitForElementToAppear(checkOutBy );
		Thread.sleep(3000);
		checkOut.click();
		return new CheckOutPage();
	}

	

}
