package view.qa.cart.tests;

import org.testng.Assert;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import view.qa.cart.base.ViewBaseTest;
import view.qa.cart.utils.ViewConstants;
import io.qameta.allure.Epic;
@Story("US-101: design the login page for demo opencart app with login, title and forgot pwd link")
@Epic("Epic-100: design login page feature")

public class ViewLoginPageTest extends ViewBaseTest{
	@Description("Login page title test...")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority = 1)	
	public void getpageTitleTest() {
		String title = lp.getLoginPageTitle();
		System.out.println("login page title: "+title);
		Assert.assertEquals(title, ViewConstants.LOGIN_PAGE_TITLE);
	}
	@Description("forgot pwd link test..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 2)
	public void forgotpasswordlinkTest() {
		Assert.assertTrue(lp.isForpassisexist());
	}
	@Description("Login test with correct credentials..")
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 3)
	public void  loginTset() {
		accpage=lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accpage.accPageTitle(), ViewConstants.ACC_PAGE_TITLE);
	}

}
 