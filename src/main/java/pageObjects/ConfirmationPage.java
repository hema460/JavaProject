package pageObjects;

import java.io.IOException;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseTest;




public class ConfirmationPage  extends BaseTest{

	
	public ConfirmationPage() throws IOException {
		super();
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath=" //h1[text()=' Thankyou for the order. ']") WebElement confirmationMessage;

	public String getConfirmationMessage() {
		String message=confirmationMessage.getText();
		return message;
	}
}
