package view.qa.cart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author admin
 *
 */
public class ViewDriverFactory {
	
	Properties prop;
	public static String highlight;
	OptionsManager optionmang;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	/**
	 * this method is use to inti browser on the bases of given browser value
	 * @param browser
	 * @return webDriver
	 */
	public WebDriver init_driver(Properties prop) {
		
		String browser =prop.getProperty("browser").trim();
		highlight=prop.getProperty("highlight").trim();
		optionmang = new OptionsManager(prop);
		System.out.println("browser name is: "+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionmang.getChromeOptions());
			tldriver.set(new ChromeDriver(optionmang.getChromeOptions()));
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionmang.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionmang.getFirefoxOptions()));
		}
		else {
			System.out.println("The given browser name is incurrect: "+browser);
		}
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());
		
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();	
	}
	/**
	 * this method is very imp this is read data form config properties file
	 * @return Properties
	 */
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		
		String env = System.getProperty("env");
		if(env==null) {
		try {
			ip = new FileInputStream("./src/test/resources/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		else {
			try {
			switch (env) {
			
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "stage":
				ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
			case "dev":
				ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;
				
				default:
					System.out.println("please pass the right env value. . . .");
					break;
			}
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}

		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		return prop;
		
	}
	/**
	 * take screenshot
	 * @return 
	 */
	public String getScreenshot() {
		File srcFile =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		//File srcFile = new File(src);
		String path =  System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return path;
	}

}
