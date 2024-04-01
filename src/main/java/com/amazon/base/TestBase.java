package com.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.amazon.util.TestUtil;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	//public static Actions action;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream(
					"C:\\Users\\RAJESH 1\\eclipse-workspace\\AmazonProject\\src\\main\\java\\com\\amazon\\config\\config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initilization() {

		String browserName = prop.getProperty("browser");
		if (browserName.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.contains("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.contains("Edge")){
			System.setProperty("webdriver.edge.driver", "C:\\driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}else if(browserName.contains("Safari")){
			System.setProperty("webdriver.safari.driver","C:\\safaridriver.exe");
			driver = new SafariDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	}

}
