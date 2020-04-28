package com.qait.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetByName {
	@Test
	public void getByName() {
				
		String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org\">\n" + 
				"   <soapenv:Header/>\n" + 
				"   <soapenv:Body>\n" + 
				"      <tem:GetByName>\n" + 
				"         <!--Optional:-->\n" + 
				"         <tem:name>Waterman,Danielle C</tem:name>\n" + 
				"      </tem:GetByName>\n" + 
				"   </soapenv:Body>\n" + 
				"</soapenv:Envelope>"; 
		
		
	 Response response = RestAssured.given().header("SOAPAction", "http://tempuri.org/SOAP.Demo.GetByName")
			 .relaxedHTTPSValidation()
			 .contentType(ContentType.XML)
			 .body(body).when()
			 .relaxedHTTPSValidation()
			 .post("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls");
		System.out.println(response.asString());
		
				
		
	}

}
