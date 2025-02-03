package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import testBase.BaseTest;





public class ProductCatalogPage extends BaseTest{

	
	public ProductCatalogPage() throws IOException{
		super();
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath="//div[contains(@class,'mb-3')]") List<WebElement> products;
	By productsBy= By.xpath("//div[contains(@class,'mb-3')]");

	@FindBy (id="toast-container") WebElement productAddedToCart;
	By addToCartBy=By.cssSelector(".card-body button:last-child");
	By toastMessage= By.id("toast-container");
	@FindBy (xpath="//ul/li[4]/button") WebElement cart;
    By cartBy=By.xpath("//ul/li[4]/button");
    @FindBy (xpath="(//button[@class='btn btn-custom'])[2]") WebElement orders;
    
	public List<WebElement> getProductList() throws InterruptedException  {
	//	waitForElementPresence(productsBy );
		Thread.sleep(3000);
		return products;
	}

	public WebElement getProductByName(String productName) throws InterruptedException  {
		WebElement prod = getProductList().stream().filter(f->f.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}

	public void clickaddProductToCart(String productName) throws InterruptedException  {
		getProductByName(productName).findElement(addToCartBy).click();
	}

	public Boolean isProductAddedToCart() {
		waitForElementToAppear(toastMessage );
		boolean status= productAddedToCart.isDisplayed();
		return status;
	}
	public CartPage clickCart() throws InterruptedException, IOException {
	//	waitForElementToAppear(cartBy);
		Thread.sleep(3000);
		cart.click();
		return new CartPage();
	}
	public OrdersPage clickOrders() throws IOException {
		orders.click();
		 return new OrdersPage();
	}
}
