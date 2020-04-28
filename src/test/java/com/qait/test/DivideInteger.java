package com.qait.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DivideInteger {
	@Test
	public void divideInteger() {
	  
	   String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org\">\n" + 
	   		"   <soapenv:Header/>\n" + 
	   		"   <soapenv:Body>\n" + 
	   		"      <tem:DivideInteger>\n" + 
	   		"         <!--Optional:-->\n" + 
	   		"         <tem:Arg1>14</tem:Arg1>\n" + 
	   		"         <!--Optional:-->\n" + 
	   		"         <tem:Arg2>2</tem:Arg2>\n" + 
	   		"      </tem:DivideInteger>\n" + 
	   		"   </soapenv:Body>\n" + 
	   		"</soapenv:Envelope>";
		
		
	 Response response = RestAssured.given().header("SOAPAction", "http://tempuri.org/SOAP.Demo.DivideInteger")
			 .relaxedHTTPSValidation()
			 .contentType(ContentType.XML)
			 .body(body).when()
			 .relaxedHTTPSValidation()
			 .post("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls");
		System.out.println(response.asString());
	
				
				
		
	}

}
