package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import testBase.BaseTest;


public class LandingPage  extends BaseTest{
	  
	 
	
	
	
	public LandingPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}


	@FindBy (id="userEmail") WebElement  userEmail;
	@FindBy (id="userPassword") WebElement passWord;
	@FindBy (name="login") WebElement login;
	
	
	public ProductCatalogPage loginApllication(String usern,String pwd) throws IOException {
		userEmail.sendKeys(usern);
		passWord.sendKeys(pwd);
		login.click();
		return new ProductCatalogPage();
	}


	
	

}
