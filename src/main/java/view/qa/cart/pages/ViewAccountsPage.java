package view.qa.cart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import view.qa.cart.utils.ViewConstants;
import view.qa.cart.utils.ViewElementUtil;

public class ViewAccountsPage {
	private WebDriver driver;
	
	 ViewElementUtil eleUtil;
	
	private By logo = By.cssSelector("#logo a");
	private By allHeaders = By.cssSelector("div#content h2");
	private By serchfeald = By.name("search");
	private By serchButton = By.cssSelector("div#search button i");
	
	public ViewAccountsPage (WebDriver driver) {
		this.driver = driver;
		
		eleUtil = new ViewElementUtil(driver);
		}
	public String accPageTitle() {
		return eleUtil.waitForTitleContains(10, ViewConstants.ACC_PAGE_TITLE);
	}
	public boolean  logoisDisabled() {
		return eleUtil.doIsDisplayed(logo);
	}
	public int allHeadersareThere() {
		return eleUtil.getElements(allHeaders).size();
	}
	public List<String> getAccountPagelist() {
		List<WebElement> allEle= eleUtil.getElements(allHeaders);
		List<String> textofall = new ArrayList<String>();
		for(WebElement e:allEle) {
			textofall.add(e.getText());
		}
		return textofall;
		
	}
	public ViewSerchResultPage doSerch(String ProductName) {
		System.out.println("product name is :  "+ProductName);
		eleUtil.doSendKeys(serchfeald, ProductName);
		eleUtil.doClick(serchButton);
		return new ViewSerchResultPage(driver);
	}

	

}
