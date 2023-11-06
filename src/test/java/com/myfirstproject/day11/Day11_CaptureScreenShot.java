package com.myfirstproject.day11;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day11_CaptureScreenShot extends TestBase {

    @Test
    public void captureScreenshotTest(){

        //go to url https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        captureScreenShotEntirePage();
        //When user type "uni" in the search box
        driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("uni");
        waitFor(3);
        captureScreenShotEntirePage();
        //And select the United Kingdom from the suggestions
        driver.findElement(By.xpath("//*[text()='ted Kingdom']")).click();
        waitFor(3);
        captureScreenShotEntirePage();
        //And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        waitFor(3);
        captureScreenShotEntirePage();
        //Then verify the result contains "United Kingdom"
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());
        captureScreenShotEntirePage();

    }

}
