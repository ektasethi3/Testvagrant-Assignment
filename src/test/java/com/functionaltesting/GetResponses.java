package com.functionaltesting;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Connection.Request;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.basetest.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import weather.utils.Environment;

import java.io.IOException;
import java.util.*;

public class GetResponses extends BaseTest{

	@Test
	public void getRequest() throws IOException {
		
		test.log(LogStatus.INFO, "getRequest started");
		String appid = Environment.getEnv().get("APIkey");
		
		Response resp = RestAssured.given().queryParam("q","delhi")
		.queryParam("appid",appid)
		.when()
		.get();

		System.out.println(resp.asString());

		APIVerification.getKeyValue(resp,"cod","200");

		APIVerification.responseCodeValidation(resp,200);
		APIVerification.responseTimeVerification(resp);
		
		test.log(LogStatus.INFO, "getRequest ended");	
	}


}
