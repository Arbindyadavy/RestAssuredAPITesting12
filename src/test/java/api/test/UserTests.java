package api.test;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.User_End_Point;
import api.payload.User;
import api.utilities.ExtendsReportsManager;

import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests extends ExtendsReportsManager{

	public	Faker faker;
	public	User userPayload;
    public  Logger logger;
	@BeforeClass
	public void setupData() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());

		userPayload.setUsername(faker.name().username());

		userPayload.setFirstName(faker.name().firstName());

		userPayload.setLastName(faker.name().lastName());

		userPayload.setEmail(faker.internet().safeEmailAddress());

		userPayload.setPassword(faker.internet().password());

		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}

	@Test(priority = 1)
	public void testPostuser() {
		Response response = User_End_Point.CreateUser(userPayload);

		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2)
	public void testGetUserByName() {

		Response response = User_End_Point.readUser(this.userPayload.getUsername());
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 405);

	}

	@Test(priority = 3)
	public void testUpdateUserByName() {

		Response response = User_End_Point.CreateUser(userPayload);

		response.then().log().body();

		Assert.assertEquals(response.getStatusCode(), 200);
// chackeing data after update

		Response responseupdete = User_End_Point.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseupdete.statusCode(), 405);
	}

	@Test(priority = 4)
	public void testDeleteUserByName() {

		Response resspone = User_End_Point.DeleteUser(this.userPayload.getUsername());

		resspone.then().log().body();
		Assert.assertEquals(resspone.getStatusCode(), 200);

	}
}
