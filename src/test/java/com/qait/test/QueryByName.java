package com.qait.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class QueryByName {

	@Test
	public void queryByName() {
				
		String body = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org\">\n" + 
				"   <soapenv:Header/>\n" + 
				"   <soapenv:Body>\n" + 
				"      <tem:QueryByName>\n" + 
				"         <!--Optional:-->\n" + 
				"         <tem:name>Diavolo,Ralph A.</tem:name>\n" + 
				"      </tem:QueryByName>\n" + 
				"   </soapenv:Body>\n" + 
				"</soapenv:Envelope>"; 
		
		
	 Response response = RestAssured.given().header("SOAPAction", "http://tempuri.org/SOAP.Demo.QueryByName")
			 .relaxedHTTPSValidation()
			 .contentType(ContentType.XML)
			 .body(body).when()
			 .relaxedHTTPSValidation()
			 .post("https://www.crcind.com:443/csp/samples/SOAP.Demo.cls");
		System.out.println(response.asString());
		
				
		
	}
}
