package RestassuretAutomation.RestassuretAutomation;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_Post_Request {

	@Test
	public void Post_Request_Medhod() {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();

		requestParams.put("FastName", "JsonXYZ");
		requestParams.put("LastName", "XYZJson");
		requestParams.put("UserName", "Jsonxyz");
		requestParams.put("Password", "JsonXYZxyz");
		requestParams.put("Email", "JsonXYZ@gmail.com");

		httpRequest.header("Content-Type", "application/Json");
		httpRequest.body(requestParams.toJSONString());

		Response response = httpRequest.request(Method.POST, "");
		String responseBody = response.getBody().asString();

		System.out.println("responseBody is :" + responseBody);

		int statuscode = response.statusCode();
		System.out.println("statuscode is :" + statuscode);
		Assert.assertEquals(statuscode, 504);

		String statusLine = response.statusLine();

		System.out.println("statusLine is :" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 504 Gateway Time-out");

	

	}

}
