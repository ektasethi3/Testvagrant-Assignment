package weather.configuration;

import org.openqa.selenium.WebDriver;

public class WebDriverConfiguration {
    ThreadLocal<WebDriver> WebDrivers = new ThreadLocal<>();
    public WebDriver webdriver(){
        return WebDrivers.get();

    }
    public void setWebDrivers(WebDriver driver){
        WebDrivers.set(driver);
    }

}
