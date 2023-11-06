package com.myfirstproject.day11;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day11_CaptureScreenshotElements extends TestBase {

    @Test
    public void captureScreenshotOfElementTest(){

        //Go to google homepage
        driver.get("https://www.google.com");
        //Then verify logo is displayed
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Google']"));
        captureScreenShotOfElement(logo);
        //Write something on search box and take screenshot
        WebElement searchBox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchBox.sendKeys("iphone 15 prices");
        captureScreenShotOfElement(searchBox);
        searchBox.sendKeys(Keys.ENTER);
        //Take the screenshot of results of search
        captureScreenShotEntirePage();
    }






}
