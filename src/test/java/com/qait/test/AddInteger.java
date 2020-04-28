package com.qait.test;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddInteger {

	@Test
	public void addInteger() {
				
		String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org\">\r\n" + 
	 			"   <soapenv:Header/>\r\n" + 
	 			"   <soapenv:Body>\r\n" + 
	 			"      <tem:AddInteger>\r\n" + 
	 			"         <tem:Arg1>3</tem:Arg1>\r\n" + 
	 			"         <tem:Arg2>7</tem:Arg2>\r\n" + 
	 			"      </tem:AddInteger>\r\n" + 
	 			"   </soapenv:Body>\r\n" + 
	 			"</soapenv:Envelope>"; 
		
		
	 Response response = RestAssured.given().header("SOAPAction", "http://tempuri.org/SOAP.Demo.AddInteger")
			 .relaxedHTTPSValidation()
			 .contentType(ContentType.XML)
			 .body(body).when()
			 .relaxedHTTPSValidation()
			 .post("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls");
		System.out.println(response.asString());
		
				
		
	}
}
