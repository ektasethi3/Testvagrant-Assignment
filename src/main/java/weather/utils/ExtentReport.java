package weather.utils;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReport implements ITestListener {

	protected static ExtentReports report;
	protected static ExtentTest test;

	protected static String resultpath = getResultPath();

	public static void deleteDirectory(File directory) {
		if(directory.exists()) {
			File[] files = directory.listFiles();
			if(null!=files) {
				for(int i =0;i<files.length;i++) {
					System.out.println(files[i].getName());
					if(files[i].isDirectory()) {
						deleteDirectory(files[i]);
					}
					else {
						files[i].delete();
					}
				}
			}
		}
	}

	private static String getResultPath() {
		resultpath = "test";
		if(!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	String Reportlocation = "test-output/Reports/"+resultpath+"/";

	public void onTestStart(ITestResult result) {
		test = report.startTest(result.getMethod().getMethodName());
		test.log(LogStatus.INFO, result.getMethod().getMethodName());
		System.out.println(result.getTestClass().getTestName());
		System.out.println(result.getMethod().getMethodName());
	}

	public void onTestPass(ITestResult result) {
		test.log(LogStatus.PASS, "Test Case Pass");
	}
	public void onTestFail(ITestResult result) {
		test.log(LogStatus.FAIL, "Test Case Fail");
	}
	public void onTestSkip(ITestResult result) {
		test.log(LogStatus.SKIP,"Test Case Skip");
	}
	public void onStart(ITestContext context) {
		System.out.println(Reportlocation + "  ReportLocation");
		report = new ExtentReports(Reportlocation + "ExtentReport.html");
		test = report.startTest("");

	}
	public void onFinish(ITestContext context) {
		report.endTest(test);
		report.flush();

	}
}
