package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.utilities.DataProviders;
import io.restassured.response.Response;

import api.endpoints.User_End_Point;
import api.payload.*;

public class DataD_tests {

	@Test(priority = 1,dataProvider = "Data",dataProviderClass = DataProviders.class)
	public void testPostuser(String userID,String username,String Fname,String Lname,String useren,String Email,String pwd ,String ph ) {
		
	User userPayload=new User();	
	userPayload.setId(Integer.parseInt(userID));
	userPayload.setUsername(username);	
	userPayload.setFirstName(Fname);
	userPayload.setLastName(Lname);
	userPayload.setEmail(Email);
	userPayload.setPassword(pwd);
	userPayload.setPhone(ph);
	
	
	
	//Response response=User_End_Point.CreateUser(userPayload);
	//response.then().log().all();
	//Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	@Test(priority = 2,dataProvider = "UserNames",dataProviderClass = DataProviders.class )
	public void testDeleteUserByName(String username) {
   Response response=User_End_Point.DeleteUser(username);
   Assert.assertEquals(response.getStatusCode(), 404);
	

	}







}
