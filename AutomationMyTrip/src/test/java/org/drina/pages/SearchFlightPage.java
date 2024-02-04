package org.drina.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SearchFlightPage extends BasePage {

    public SearchFlightPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class,'commonOverlay')]")
    private WebElement popupLockPrice;

    @FindBy(xpath = "//button[text()='OKAY, GOT IT!']")
    private WebElement buttonOkayPopup;

    @FindBy(xpath = "//p[contains(text(),'Refundable')]")
    private WebElement checkboxRefundable;

    @FindBy(xpath = "//li[contains(text(),'Refundable Fares')]")
    private WebElement appliedFilters;

    @FindBy(xpath = "//button[starts-with(@id,'bookbutton-')][1]")
    private WebElement buttonBook;

    @FindBy(xpath = "//button[starts-with(@id,'bookbutton-') and text()='Continue']")
    private WebElement buttonContinueViewPrices;

    @FindBy(xpath = "//div[contains(@class,'fareFamilyOverlay')]")
    private WebElement farePopup;

    @FindBy(xpath = "//button[text()='CONTINUE']")
    private WebElement buttonContinue;

    @FindBy(xpath = "//span[@class='blackFont']")
    private WebElement getPrice;

    @FindBy(xpath = "//button[text()='BOOK NOW']")
    private WebElement buttonBookNow;


    public boolean isRefundableDisplayed() {
        List<WebElement> elements = driver.findElements(By.xpath("//p[contains(text(),'Refundable')]"));
        return elements.size() > 0;
    }

    public boolean isBookDisplayed() {
        List<WebElement> elements = driver.findElements(By.xpath("//button[starts-with(@id,'bookbutton-')][1]"));
        return elements.size() > 0;
    }

    public void searchFlights() {
        driverWait.until(ExpectedConditions.visibilityOf(popupLockPrice));
        buttonOkayPopup.click();
        boolean isDisplayed = isRefundableDisplayed();
        String currentURL = extractedURL(driver.getCurrentUrl());
        Assert.assertEquals(currentURL, "https://www.makemytrip.com/flight/search","Directed to Search Page");
        Assert.assertTrue(isDisplayed, "Checkbox Refundable is Showing");
    }

    public void filterRefundable() {
        checkboxRefundable.click();
        boolean successFiltered = appliedFilters.isDisplayed();
        boolean isBookDisplayed = isBookDisplayed();
        Assert.assertTrue(successFiltered, "Filter checked");
        Assert.assertTrue(isBookDisplayed, "Button Book / View Prices is Showing");
    }

    public void bookFlight() {
        String getText = buttonBook.getAttribute("innerText");
        if (getText.equals("BOOK NOW")) {
            buttonBook.click();
            driverWait.until(ExpectedConditions.visibilityOf(farePopup));
            buttonContinue.click();
            delay(3000);
            String getPriceRoundTrip = getPrice.getAttribute("innerText");
            System.out.println(getPriceRoundTrip);
            buttonBookNow.click();
        } else {
            buttonBook.click();
            buttonContinueViewPrices.click();
        }

        Set<String> handles = driver.getWindowHandles();
        if (handles.size() == 2) {
            Iterator<String> itr = handles.iterator();

            String parent_window = itr.next().toString();
            String child_window = itr.next().toString();
            System.out.println(parent_window);
            System.out.println(child_window);

            driver.switchTo().window(child_window);
        } else {
            System.out.println("New tab did not open.");
        }
        String currentURL = extractedURL(driver.getCurrentUrl());
        Assert.assertEquals(currentURL, "https://www.makemytrip.com/flight/reviewDetails/","Directed to Review Details Page");
    }
}