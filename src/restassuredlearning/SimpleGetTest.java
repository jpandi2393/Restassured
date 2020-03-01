package restassuredlearning;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleGetTest {
	
@Test
 public void System_estimator()
 
 {
	//Specify Base URI
	RestAssured.baseURI= "http://upgrade-qa2.enphase.com/";
	
	//Request object
	RequestSpecification httprequest = RestAssured.given();
	
	//Response object
	Response response = httprequest.request(Method.GET, "/home");
	
    String info=response.getBody().asString();
	
	String status=response.getHeaders().toString();
	
	String type= response.header("Content-Type");
	
	System.out.println("Content-type" +type);
	
	//Assert.assertEquals(type,text/html,"aaa");
	

	
	String status_line=response.getStatusLine();
	
	System.out.println(status_line);

	System.out.println("Estimator_info is" +info);
	
	System.out.println("Response headers " +status);
	
	//To verify the status code is correct or not
	
   int status_code= response.getStatusCode();
   
   Assert.assertEquals(status_code, 200,"Correct code is returned");
   
   System.out.println(status_code);
   
   if(status_code<=200)
   {
	   System.out.println("Status_code is ok");
   }
   
   else
	   
   {
	   
	   System.out.println("Wrong");
			 

   }



 }

}
