package com.myfirstproject.day05;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day05_Windows extends TestBase {

    /*
       Go to https://the-internet.herokuapp.com/windows
       Assert if the window 1 handle equals "The Internet"
       Click on the link
       Assert if the window 2 title equals "New Window"
       Switch back to window 1 title and assert if URL contains "windows"
     */

    @Test
    public void windowsTest() throws InterruptedException {
        //Go to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //Assert if the window 1 title equals "The Internet"
        Assertions.assertEquals("The Internet", driver.getTitle());
        //Click on the link
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //Assert if the window 2 title equals "New Window"
        //WE HAVE TO SWITCH WINDOW 2 NOW: 1. GET WINDOW HANDLES, 2. SWITCH TO WINDOW 2 BY USING LOOP AND IF STATEMENTS
        // NOTE: YOU CAN NOT GET ONLY WINDOW 2 HANDLE DIRECTLY
        String window1Handle = driver.getWindowHandle();
        System.out.println("Window 1 Handle: " + window1Handle);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String w: windowHandles){
            if (!w.equals(window1Handle))
                driver.switchTo().window(w);
            break;
        } //NOW DRIVER IS ON THE WINDOW 2
        Thread.sleep(3000); //If the handle coming from set is not equal to window1 handle we switch to that handle what is mean we switch to the window2
        String window2Handle=driver.getWindowHandle();
        System.out.println("Window 2 Handle: " + window2Handle);
        Assertions.assertTrue(driver.getTitle().equals("New Window"));
        //Switch back to window 1 title and assert if URL contains "windows", and not contains "new"
        driver.switchTo().window(window1Handle);
        Assertions.assertTrue(driver.getCurrentUrl().contains("windows"));
        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));
        Thread.sleep(3000);
        //Switch back to window 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(3000);
        //Switch back to window 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(3000);
    }

    @Test
    public void homeWorkTesT() throws InterruptedException {
       //When navigate to https://testpages.herokuapp.com/styled/windows-test.html
        driver.get("https://testpages.herokuapp.com/styled/windows-test.html");
        Thread.sleep(3000);
       //When click on "Alerts In A New Window From JavaScript"
        driver.findElement(By.xpath("//a[text()='Alerts In A New Window From JavaScript']")).click();
        Thread.sleep(3000);
       //And Switch to new window
        String window1Handle = driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();
        for (String w: allHandles){
            if (!w.equals(window1Handle))
                driver.switchTo().window(w);
            break;
        } // After this step now we are on the window 2, and we can get its handle if we want
        String window2Handle = driver.getWindowHandle();
       //And Click on "Show alert box" button
        driver.findElement(By.xpath("//input[@onclick='show_alert()']")).click();
       //And Accept alert
        driver.switchTo().alert().accept();
       //And Click on "Show confirm box" button
        driver.findElement(By.xpath("//input[@onclick='show_confirm()']")).click();
       //And Cancel alert
        driver.switchTo().alert().dismiss();
       //Then Assert that alert is canceled
        Assertions.assertTrue(driver.findElement(By.xpath("//p[text()='false']")).isDisplayed());
       //When Click on "Show prompt box" button
        driver.findElement(By.xpath("//input[@onclick='show_prompt()']")).click();
       //And Send "Hello World!" to the alert
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();
       //Then Assert that "Hello World!" is sent
        Assertions.assertTrue(driver.findElement(By.xpath("//p[text()='Hello World!']")).isDisplayed());
    }

    @Test
    public void windowsTestWithReusableMethods() throws InterruptedException {

        //Go to https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //Assert if the window 1 title equals "The Internet"
        Assertions.assertEquals("The Internet", driver.getTitle());
        //Click on the link
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        //Assert if the window 2 title equals "New Window"
        //WE HAVE TO SWITCH WINDOW 2 NOW: 1. GET WINDOW HANDLES, 2. SWITCH TO WINDOW 2 BY USING LOOP AND IF STATEMENTS
        // NOTE: YOU CAN NOT GET ONLY WINDOW 2 HANDLE DIRECTLY

        /*
        String window1Handle = driver.getWindowHandle();
        System.out.println("Window 1 Handle: " + window1Handle);
        Set<String> windowHandles = driver.getWindowHandles();
        for (String w: windowHandles){
            if (!w.equals(window1Handle))
                driver.switchTo().window(w);} //If the handle coming from set is not equal to window1 handle we switch to that handle what is mean we switch to the window2
        */                                      //NOW DRIVER IS ON THE WINDOW 2


        //NOTE: no need to use code above because now we can switch windows easily by reusable method
        switchNewWindowByIndex(1); //switching window 2 (index=1)
        //ALTERNATIVELY WE CAN SWITCH BY TITLE
        switchNewWindowByTitle("The Internet");
        switchNewWindowByTitle("New Window");
        Thread.sleep(3000);

        String window2Handle=driver.getWindowHandle();
        System.out.println("Window 2 Handle: " + window2Handle);
        Assertions.assertTrue(driver.getTitle().equals("New Window"));

        //Switch back to window 1 title and assert if URL contains "windows", and not contains "new"
        //driver.switchTo().window(window1Handle);
        switchNewWindowByIndex(0);
        Assertions.assertTrue(driver.getCurrentUrl().contains("windows"));
        Assertions.assertFalse(driver.getCurrentUrl().contains("new"));
        Thread.sleep(3000);

        //Switch back to window 2
        switchNewWindowByIndex(1);
        Thread.sleep(3000);

        //Switch back to window 1
        switchNewWindowByIndex(0);
        Thread.sleep(3000);

    }







}
