package org.drina.tests;

import org.drina.pages.BookingPage;
import org.drina.pages.HomePage;
import org.drina.pages.SearchFlightPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    SearchFlightPage searchFlightPage;
    BookingPage bookingPage;

    @BeforeMethod
    public void setUpPages() {
        homePage = new HomePage(driver);
        searchFlightPage = new SearchFlightPage(driver);
        bookingPage = new BookingPage(driver);
    }

    @Test(priority = 1)
    public void searchFlight() {
        homePage.inputFromCity("Bangkok");
        homePage.inputToCity("Singapore");
        homePage.chooseDate();
    }

    @Test(priority = 2)
    public void flightResult() {
        searchFlightPage.searchFlights();
        searchFlightPage.filterRefundable();
        searchFlightPage.bookFlight();
    }
//
    @Test(priority = 3)
    public void bookingDetails() {
        bookingPage.informationDetails();
        bookingPage.travellerDetails();
        bookingPage.bookingDetails();
        bookingPage.reviewTravellerDetails();
        bookingPage.flightSummary();
    }
}
