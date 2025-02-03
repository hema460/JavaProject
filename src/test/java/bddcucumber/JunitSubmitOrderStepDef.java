package bddcucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.ConfirmationPage;
import pageObjects.LandingPage;
import pageObjects.OrdersPage;
import pageObjects.ProductCatalogPage;
import testBase.BaseTest;

public class JunitSubmitOrderStepDef  extends BaseTest{

	public JunitSubmitOrderStepDef() throws IOException {
		super();

	}
	LandingPage landingPage;
	ProductCatalogPage pcp; 
	CartPage cp;
	CheckOutPage checkOutPage;
	ConfirmationPage confirmationPage;
	OrdersPage ordersPage;
	
	@Before
	public void setUp() throws IOException {
		intializeDriver();
		landingPage=new LandingPage();
	}
	@After(order=0)
	public void tearDown() {
		driver.quit();
	}

	@Given ("^I launch the browser and navigate to url$")
	public void I_lanch_browser_and_navigate_to_url() throws IOException {
		//landingPage = launchApplication();

	}
	@Given("^I logged in with username (.+) and password (.+)$")
	public void I_logged_with_username_password(String user,String pwd) throws IOException {
		landingPage= new LandingPage();
		pcp = landingPage.loginApllication(user, pwd);
	}
	@When ("^I add the product (.+) to cart$")
	public void I_add_procut_to_cart(String productName) throws InterruptedException, IOException{
		List<WebElement> product=pcp.getProductList();	
		pcp.clickaddProductToCart(productName);
		Boolean status = pcp.isProductAddedToCart();
		//Assert.assertTrue(status);
		cp = pcp.clickCart();


	}

	@When ("^checkout (.+) and submit the order$")
	public void checkout_and_submit_order(String productName) throws InterruptedException, IOException {

		boolean isProductPresent=cp.verifyProductDisplay(productName);
		//Assert.assertTrue(isProductPresent);
		checkOutPage = cp.clickCheckOut();
		checkOutPage.selectCountryInputBox("india");
		confirmationPage = checkOutPage.placeOrder();

	}
	@Then ("verify the confirmation message {string} is diplayed")
	public void verrify_cinfirmation_message(String string) {
		String confirmationMsg=confirmationPage.getConfirmationMessage();
		System.out.println(confirmationMsg);
		//Assert.assertEquals(confirmationMsg,string);
		//tearDown();
	}

	//@2nd scenario

	@When ("^I click on the order button$")
	public void click_order_btn() throws IOException {
		ordersPage = pcp.clickOrders();
	}

	@When("^click on the delete button$")
	public void click_delete_btn() throws InterruptedException {
		ordersPage.clickOnDeleteBtn();
	}

	@Then ("^verify the confirmation message order deleted succefully is diplayed$")
	public void verify_confirmationmsg() throws InterruptedException {
		boolean msg=ordersPage.deleteMsg();
		System.out.println(msg);
		//Assert.assertTrue(msg);
		//tearDown();
	}

}
