package com.testvagrant.weather.apitest;



import com.testvagrant.weather.apiVerifications.APIVerification;
import com.testvagrant.weather.basetest.BaseTest;
import com.testvagrant.weather.utils.Environment;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import java.io.IOException;


public class GetResponses extends BaseTest {
	Response resp;
	@Test
	public void getRequest() throws IOException {
		
		test.log(LogStatus.INFO, "getRequest started");
		String appid = Environment.getEnv().get("APIkey");
		
		resp = RestAssured.given().queryParam("q","Delhi,Delhi,IN")
		.queryParam("appid",appid)
		.when()
		.get();

		System.out.println(resp.asString());

		APIVerification.getKeyValue(resp,"cod","200");

		APIVerification.responseCodeValidation(resp,200);

		
		test.log(LogStatus.INFO, "getRequest ended");	
	}


//	public void returnIndex(String index){
//		APIVerification.responseKeyValidation(resp,index);
//	}
	public Response returnResponse(){
		System.out.println(resp.toString());
		return resp;
	}

}
