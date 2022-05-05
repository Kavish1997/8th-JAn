package Test;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utility.ScreenShot;

public class ListenerTest extends Demo implements ITestListener  {
    
	public void onTestStart(ITestResult result) {
		System.out.println("Started"+result.getName());
}
	public void onTestSuccess(ITestResult result) {
		System.out.println("My test is Success"+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		try {
			
			ScreenShot.takeScreenshot(Driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	public void onTestSkipped(ITestResult result) {
	  System.out.println("My test is Skipped"+result.getName());	
	}
}