package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZerodhaLogin {
	 @FindBy(xpath ="//input[@id='userid']") private WebElement username;
	   // driver.findelement
	   @FindBy(xpath="//input[@id=\"password\"]")private WebElement password;
	   
	   @FindBy(xpath="//button[@type=\"submit\"]")private WebElement login;
	   
	   @FindBy(xpath="//input[@id='pin']")private WebElement pin;
	   
	   @FindBy(xpath="//button[@type='submit']")private WebElement Submit;
	   
	   public ZerodhaLogin(WebDriver driver )
	   {
		   PageFactory.initElements(driver, this); // constructor , find all element declared at the start
	   }
	   public void Enterusername(String user)
	   {
		   username.sendKeys(user);
	   }
	   public void EnterPassword(String pass)
	   {
		   password.sendKeys(pass);
	   }
	   public void clickOnLogin()
	   {
		   login.click();
	   }
	   public void EnterPin(String number, WebDriver driver)
	   {
		 WebDriverWait wait =  new WebDriverWait(driver,5000);  // Explicit
		  wait.until(ExpectedConditions.visibilityOf(pin));
		   
//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
//		wait.withTimeout(Duration.ofMillis(3000));
//		wait.pollingEvery(Duration.ofMillis(50));
//		wait.ignoring(Exception.class);
//		wait.until(ExpectedConditions.visibilityOf(pin));
		
		      pin.sendKeys(number);
	   }
	   
	   public void ClickOnSubmit() {
		   Submit.click();
	   }
}
