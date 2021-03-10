package view.qa.cart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import view.qa.cart.factory.ViewDriverFactory;
import view.qa.cart.pages.ViewAccountsPage;
import view.qa.cart.pages.ViewLoginpage;
import view.qa.cart.pages.ViewProductInfoPage;
import view.qa.cart.pages.ViewRegistorPage;
import view.qa.cart.pages.ViewSerchResultPage;

public class ViewBaseTest {
	private WebDriver driver;
	ViewDriverFactory DF; 
	public ViewLoginpage lp;
	public Properties prop;
	public ViewAccountsPage accpage;
	public ViewSerchResultPage serchPage;
	public ViewProductInfoPage productPage;
	public ViewRegistorPage registorPage;
	
	@BeforeTest
	public void setUp() {
		DF = new ViewDriverFactory();
		prop=DF.init_prop();
		driver = DF.init_driver(prop);
		lp = new ViewLoginpage(driver);
		
	}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
