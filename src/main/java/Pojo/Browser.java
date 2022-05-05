package Pojo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
	public static WebDriver OpenBrowser (String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		 System.setProperty("webdriver.chrome.driver","D:\\project\\kavish\\Zerodha\\src\\main\\resources\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver(options);
	     driver.get(url);
	     driver.manage().window().maximize();
	 //   driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);  // implicit
	     return driver;
}
}
