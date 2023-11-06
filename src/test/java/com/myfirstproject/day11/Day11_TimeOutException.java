package com.myfirstproject.day11;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day11_TimeOutException extends TestBase {

    @Test
    public void timeOutTest(){

        driver.get("https://www.amazon.com");
        waitFor(1);
        driver.navigate().refresh();
        //NoSuchElementException due to the space, wrong locator
        //driver.findElement(By.xpath("//input[@id=' twotabsearchtextbox']")).sendKeys("tea pot" + Keys.ENTER);

        //we are thinking this failure is due to a wait problem
        //TimeoutException due to usage of explicit wait + wrong locator
        waitForVisibility(By.xpath("//input[@id=' twotabsearchtextbox']"), 15).sendKeys("tea pot" + Keys.ENTER);

        /*
            NOTE: two methods below do same thing, just the second one waits for the specific element for 15 seconds explicitly
            driver.findElement(By.xpath("//input[@id=' twotabsearchtextbox']")) = waitForVisibility(By.xpath("//input[@id=' twotabsearchtextbox']"), 15)
         */

    }






}
