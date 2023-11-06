package com.myfirstproject.day10;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Day10_FluentWait extends TestBase {

    @Test
    public void fluentWaitTest(){

        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //When user clicks on the Start Button
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Create fluent wait object
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20)) //max timeout
                .pollingEvery(Duration.ofSeconds(3)) //check every 3 seconds
                .withMessage("Ignoring No Such Element Exception") //custom message
                .ignoring(NoSuchElementException.class); //ignore exception

        //rest is same with explicit wait
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        Assertions.assertEquals(helloWorld.getText(), "Hello World!");
    }

    @Test
    public void reusableFluentWaitTest(){

        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //When user clicks on the Start Button
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Create fluent wait object
        WebElement helloWorld = fluentWait("//h4[text()='Hello World!']", 20, 3);
        Assertions.assertEquals(helloWorld.getText(), "Hello World!");
    }







}
