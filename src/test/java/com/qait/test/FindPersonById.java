package com.qait.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class FindPersonById {
	
	@Test
	public void findPersonById() {
	  
	   String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org\">\n" + 
	   		"   <soapenv:Header/>\n" + 
	   		"   <soapenv:Body>\n" + 
	   		"      <tem:FindPerson>\n" + 
	   		"         <!--Optional:-->\n" + 
	   		"         <tem:id>2</tem:id>\n" + 
	   		"      </tem:FindPerson>\n" + 
	   		"   </soapenv:Body>\n" + 
	   		"</soapenv:Envelope>";
		
		
	 Response response = RestAssured.given().header("SOAPAction", "http://tempuri.org/SOAP.Demo.FindPerson")
			 .relaxedHTTPSValidation()
			 .contentType(ContentType.XML)
			 .body(body).when()
			 .relaxedHTTPSValidation()
			 .post("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls");
		System.out.println(response.asString());
			
				
		
	}


}
