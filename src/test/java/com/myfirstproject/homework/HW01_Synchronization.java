package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW01_Synchronization extends TestBase {

    @Test
    public void synchronizationHomeWork1(){

        //Go to https://the-internet.herokuapp.com/dynamic_loading/2
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        //When user clicks on the Start button
        WebElement startButton = driver.findElement(By.xpath("//div//button[text()='Start']"));
        clickByJS(startButton);
        //Then verify the ‘Hello World!’ Shows up on the screen
        WebElement helloWorld = driver.findElement(By.xpath("//div//h4[text()='Hello World!']"));
        waitForVisibility(helloWorld, 15);
        Assertions.assertEquals("Hello World!", helloWorld.getText());

    }


    @Test
    public void synchronizationHomeWork2(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Click on remove button
        WebElement removeButton = driver.findElement(By.xpath("//div//button[text()='Remove']"));
        clickByJS(removeButton);
        //And verify the message is equal to “It's gone!”
        WebElement message1 = driver.findElement(By.xpath("//form//p[@id='message']"));
        waitForVisibility(message1, 15);
        Assertions.assertEquals("It's gone!", message1.getText());
        //Then click on Add button
        WebElement addButton = driver.findElement(By.xpath("//form//button[text()='Add']"));
        clickByJS(addButton);
        //And verify the message is equal to “It's back!”
        WebElement message2 = driver.findElement(By.xpath("//form//p[@id='message']"));
        waitForVisibility(message2, 15);
        Assertions.assertEquals("It's back!", message2.getText());

    }


    @Test
    public void synchronizationHomeWork3(){

        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Click enable Button
        WebElement enableButton = driver.findElement(By.xpath("//form//button[text()='Enable']"));
        clickByJS(enableButton);
        //And verify the message is equal to “It's enabled!”
        WebElement message1 = driver.findElement(By.xpath("//form//p[@id='message']"));
        waitForVisibility(message1, 15);
        Assertions.assertEquals("It's enabled!", message1.getText());
        //And verify the textbox is enabled (I can type in the box)
        WebElement textBox = driver.findElement(By.xpath("//form//input[@type='text']"));
        Assertions.assertTrue(textBox.isEnabled());
        //And click on Disable button
        WebElement disableButton = driver.findElement(By.xpath("//form//button[text()='Disable']"));
        clickByJS(disableButton);
        //And verify the message is equal to “It's disabled!”
        WebElement message2 = driver.findElement(By.xpath("//form//p[@id='message']"));
        waitForVisibility(message2, 15);
        Assertions.assertEquals("It's disabled!", message2.getText());
        //And verify the textbox is disabled (I cannot type in the box)
        Assertions.assertFalse(textBox.isEnabled());
        //NOTE: .isEnabled(); is used to check if an element is enabled or not

    }






}
