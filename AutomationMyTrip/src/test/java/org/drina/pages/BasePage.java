package org.drina.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public void delay(int wait) {
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String extractedURL(String currentUrl) {
        String baseURL = null;
        try {
            URL url = new URL(currentUrl);

            // Get the base URL without query parameters
            baseURL = url.getProtocol() + "://" + url.getHost() + url.getPath();

            System.out.println("Base URL: " + baseURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return baseURL;
    }
}
