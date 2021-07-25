package com.testvagrant.weather.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "search-input")
    WebElement citySearchTextBox;

    @FindBy(xpath = "//div[@class='locations-list content-module']//a[contains(text(),'Delhi, Delhi, IN')]")
    WebElement cityNameLink;

    @FindBy(xpath = "//div[@class='results-container']//div[contains(text(),'Delhi, Delhi, IN')]")
    WebElement cityDropDown;

    @FindBy(xpath = "(//span[contains(text(),'More Details')])[1]")
    WebElement moreDetailsLink;

    @FindBy(xpath = "//div[@class='display-temp']")
    WebElement tempText;

    @FindBy(xpath = "(//div[@class='detail-item spaced-content']/div[contains(text(),'Humidity')]/following-sibling::div)[1]")
    WebElement humidityText;

    public void searchforcity(String cityName){
        citySearchTextBox.sendKeys(cityName);

    }

    public String returnHumidity(){
        return humidityText.getText();
    }

    public String returnTemperature(){
        return tempText.getText();
    }


}
