package com.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {
    WebDriver driver;

    public Pages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(className = "search-input")
    WebElement citySearchTextBox;


    @FindBy(xpath = "//div[contains(text(),'Delhi, Delhi, IN')]")
    WebElement cityDropDown;

    @FindBy(xpath = "(//span[contains(text(),'More Details')])[1]")
    WebElement moreDetailsLink;





}
