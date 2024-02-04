package org.drina.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class BookingPage extends BasePage {

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public String travellerName;
    public String travellerPassport;
    public String getDepartureAirport;
    public String getReturnAirport;
    public String getDepartureDate;
    public String getReturnDate;

    @FindBy(xpath = "//div[@class='appendBottom20'][1]//h2/b")
    private WebElement departureAirport;

    @FindBy(xpath = "//div[@class='appendBottom20'][2]//h2/b")
    private WebElement returnAirport;

    @FindBy(xpath = "//div[@class='appendBottom20'][1]//span[@class='scheduleDay']")
    private WebElement departureDate;

    @FindBy(xpath = "//div[@class='appendBottom20'][2]//span[@class='scheduleDay']")
    private WebElement returnDate;

    @FindBy(xpath = "//p[@class='fillingLoaderShining']")
    private WebElement loaderShining;

    @FindBy(xpath = "//div[@id='rtaImpinfo-consent']//input[@type='checkbox']")
    private WebElement checkboxImportantNotice;

    @FindBy(xpath = "//label[contains(@class,'radioboxContainer')][1]")
    private WebElement checkInsurance;

    @FindBy(className = "addTravellerBtn")
    private WebElement addTraveller;

    @FindBy(xpath = "//input[@placeholder='First & Middle Name']")
    private WebElement inputName;

    @FindBy(xpath = "//div[contains(@class,'selectTab')]//label[2]")
    private WebElement chooseGenderFemale;

    @FindBy(xpath = "//input[@placeholder='Passport No']")
    private WebElement inputPassport;

    @FindBy(xpath = "//label[contains(text(),'Nationality')]//following-sibling::div//div[contains(@class,'dropdown__control')]")
    private WebElement clickNationality;

    @FindBy(id = "react-select-4-option-0")
    private WebElement chooseNationality;

    @FindBy(xpath = "//label[contains(text(),'Passport Issuing')]//following-sibling::div//div[contains(@class,'dropdown__control')]")
    private WebElement clickPassportIssuing;

    @FindBy(xpath = "//label[contains(text(),'Passport Issuing')]//following-sibling::div//div[@id='react-select-8-option-1']")
    private WebElement choosePassport;

    @FindBy(id = "react-select-5-input")
    private WebElement inputBirthdayDay;

    @FindBy(id = "react-select-6-input")
    private WebElement inputBirthdayMonth;

    @FindBy(id = "react-select-7-input")
    private WebElement inputBirthdayYear;

    @FindBy(id = "react-select-9-input")
    private WebElement passportExpireDay;

    @FindBy(id = "react-select-10-input")
    private WebElement passportExpireMonth;

    @FindBy(id = "react-select-11-input")
    private WebElement passportExpireYear;

    @FindBy(xpath = "//input[@placeholder='Mobile No']")
    private WebElement inputMobileNumber;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//div[@class='emailIds-dropdown']/div[1]")
    private WebElement chooseEmail;

    @FindBy(xpath = "//div[@class='dropdownFieldWpr__inputWpr']")
    private WebElement dropdownState;

    @FindBy(xpath = "//div[contains(@class,'dropdownFieldWpr')]//li[3]")
    private WebElement stateDelhi;

    @FindBy(xpath = "//div[@class='checkboxWithLblWpr']")
    private WebElement checkboxSaveBilling;

    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement buttonContinueToPayment;

    @FindBy(xpath = "//div[contains(@class,'commonOverlay')]")
    private WebElement popupConfirmation;

    @FindBy(xpath = "//button[text()='Got it']")
    private WebElement buttonConfirmChanges;

    @FindBy(xpath = "//h3[text()='Review Details']")
    private WebElement popupReviewDetails;

    @FindBy(xpath = "//span[text()='Given Name']/following-sibling::span")
    private WebElement givenName;

    @FindBy(xpath = "//span[text()='Gender']/following-sibling::span")
    private WebElement gender;
    @FindBy(xpath = "//span[text()='Passport Number']/following-sibling::span")
    private WebElement passportNumber;

    @FindBy(xpath = "//h2[text()='Complete your booking']")
    private WebElement headTitleComplete;

    @FindBy(xpath = "//button[text()='CONFIRM']")
    private WebElement buttonConfirm;

    @FindBy(xpath = "//h2[text()='Flights Summary']")
    private WebElement titleSummary;

    @FindBy(xpath = "//div[@class='flOverviewContent']/div[1]//b")
    private WebElement departureSchedule;

    @FindBy(xpath = "//div[@class='flOverviewContent']/div[2]//b")
    private WebElement returnSchedule;

    @FindBy(xpath = "//div[@class='flOverviewContent']/div[1]/span[2]/font")
    private WebElement resultDepartureDate;

    @FindBy(xpath = "//div[@class='flOverviewContent']/div[2]/span[2]/font")
    private WebElement resultReturnDate;

    @FindBy(xpath = "//button[text()='Proceed to pay']")
    private WebElement buttonProceedPay;

    @FindBy(xpath = "//div[@class='seatBookOverlayWrap']")
    private WebElement overlaySeat;

    @FindBy(xpath = "//p[@class='seatBookingOverlayCta']/span")
    private WebElement skipSeatSelection;


    public void informationDetails() {
        delay(10000);
        driverWait.until(ExpectedConditions.invisibilityOf(loaderShining));
        driverWait.until(ExpectedConditions.visibilityOf(headTitleComplete));

        getDepartureAirport = departureAirport.getAttribute("innerText");
        getReturnAirport = returnAirport.getAttribute("innerText");
        getDepartureDate = departureDate.getAttribute("innerText");
        getReturnDate = returnDate.getAttribute("innerText");

        delay(5000);
        action.scrollToElement(checkInsurance).perform();
        checkboxImportantNotice.click();
        checkInsurance.click();
    }

    public void travellerDetails() {
        travellerName = "drina";
        travellerPassport = "A1122334";

        delay(2000);
        action.scrollToElement(addTraveller).perform();
        addTraveller.click();
        inputName.sendKeys(travellerName);
        chooseGenderFemale.click();
        action.scrollToElement(inputMobileNumber).perform();
        clickNationality.click();
        chooseNationality.click();
        inputBirthdayDay.sendKeys("01", Keys.RETURN);
        inputBirthdayMonth.sendKeys("02", Keys.RETURN);
        inputBirthdayYear.sendKeys("1980", Keys.RETURN);
        action.scrollToElement(inputMobileNumber).perform();
        inputPassport.sendKeys(travellerPassport);
        clickPassportIssuing.click();
        choosePassport.click();
        passportExpireDay.sendKeys("10", Keys.RETURN);
        passportExpireMonth.sendKeys("05", Keys.RETURN);
        passportExpireYear.sendKeys("2030", Keys.RETURN);
    }

    public void bookingDetails() {
        action.scrollToElement(buttonContinueToPayment).perform();
        inputMobileNumber.sendKeys("7513200000");
        inputEmail.sendKeys("test@gmail.com");
        chooseEmail.click();
        dropdownState.click();
        stateDelhi.click();
        checkboxSaveBilling.click();
        buttonContinueToPayment.click();
    }

    public void reviewTravellerDetails() {
        driverWait.until(ExpectedConditions.visibilityOf(popupConfirmation));
        buttonConfirmChanges.click();
        buttonContinueToPayment.click();
        driverWait.until(ExpectedConditions.visibilityOf(popupReviewDetails));

        String getName = givenName.getAttribute("innerText");
        String getGender = gender.getAttribute("innerText");
        String getPassport = passportNumber.getAttribute("innerText");

        Assert.assertEquals(getName, travellerName, "Traveller Name is Same as Inputted");
        Assert.assertEquals(getPassport, travellerPassport, "Traveller Passport Number is Same as Inputted");
        Assert.assertEquals(getGender, "FEMALE", "Traveller Gender is Same as Inputted");
    }

    public void flightSummary() {
        buttonConfirm.click();
        delay(5000);
        if (overlaySeat.isDisplayed()) {
            skipSeatSelection.click();
            action.scrollToElement(titleSummary).perform();
        } else {
            buttonProceedPay.click();
        }
        action.scrollToElement(titleSummary).perform();

        String getDepartureAirportSummary = departureSchedule.getAttribute("innerText");
        String getReturnAirportSummary = returnSchedule.getAttribute("innerText");

        String[] splitDepartureSchedule = resultDepartureDate.getAttribute("innerText").split(" ·");
        String getResultDeparture = splitDepartureSchedule[0].trim();

        String[] splitReturnSchedule = resultReturnDate.getAttribute("innerText").split(" ·");
        String getResultReturn = splitReturnSchedule[0].trim();

        Assert.assertEquals(getDepartureAirportSummary, getDepartureAirport, "Displayed Departure Airport");
        Assert.assertEquals(getReturnAirportSummary, getReturnAirport, "Displayed Return Airport");
        Assert.assertEquals(getResultDeparture, getDepartureDate, "Displayed Date Departure");
        Assert.assertEquals(getResultReturn, getReturnDate, "Displayed Date Return");
    }

}
