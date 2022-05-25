package upskill.dummy.restAssuredActions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllEmployeeRecords {
	
	@Test
	public void GetAllEmployeeDetails(){
		Response resp = RestAssured.get("http://dummy.restapiexample.com/api/v1/employees");    //Getting API HTTP response using RestAssured
		int statusCode = resp.getStatusCode();													//Getting Status Code & Validating
		Assert.assertEquals(200, statusCode);
		String responseBody = resp.asString();													//Getting the response body
		System.out.println("Status Code ::: " + statusCode);									//Printing Status Code
		System.out.println("Response Body ::: " + responseBody);								//Printing Response body
	}
	
	@Test
	public void GetAllEmployeeDetails2() {
	    given().
	    when().
	        get("http://dummy.restapiexample.com/api/v1/employees").
	    then().
	        assertThat().
	        statusCode(200);
	}
	
	//practice git
}


