package api.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendsReportsManager implements ITestListener {

	public ExtentSparkReporter sparkReporter =null;
	public ExtentReports extent=null;
	public ExtentTest test =null;

	String repName;
//https://github.com/Arbindyadavy/RestAssuredAPITesting12.git
	public void onStart(ITestResult result) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-" +timeStamp +".html";

		sparkReporter = new ExtentSparkReporter("C:\\Users\\Neuroequilibrium\\eclipse-workspace\\RestAssuredAPITesting\\Reports\\reports.html");
		

		extent = new ExtentReports();

		extent.attachReporter(sparkReporter);
//		extent.setSystemInfo("Application ", "Pet store Users API");
//		extent.setSystemInfo("Operation System", "windows 11");
//		extent.setSystemInfo("User Name", System.getProperty("user.name"));
//		extent.setSystemInfo("Environement", "QA");
//		extent.setSystemInfo("User", "Arbind Yadav");
//		sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
//		sparkReporter.config().setReportName("Pet store Users API");
//		sparkReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest("this is ram",result.getName());
	//	test.assignCategory(result.getMethod().getGroups());
	//	test.createNode(result.getName());
		test.log(Status.PASS, "test passed");

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		//test.createNode(result.getName());
		//test.fail(result.getThrowable());
		//test.assignCategory(result.getMethod().getGroups());
		//test.log(Status.FAIL, (String) result.getThrowable().getMessage());
		test.log(Status.FAIL, "Test Faield");
		//test.log(Status.FAIL, result.getThrowable().getMessage());

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		//test.createNode(result.getName());
//		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test Skipped");
	//	test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}

	

	public void onFinish(ITestContext context) {
		
		extent.flush();	

	}
	
}
