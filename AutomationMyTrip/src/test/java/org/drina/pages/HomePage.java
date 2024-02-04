package org.drina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//label[@for='fromCity']")
    private WebElement selectFromCity;

    @FindBy(id = "fromCity")
    private WebElement valueFromCity;

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement inputFromCity;

    @FindBy(xpath = "//label[@for='toCity']")
    private WebElement selectToCity;

    @FindBy(id = "toCity")
    private WebElement valueToCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement inputToCity;

    @FindBy(xpath = "//ul[@role='listbox']/li[1]")
    private WebElement chooseCity;

    @FindBy(xpath = "//div[@aria-label='Wed Feb 14 2024']")
    private WebElement departureDate;

    @FindBy(xpath = "//div[@data-cy='returnArea']")
    private WebElement openReturnCalendar;

    @FindBy(xpath = "//div[@aria-label='Thu Feb 15 2024']")
    private WebElement returnDate;

    @FindBy(xpath = "//a[contains(@class,'primaryBtn')]")
    private WebElement searchButton;

    public void inputFromCity(String fromCity){
        selectFromCity.click();
        inputFromCity.sendKeys(fromCity);
        delay(2000);
        chooseCity.click();
        String getValueFromCity = valueFromCity.getAttribute("value");
        Assert.assertEquals(fromCity, getValueFromCity, "Departure from " + getValueFromCity);
    }

    public void inputToCity(String toCity){
        selectToCity.click();
        inputToCity.sendKeys(toCity);
        delay(2000);
        chooseCity.click();
        String getValueToCity = valueToCity.getAttribute("value");
        Assert.assertEquals(toCity, getValueToCity, "Return to " + getValueToCity);
    }

    public void chooseDate(){
        departureDate.click();
        openReturnCalendar.click();
        returnDate.click();
        searchButton.click();
    }
}
