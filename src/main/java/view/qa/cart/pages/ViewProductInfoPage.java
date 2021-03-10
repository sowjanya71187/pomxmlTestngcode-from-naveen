package view.qa.cart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import view.qa.cart.utils.ViewElementUtil;

public class ViewProductInfoPage {
	ViewElementUtil eleUtil;
	private By productHeader = By.cssSelector("div#content h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productmetadata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPricedata = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By productQunity = By.id("input-quantity");
	private By addtocort = By.id("button-cart");
	private By successMessage = By.cssSelector(".alert.alert-success.alert-dismissible");
	
	public ViewProductInfoPage(WebDriver driver) {
		eleUtil = new ViewElementUtil(driver);
	}
	public String getproductHeaderTest() {
		return eleUtil.doGetElementText(productHeader);
	}
	public int getimagesCount() {
		return eleUtil.getElements(productImages).size();
	}
	public Map<String, String> getProductInformation() {
		Map<String , String> productInforMap = new HashMap<String,String>();
		productInforMap.put("name", getproductHeaderTest());
		List<WebElement>metadata=eleUtil.getElements(productmetadata);
		System.out.println("Total product meta data:  "+metadata.size());
		for(WebElement e:metadata) {
			 String meta[]=e.getText().split(":");
			 String metakey =meta[0].trim();
			 String metavalue = meta[1].trim();
			 productInforMap.put(metakey, metavalue); 
		}
		//price
		List<WebElement> priceList = eleUtil.getElements(productPricedata);
		productInforMap.put("price", priceList.get(0).getText().trim());
		productInforMap.put("exTextPrice", priceList.get(1).getText().split(":")[1].trim());
		return productInforMap;
		
	}
	public void selectQuantity(String qntity) {
		eleUtil.doSendKeys(productQunity, "1");
		
	}
	public void addToCart() {
		eleUtil.doClick(addtocort);
	}
	public String getSuccessMessage() {
		return eleUtil.doGetElementText(successMessage);
	}
	
	
    
}
