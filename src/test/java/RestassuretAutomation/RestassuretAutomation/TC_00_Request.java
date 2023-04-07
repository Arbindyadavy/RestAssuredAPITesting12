package RestassuretAutomation.RestassuretAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_00_Request {

	@Test
	public void Request_Method() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.request(Method.GET, "");
		String responseBody = response.getBody().asString();

		System.out.println("responseBody is :" + responseBody);
		int statuscode = response.statusCode();
		System.out.println("statuscode is :" + statuscode);
		Assert.assertEquals(statuscode, 200);

		String statusLine = response.statusLine();

		System.out.println("statusLine is :" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

		String ContentType = response.header("Content-Type");
		System.out.println("ContentType is :" + ContentType);
		Assert.assertEquals(ContentType, "application/json; charset=utf-8");
	
	
		String ContentEncoding = response.header("Content-Encoding");
		System.out.println("ContentEncoding is :" + ContentEncoding);
		Assert.assertEquals(ContentEncoding, null);
	
	
		String date = response.header("Date");
		System.out.println("date is :" + date);
		Assert.assertEquals(date, date);
		Headers allheader=response.headers();
	for(Header Heaheader:allheader) {
		
		
		System.out.println(Heaheader.getName()+  "  "  +Heaheader.getValue());
		
		
	}
	}
	
}//Content-Encoding
