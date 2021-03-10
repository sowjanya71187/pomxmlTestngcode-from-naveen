package view.qa.cart.tests;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import view.qa.cart.base.ViewBaseTest;

public class ViewProductPageTest extends ViewBaseTest {
	SoftAssert softassert = new SoftAssert();
	
	@BeforeClass
	public void AccSetUp() {
		accpage=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test
	public void productinfoTest() {
		serchPage=accpage.doSerch("Macbook");
		productPage=serchPage.selectTheProductfromList("MacBook Pro");
		Map<String, String> getproducinfomap=productPage.getProductInformation();
		softassert.assertTrue(getproducinfomap.get("name").equals("MacBook Pro"));
		softassert.assertTrue(getproducinfomap.get("Brand").equals("Apple"));
		softassert.assertTrue(getproducinfomap.get("price").equals("$2,000.00"));
		
		
	}
	

}
