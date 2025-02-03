package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseTest;

public class OrdersPage extends BaseTest{

	public OrdersPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	
	@FindBy (xpath="//td/button[text()='Delete']") List<WebElement> delete;
	@FindBy (id="toast-container") WebElement verifyDeleteMsg;
	public void clickOnDeleteBtn() throws InterruptedException {
		Thread.sleep(3000);
		WebElement del=delete.stream().filter(f->f.getText().equals("Delete")).findFirst().orElse(null);
		del.click();
	}
	
	public boolean deleteMsg() throws InterruptedException {
		Thread.sleep(3000);
		boolean status=false;
		if(delete.size()>0) {
			status=false;
		}
		else
		status=	true;

		return status;
	}
}
