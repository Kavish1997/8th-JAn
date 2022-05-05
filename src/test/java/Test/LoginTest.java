package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import POM.ZerodhaLogin;
import Pojo.Browser;
import Utility.Excel;
@Listeners(ListenerTest.class)
public class LoginTest extends Demo {
	
	 
	  @BeforeMethod
	  public void callBrowser() {
		Driver =  Browser.OpenBrowser("https://kite.zerodha.com/");
	  }
	  @Test
	  public void LoginWithValidCredentials() throws IOException {
		  ZerodhaLogin zerodhalogin =new ZerodhaLogin(Driver);
		  String user = Excel.getTestData(0, 1, "data");
		  zerodhalogin.Enterusername(user);
		  String pass = Excel.getTestData(1, 1,"data");
		  zerodhalogin.EnterPassword(pass);
		  zerodhalogin.clickOnLogin();
		  String pin = Excel.getTestData(2, 1, "data");
		  zerodhalogin.EnterPin(pin, Driver);
		  zerodhalogin.ClickOnSubmit();
		  Assert.assertTrue(false);
	  }
	
	  
}

