package com.testvagrant.weather.pagefactory;

import com.testvagrant.weather.apiVerifications.APIVerification;
import com.testvagrant.weather.apitest.GetResponses;
import com.testvagrant.weather.drivers.SetupDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.testvagrant.weather.basetest.BaseTest;

import java.util.concurrent.TimeUnit;

public class HomeHook {
    WebDriver driver;
    BaseTest baseTest = new BaseTest();
    SetupDriver setupDriver = new SetupDriver();
    HomePage homePage;
    APIVerification verification=new APIVerification();
    GetResponses responses=new GetResponses();

    @Test(priority = 0)
    public void launchBrowser(){
        this.driver = setupDriver.getWebDriver();
        driver.get(baseTest.getURL());
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void sampleTestCase() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.searchforcity("Delhi");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        homePage.cityDropDown.click();
        homePage.moreDetailsLink.click();
        System.out.println(responses.returnResponse());
        verification.responseKeyValidation(responses.returnResponse(),"humidity");
        
    }


    @AfterTest
    public void quitBrowser(){
        driver.quit();
    }

}
