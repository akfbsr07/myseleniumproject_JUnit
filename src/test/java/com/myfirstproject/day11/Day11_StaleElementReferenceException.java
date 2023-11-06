package com.myfirstproject.day11;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Day11_StaleElementReferenceException extends TestBase {

    @Test
    public void staleReferenceTest(){

        driver.get("https://www.amazon.com");
        waitFor(1);
        driver.navigate().refresh();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("tea pot" + Keys.ENTER);
        //StaleElementReferenceException, due to reference is old, after we navigate back we use the same reference for searchBox web element, so we get exception
        driver.navigate().back();
        searchBox.sendKeys("coffee pot" + Keys.ENTER);

    }


    @Test
    public void staleReferenceSolutionTest(){

        driver.get("https://www.amazon.com");
        waitFor(1);
        driver.navigate().refresh();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("tea pot" + Keys.ENTER);
        //The solution is, when you navigate back, locate the searchBox again
        driver.navigate().back();
        searchBox= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")); //REFRESHING THE REFERENCE SO THAT WE DON'T GET STALE REFERENCE EXCEPTION
        searchBox.sendKeys("coffee pot" + Keys.ENTER);

    }





}
