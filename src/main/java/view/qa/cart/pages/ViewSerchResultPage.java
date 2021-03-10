package view.qa.cart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import view.qa.cart.utils.ViewElementUtil;

public class ViewSerchResultPage {
	private WebDriver driver;
	ViewElementUtil eleUtil;
	private By resultOfnoOfitems = By.cssSelector("div.product-layout div.product-thumb");
	private By EachitemName = By.cssSelector("div.product-thumb h4 a");
	
	
	
	public ViewSerchResultPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ViewElementUtil(driver);
	}
	
	public int noofItemsPresent() {
		return eleUtil.getElements(resultOfnoOfitems).size();
	}
	public ViewProductInfoPage selectTheProductfromList(String ProductName) {
		List<WebElement> itemnames=eleUtil.getElements(EachitemName);
		System. out.println("Total no of items displayed for "+ProductName+" : "+itemnames.size() );
		for(WebElement e:itemnames) {
			if(e.getText().equals(ProductName)) {
				e.click();
				break;
			}
		}
		return new ViewProductInfoPage(driver);
		
	} 

}
 