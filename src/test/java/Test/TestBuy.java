package Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.Buyshare;
import POM.ZerodhaLogin;
import Pojo.Browser;
import Utility.Excel;
import Utility.Reports;

public class TestBuy {
	
		WebDriver driver;
		ExtentReports reports ;
		ExtentTest test;
		
		@BeforeClass
		public void setReports() {
			reports=Reports.addReports();
		}
		
		@BeforeMethod
		public void lunchbrowser() throws IOException {
		driver=	Browser.OpenBrowser("https://kite.zerodha.com");
			 ZerodhaLogin zerodhalogin =new ZerodhaLogin(driver);
			  String user = Excel.getTestData(0, 1, "data");
			  zerodhalogin.Enterusername(user);
			  String pass = Excel.getTestData(1, 1,"data");
			  zerodhalogin.EnterPassword(pass);
			  zerodhalogin.clickOnLogin();
			  String pin = Excel.getTestData(2, 1, "data");
			  zerodhalogin.EnterPin(pin, driver);
			  zerodhalogin.ClickOnSubmit();
		}
		@Test
		public void buyshare() throws InterruptedException  {
			Buyshare buys = new Buyshare(driver);
			buys.selectstockfromlist(driver, "TATACOFFEE");
			buys.clickonBuy();
		}	
		
		
		@Test 
		public void Search()
		{
			Buyshare Riya = new Buyshare(driver);
			Riya.Searchpath(driver, "TARC");
			
		}
		
		@AfterMethod
		  public void catureResult (ITestResult result)
		  {
			  if(result.getStatus()==ITestResult.FAILURE) {
				  test.log(Status.FAIL, result.getName());
			  }else if (result.getStatus() ==ITestResult.SUCCESS ) {
				  test.log(Status.PASS, result.getName());
			  }
			  else {
				  test.log(Status.SKIP, result.getName());
			  }
			  
		  }
		    @AfterClass
		    public void flushResults() {
		    	reports.flush();
		    }
		  
	}

