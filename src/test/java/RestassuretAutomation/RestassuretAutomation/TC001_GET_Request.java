 package RestassuretAutomation.RestassuretAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC001_GET_Request {

	
	@Test
	public void getweatherDetails() {   
		
	RestAssured.baseURI="https://demoqa.com/BookStore/v1";
	
	RequestSpecification	httpsrequest=RestAssured.given();
    Response response=httpsrequest.request(Method.GET,"/Books1");
	  
    System.out.println("Status received"+response.getStatusLine());
   // System.out.println("Response"+response.prettyPrint());
   String responsebody =response.getBody().asString();
	System.out.println("Response body is"+responsebody);
	
	int statuscode=response.getStatusCode();
	Assert.assertEquals(statuscode, 200);
	System.out.println("status code is "+statuscode);
	
	String statusLine=response.getStatusLine();
	System.out.println("status line is "+statusLine);
	Assert.assertEquals(statusLine,"HTTP/1.1 200 OK" );
	
	
    // System.out.println("respone body is :"+responsebody); 
	
	
	}
	
}
