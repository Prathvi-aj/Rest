package com.automation.Rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest 
{
	
	 @Test(priority=1)
	    public void getListOfAvailableEmployee() {
		 
		 System.out.println("Test case Name: Fetch the list of available employee’s details .");
		    
	        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
	        RequestSpecification request = RestAssured.given();
  
	         Response response = request.get("");
	         System.out.println("Response Body: ");
	         System.out.println(response.getBody().asString());
	         System.out.println("Response Code: "+response.getStatusCode());
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }
	 
	 @Test(priority=2)
	    public void getEmployeeByID() {
		 	
		 	System.out.println("Test case Name: Search the employee using the Id but that employee detail is not available, validate the response.");
		    
	        RestAssured.baseURI = "https://reqres.in/api/users/23";
	        RequestSpecification request = RestAssured.given();
	        
	         Response response = request.get("");
	         System.out.println("Response Body: ");
	         System.out.println(response.getBody().asString());
	         
	         System.out.println("Response Code: "+response.getStatusCode());
		        
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }
	 @Test(priority=3)
	    public void CreateEmployee() throws IOException {
		 System.out.println("Test case Name: Create a one employee details and check whether it employee is created");
		    
		 byte[] b = Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/user.json"));
		 String bdy = new String(b);

		 
	        RestAssured.baseURI = "https://reqres.in/api/users";
	        
	        RequestSpecification request = RestAssured.given().body(bdy);
	        
	         Response response = request.post("/posts");
	         System.out.println("Response Body: ");
	         System.out.println(response.getBody().asString());
	         
	         System.out.println("Response Code: "+response.getStatusCode());
		        
	        Assert.assertEquals(response.getStatusCode(), 201);
	        
	        JsonPath jsonPathEvaluator = response.jsonPath();

	    	String id = jsonPathEvaluator.get("id");
	    	System.out.println("User Created, ID:"+id);
	    	
	        
	        
	    }
	 @Test(priority=4)
	    public void updateJobValue() throws IOException {
		 System.out.println("Test case Name: Update the Job value for the created employee using employee Id and check the update happen for the employee.");
		    
		 byte[] b = Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/user.json"));
		 String bdy = new String(b);

		 
	        RestAssured.baseURI = "https://reqres.in/api/users/2";
	        
	        RequestSpecification request = RestAssured.given().body(bdy);
	        
	         Response response = request.put("/post/2");
	         System.out.println("Response Body: ");
	         System.out.println(response.getBody().asString());
	         
	         System.out.println("Response Code: "+response.getStatusCode());
		        
	        Assert.assertEquals(response.getStatusCode(), 200);
	        
	        System.out.println("User Update");
	    }
	 
	 
	 @Test(priority=5)
	    public void deleteEmployee(){
		 System.out.println("Test case Name: Delete the employee using employee Id and check the employee details are deleted successfully.");
		    
		 
	        RestAssured.baseURI = "https://reqres.in/api/users/2";
	        
	        RequestSpecification request = RestAssured.given();
	        
	         Response response = request.delete();
	         System.out.println("Response Body: ");
	         System.out.println(response.getBody().asString());
	         
	         System.out.println("Response Code: "+response.getStatusCode());
		        
	        Assert.assertEquals(response.getStatusCode(), 204);
	        
	        System.out.println("User Deleted");	    }
}
