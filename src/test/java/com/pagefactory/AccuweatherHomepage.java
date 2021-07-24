package com.PageFactory;

import com.pagefactory.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccuweatherHomepage {
    WebDriver driver;
    Pages page=new Pages(driver);
    public static WebElement element;

    public static WebElement searchTextBox(WebDriver driver){
        element=driver.findElement(By.className("search-input"));
        return element;
    }
    public static void clickOnSearchTextBox(WebDriver driver){
        searchTextBox(driver);
        element.click();
    }


    public static WebElement selectCityFromDropDown(WebDriver driver){
        element=driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div[2]/div[2]/div[1]"));
        return element;

    }
    public static void clickOCityDropdown(WebDriver driver){
        selectCityFromDropDown(driver);
        element.click();
    }
}
