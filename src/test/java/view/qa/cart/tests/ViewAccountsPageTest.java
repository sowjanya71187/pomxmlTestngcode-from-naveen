package view.qa.cart.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import view.qa.cart.base.ViewBaseTest;
import view.qa.cart.utils.ViewConstants;
import view.qa.cart.utils.viewError;

public class ViewAccountsPageTest extends ViewBaseTest {
	SoftAssert softassert = new SoftAssert();
	
	@BeforeClass
	public void firstlogin() {
		accpage=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		 
	}
	@Test(priority=1)
	public void titleTest() {
		String title=accpage.accPageTitle();
		System.out.println("Title id : "+title);
		Assert.assertEquals(title, ViewConstants.ACC_PAGE_TITLE);
		
	}
	@Test(priority=2)
	public void logotest() {
		Assert.assertTrue(accpage.logoisDisabled());
	}
	@Test(priority=3)
	public void allArePresent() {
		assertEquals(accpage.allHeadersareThere(), ViewConstants.HEADER_PAGE_COUNT,viewError.ACC_PAGE_MISMATCHED_ERROR);
	}
	@Test(priority=4)
	public void getallLinktext() {
		List<String> allvalues=accpage.getAccountPagelist();
		System.out.println(allvalues);
		Assert.assertEquals(allvalues, ViewConstants.expectedlist());
		
	}
	@Test(priority=5)
	public void serchforProduct() {
		serchPage=accpage.doSerch("Macbook");
		System.out.println(serchPage.noofItemsPresent());
		Assert.assertTrue(serchPage.noofItemsPresent()>0);
		 
	}
	@Test(priority=6)
	public void selectTheProduct() {
		serchPage=accpage.doSerch("Macbook");
		productPage=serchPage.selectTheProductfromList("MacBook Pro");
		String actualheader=productPage.getproductHeaderTest();
		softassert.assertEquals(actualheader, "MacBook Pro");
		softassert.assertEquals(productPage.getimagesCount(), ViewConstants.PRODUCT_IMAGES_COUNT);
		softassert.assertAll();
	}
	
	
	
	
	
	
	

}
