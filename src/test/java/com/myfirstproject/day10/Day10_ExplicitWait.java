package com.myfirstproject.day10;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day10_ExplicitWait extends TestBase {

    @Test
    public void explicitWaitTest(){

        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //When user clicks on the Start Button
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Then verify the "Hello World!" shows up on the screen
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1. wait for the specific element explicitly
        //2. return that element
        //If we do not use this method, because of synchronization issue driver can not see our element
        WebElement helloWorld = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
        //waitForVisibility(By.xpath("//h4[text()='Hello World!']"), 10); //As reusable method
        Assertions.assertEquals("Hello World!", helloWorld.getText());

    }

    @Test
    public void reusableExplicitWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        WebElement helloWorld = driver.findElement(By.xpath("//h4[text()='Hello World!']"));
        waitForVisibility(helloWorld, 10);
        Assertions.assertEquals("Hello World!", helloWorld.getText());

    }








}
