package upskill.dummy.restAssuredSteps;

import java.io.File;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class EmployeeDetailsApiTestSteps {
	
	@Given("^Create new employee record in database$")
	public void create_new_employee_record_in_database() throws Throwable {
		
		File payload = new File("C:/Users/rasel/workspace/CrushCourseRestAssuredAPI/src/test/resource/Payload/NewEmployee.json"); //Bringing json request body
		
		RequestSpecification request = RestAssured.given();											//Initialize request
		request.header("Content-Type","application/json");											//Set header				
		request.body(payload);																		//Set body
		
		Response resp = request.post("https://dummy.restapiexample.com/api/v1/create");				//Posting API request
		
		int statusCode= resp.getStatusCode();														//Get the Status Code
//		Assert.assertEquals(200, statusCode);														//Validate the status code
		System.out.println("Status Code ::: " + statusCode);										//Printing Status Code
		
		String responseBody = resp.asString();
		System.out.println("Response Body ::: " + responseBody);									//Printing Response body
	}

	@When("^Get all employee data$")
	public void get_all_employee_data() throws Throwable {
		Response resp = RestAssured.get("https://dummy.restapiexample.com/api/v1/employee");    //Getting API HTTP response using RestAssured
		int statusCode = resp.getStatusCode();													//Getting Status Code & Validating
//		Assert.assertEquals(200, statusCode);
		String responseBody = resp.asString();													//Getting the response body
		System.out.println("Status Code ::: " + statusCode);									//Printing Status Code
		System.out.println("Response Body ::: " + responseBody);	
	}

	@Then("^Get a single employee data by id$")
	public void get_a_single_employee_data_by_id() throws Throwable {
		Response resp = RestAssured.get("https://dummy.restapiexample.com/api/v1/employee/1");    //Getting API HTTP response using RestAssured
		int statusCode = resp.getStatusCode();													//Getting Status Code & Validating
//		Assert.assertEquals(200, statusCode);
		String responseBody = resp.asString();													//Getting the response body
		System.out.println("Status Code ::: " + statusCode);									//Printing Status Code
		System.out.println("Response Body ::: " + responseBody);

	}
}
