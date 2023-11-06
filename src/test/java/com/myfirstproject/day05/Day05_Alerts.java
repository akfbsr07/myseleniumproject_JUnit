package com.myfirstproject.day05;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day05_Alerts extends TestBase {

    /*
       Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
       Create a class: AlertTest
       Create setUp method
       Create 3 test methods:
       acceptAlert() => click on the first alert,
       verify the text “I am a JS Alert” ,
       click OK ,
       and Verify “You successfully clicked an alert”
       dismissAlert()=> click on the second alert,
       verify text "I am a JS Confirm”,
       click cancel,
       and Verify “You clicked: Cancel”
       sendKeysAlert()=> click on the third alert,
       verify text “I am a JS prompt”,
       type “Hello World”,
       click OK,
       and Verify “You entered: Hello World”
     */

    @Test
    public void acceptAlert(){
        // Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // acceptAlert() => click on the first alert,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        //!!!!!!!!!!!!NOW AT THIS POINT ALERT MUST BE HANDLED!!!!!!!!!!!!!
        // verify the text “I am a JS Alert” ,
        Assertions.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");
        // click OK ,
        driver.switchTo().alert().accept();
        // and Verify “You successfully clicked an alert”
        Assertions.assertTrue(driver.getPageSource().contains("You successfully clicked an alert")); // Or you can inspect message and search by xPath
    }

    @Test
    public void dismissAlert(){
        // Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //dismissAlert()=> click on the second alert,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        // verify text "I am a JS Confirm”,
        Assertions.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm");
        //click cancel,
        driver.switchTo().alert().dismiss();
        //and Verify “You clicked: Cancel”
        Assertions.assertTrue(driver.getPageSource().contains("You clicked: Cancel"));
    }

    @Test
    public void sendKeysAlert(){
        // Go to https://testcenter.techproeducation.com/index.php?page=javascript-alerts
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // sendKeysAlert()=> click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click(); //!!!!!!!!!!DO NOT FORGET TO CLICK ON ALERT NEXT TIME!!!!!!!!!!!!
        // verify text “I am a JS prompt”,
        Assertions.assertTrue(driver.switchTo().alert().getText().equals("I am a JS prompt"));
        //type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
        // click OK,
        driver.switchTo().alert().accept();
        // and Verify “You entered: Hello World”
        Assertions.assertTrue(driver.getPageSource().contains("You entered: Hello World"));
    }






}
