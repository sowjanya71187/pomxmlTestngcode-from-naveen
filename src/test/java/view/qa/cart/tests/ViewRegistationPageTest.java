package view.qa.cart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import view.qa.cart.base.ViewBaseTest;
import view.qa.cart.utils.ViewConstants;
import view.qa.cart.utils.ViewExcelUtil;
import view.qa.cart.utils.viewError;

public class ViewRegistationPageTest extends ViewBaseTest{
	
	
	@BeforeClass
	public void setUpRegistor() {
		registorPage=lp.navigateToRegistorPage();
		
	}
	@DataProvider
	public Object[][] getregistordatamethod() {
		Object data[][]=ViewExcelUtil.getTestData(ViewConstants.REGISTOR_SHEET_NAME);
		return data;
		}
	public String getRandomNumber() {
		Random randomGenarator = new Random();
		String email = "sowji"+randomGenarator.nextInt(1000)+"@gmail.com";
		return email;
		
	}
	
	@Test(dataProvider="getregistordatamethod")
	public void userRegisterTest(String firstName,String lastName,String telephon,String password,String subscribe) {
		Assert.assertTrue(registorPage.accountRegistration(firstName, lastName, getRandomNumber(), 
				telephon, password, subscribe),viewError.REGISTER_FAILED_MESSG);
		
	}
	
	

}
  