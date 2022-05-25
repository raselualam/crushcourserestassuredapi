package upskill.dummy.restAssuredActions;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class PostNewEmployeeRecords {
	
	@Test
	public void postNewEmployeeDetails(){
		
		File payload = new File("C:/Users/rasel/workspace/CrushCourseRestAssuredAPI/src/test/resource/Payload/NewEmployee.json"); //Bringing json request body
	
		RequestSpecification request = RestAssured.given();											//Initialize request
		request.header("Content-Type","application/json");											//Set header				
		request.body(payload);																		//Set body
		
		Response resp = request.post("http://dummy.restapiexample.com/api/v1/create");				//Posting API request
		
		int statusCode= resp.getStatusCode();														//Get the Status Code
		Assert.assertEquals(200, statusCode);														//Validate the status code
		System.out.println("Status Code ::: " + statusCode);										//Printing Status Code
		
		String responseBody = resp.asString();
		System.out.println("Response Body ::: " + responseBody);									//Printing Response body
	}
	
	//test git
	//new branch
}



