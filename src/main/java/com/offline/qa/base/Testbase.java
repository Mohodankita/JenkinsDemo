package com.offline.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.offline.qa.util.TestUtil;

public class Testbase {
	public static WebDriver driver;
	public static Properties prop;

	public Testbase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\Testi\\project\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver79.exe");
			driver = new ChromeDriver();
		} else {
			String ff = prop.getProperty("firefox");
			System.out.println("firefox");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
