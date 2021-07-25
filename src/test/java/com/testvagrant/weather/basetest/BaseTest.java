package com.testvagrant.weather.basetest;

import com.testvagrant.weather.utils.Environment;
import com.testvagrant.weather.utils.ExtentReport;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import io.restassured.RestAssured;




@Listeners(ExtentReport.class)
public class BaseTest extends ExtentReport{

	@BeforeMethod
	public void baseTest() {
		String completeURI= Environment.getEnv().get("ServerUrl");
		RestAssured.baseURI=completeURI;
	}

	public String getURL(){
		String url = Environment.getEnv().get("url");
		return url;
	}

}
