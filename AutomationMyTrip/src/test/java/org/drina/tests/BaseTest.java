package org.drina.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void globalSetUp() {
        System.out.println("******************* Test Execution Started *******************");
    }

    @AfterSuite
    public void globalTearDown() {
        System.out.println("******************* Test Execution Finished *******************");
    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.makemytrip.com/");

    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//    }
}
