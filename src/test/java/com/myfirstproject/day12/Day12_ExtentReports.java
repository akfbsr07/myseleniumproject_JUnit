package com.myfirstproject.day12;

import com.myfirstproject.utilities.LoggerUtils;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;

public class Day12_ExtentReports extends TestBase {

    @Test
    public void extentReportsTest(){

        extentTest.pass("Logged in successful"); //pass is used to mark as passed
        extentTest.fail("Login is failed"); //fail is used to mark as failed
        extentTest.skip("Login is skipped");
        extentTest.warning("Pay attention to login");
        extentTest.info("Login is successful");

        //Assertions.assertTrue("Amazon title".contains("Amazon"), "Amazon title test failed");

        // In testing, we can use extent reports within conditions
        if ("Amazon title".contains("amazon")){
            extentTest.pass("Amazon title test passed");
        }else {
            extentTest.fail("Amazon title test failed");
        }

    }

    @Test
    public void extentReportsTest2() throws IOException {

        LoggerUtils.info("Starting the case about auto complete functionality...");

        extentTest.pass("Navigation to the application home page") //marking test step as pass
                .assignAuthor("John", "Sam", "Nancy") //optional : adding authors
                .assignCategory("Smoke", "Regression", "Integration") //optional : adding test categories
                .assignDevice("Mac", "Windows") //optional : adding devices
                .addScreenCaptureFromPath(captureScreenShotEntirePageAsString()); //optional : adding screenshot at this point

        //go to url https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        extentTest.pass("User is on the homepage")
                .addScreenCaptureFromPath(captureScreenShotEntirePageAsString(), "Page opened");
        //When user type "uni" in the search box
        driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("uni");
        waitFor(3);
        extentTest.pass("Typed uni in the search box")
                .addScreenCaptureFromPath(captureScreenShotEntirePageAsString(), "uni typed");
        //And select the United Kingdom from the suggestions
        driver.findElement(By.xpath("//*[text()='ted Kingdom']")).click();
        waitFor(3);
        extentTest.pass("Selected United Kingdom option")
                .addScreenCaptureFromPath(captureScreenShotEntirePageAsString(), "United Kingdom Selected");
        //And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        waitFor(3);
        //Then verify the result contains "United Kingdom"
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());
        extentTest.pass("Result contains United Kingdom")
                .addScreenCaptureFromPath(captureScreenShotEntirePageAsString(), "After Button Click");

        LoggerUtils.info("Test is completed successfully...");

    }






}
