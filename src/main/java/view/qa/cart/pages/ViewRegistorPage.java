package view.qa.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import view.qa.cart.utils.ViewConstants;
import view.qa.cart.utils.ViewElementUtil;

public class ViewRegistorPage {
	
	private ViewElementUtil eleUtil;
	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By phon = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confpass = By.id("input-confirm"); 
	
	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	private By privacypolicy = By.name("agree");
	private By continueButton = By.xpath("//input[@value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");
	private By logout = By.linkText("Logout");
	private By registeragain =By.linkText("Register");
	
	public ViewRegistorPage(WebDriver driver) {
		
		eleUtil = new ViewElementUtil(driver); 
		
	}
	public Boolean accountRegistration(String firstName,String lastName,String email,String telephon,String password,String subscribe) {
		eleUtil.doSendKeys(this.firstname, firstName);
		eleUtil.doSendKeys(this.lastname, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.phon, telephon);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confpass, password);
		if(subscribe.equals("yes")) {
			eleUtil.doClick(subscribeYes);
		}
		else {
			eleUtil.doClick(subscribeNo);
		}
		eleUtil.doClick(privacypolicy);
		eleUtil.doClick(continueButton);
		
		eleUtil.waitForPresenceOfElement(sucessMessg, 5);
		String meag=eleUtil.doGetElementText(sucessMessg);
		System.out.println("account creation: "+meag);
		if(meag.equals(ViewConstants.ACCOUNT_CREATION_SUCCESS_MESSG)) {
			eleUtil.doClick(logout);
			eleUtil.doClick(registeragain);
			return true;
		}
		else
		{
			return false;
		}
	}
	

}
