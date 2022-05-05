package Test;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.Signup;
import Pojo.Browser;
import Utility.Reports;

public class LoginSignUp {
	WebDriver driver ;

	
	 
	  @BeforeMethod
	  public void LaunchBrowser() {
		driver =  Browser.OpenBrowser("https://kite.zerodha.com/");
	  }
	  
	  @Test
	  public void LoginToSignUpPage() {
		  Signup signup = new Signup(driver);
		  signup.clickonSignup();
			ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(1));
			String actualtitle = signup.getpagetitle(driver);
			String expectedtitle = "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
			Assert.assertEquals(actualtitle, expectedtitle);//hard assert will stop execution at  this point
			Assert.assertTrue(signup.logoisdisplayed());           
			//pass // static
			signup.entremobilenumber("8888702438"); 
	  }
	  
	  @Test
	  public void Softsignup() {
		 Signup signUp=  new Signup(driver);
		 signUp.clickonSignup();
			ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(1));
			String actualtitle = signUp.getpagetitle(driver);
			String expectedtitle = "Signup and open a Zerodha trading and demat account online and start investing – Zerodha";
			SoftAssert softassert = new SoftAssert();
			softassert.assertEquals(actualtitle, expectedtitle );
			softassert.assertFalse(signUp.logoisdisplayed()); // non static
			signUp.entremobilenumber("8888702438");
			softassert.assertAll(); // shows all the captured failure
	  }
	 
	  
}
