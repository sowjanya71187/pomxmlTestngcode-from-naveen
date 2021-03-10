package view.qa.cart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

import view.qa.cart.utils.ViewConstants;
import view.qa.cart.utils.ViewElementUtil;

public class ViewLoginpage {
    private WebDriver driver;
    ViewElementUtil eleUtil;
	//page object by locattors of loginpage
	private By email = By.id("input-email");
	private By password = By.id("input-password");
	private By login = By.xpath("//input[@value='Login']");
	private By foegot = By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']");
	private By registration = By.linkText("Register");
	//constructor:
	public ViewLoginpage(WebDriver driver) {
	    this.driver=driver;
		eleUtil = new ViewElementUtil(driver);
	}
	//page actions
	@Step("getting login page title")
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(10, ViewConstants.LOGIN_PAGE_TITLE);
	}
	@Step("Cheking forgot ped link")
	public boolean isForpassisexist() {
		return eleUtil.doIsDisplayed(foegot);
	}
	@Step("login with username:{0} and password:{1}")
	public ViewAccountsPage doLogin(String un,String pwd) {
		System.out.println("login with:  "+un+":"+pwd);
		eleUtil.doSendKeys(email, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(login);
		return new ViewAccountsPage(driver);
	}
	@Step("Navigate to registor page")
	public ViewRegistorPage navigateToRegistorPage() {
		eleUtil.doClick(registration);
		return new ViewRegistorPage(driver);
	}
	

}
