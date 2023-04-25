package Calendor;

import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender1 {

	
	
 	static WebDriver driver;
	
	static int targetDay=0, targetMoth=0,targetYear;
	static int  currentDay=0,currentMoth=0,currentYear;
	static int jumpToMoth=0;
	static boolean increment=true;
	
	
	public static void  main(String[] args ) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Neuroequilibrium\\eclipse-workspace\\RestAssuredAPITesting\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();	
		
		
	String  dateToSet = " 25/ 04/ 2023 ";
	getCurrentdateMonthAndYear();
	System.out.println(currentDay+" "+currentMoth+" "+currentYear);
	
//	getTargetDateMonthAndYear(dateToSet);	
//	System.out.println(targetDay+" "+targetMoth+ "  "+targetYear);	
	
	
	
	}
	public static void getTargetDateMonthAndYear(String dateToSet) {
		
	int firstIndex=dateToSet.indexOf("/");
	int lastIndext=dateToSet.indexOf("/")	;
	String day =dateToSet.substring(0+firstIndex);
	String month=dateToSet.substring(firstIndex,lastIndext);
	String year=dateToSet.substring(lastIndext,dateToSet.length());
	targetDay=Integer.parseInt(day);
	targetMoth=Integer.parseInt(month);
	targetYear=Integer.parseInt(year);

	
	
	
	
	}
public static void getCurrentdateMonthAndYear(){
Calendar cal=Calendar.getInstance();
currentDay=cal.get(Calendar.DAY_OF_MONTH);


currentMoth=cal.get(Calendar.MONTH)+1;
currentYear=cal.get(Calendar.YEAR);



}
	
	
}
