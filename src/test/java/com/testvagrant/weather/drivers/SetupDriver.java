package com.testvagrant.weather.drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SetupDriver {
    public WebDriver getWebDriver() {

            WebDriver driver;
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/chromedriver");
            driver = new ChromeDriver();
            return driver;
        }
    }

