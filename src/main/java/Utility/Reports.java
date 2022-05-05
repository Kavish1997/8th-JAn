package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {
  public static ExtentReports addReports() {
	  ExtentSparkReporter htmlReport = new ExtentSparkReporter ("extentReport.html");
	  ExtentReports reports = new ExtentReports();
	  reports.attachReporter(htmlReport);
	  reports.setSystemInfo("env", "UAT");
	  reports.setSystemInfo("Testingtype", "Regression");
	  return reports;
	  
	  
  }
}
