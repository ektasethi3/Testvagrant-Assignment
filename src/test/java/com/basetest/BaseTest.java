package com.basetest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import io.restassured.RestAssured;


import weather.utils.Environment;
import weather.utils.ExtentReport;

@Listeners(ExtentReport.class)
public class BaseTest extends ExtentReport{

	@BeforeMethod
	public void baseTest() {
		String completeURI= Environment.getEnv().get("ServerUrl");
		RestAssured.baseURI=completeURI;
	}

}
