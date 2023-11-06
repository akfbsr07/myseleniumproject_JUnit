package com.myfirstproject.day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_JSExecutor extends TestBase {

    @Test
    public void jsExecutorTest1() throws InterruptedException {

        //Given user is on the https://www.amazon.com
        driver.get("https://www.amazon.com");
        Thread.sleep(1000);
        driver.navigate().refresh();
        Thread.sleep(1000);
        //When user click on "Account" link
        WebElement accountListTab = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListTab).perform();
        Thread.sleep(1000);
        WebElement account = driver.findElement(By.xpath("//span[text()='Account']"));
        //actions.click(account).perform(); //actions click
        //account.click(); //normal click
        //if these 2 clicks do not work then we can use js click which is stronger
        // 1. Create javascript reference
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 2. use executeScript to execute js code
        js.executeScript("arguments[0].click();", account); //arguments[0] refers to first element which is account //clicking account using js executor
        Thread.sleep(1000);
        //Then verify the page title contains "Your Account"
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
        //Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        js.executeScript("arguments[0].scrollIntoView(true);", amazonMusic);
        Thread.sleep(1000);
        //And click on it
        js.executeScript("arguments[0].click();", amazonMusic);
        Thread.sleep(3000);
        //Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
        //Scroll the page up and down
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // all the way down
        Thread.sleep(3000);
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)"); // all the way up
        waitFor(3); //reusable method for hard wait
        scrollAllDownJS(); //reusable method for javascript scroll all down
        waitFor(3); //reusable method for hard wait
        scrollAllUpJS(); //reusable method for javascript scroll all up
        waitFor(1);
        //LOCATE THE SEARCH BOX USING JS EXECUTOR
        WebElement searchBox = locateElementByJS("navbarSearchInput");
        //TYPE POP MUSIC
        setValueByJS(searchBox, "POP MUSIC");
        waitFor(2);
        //GET AND PRINT THE VALUE OF THAT INPUT
        String inputValue = getValueByJS("navbarSearchInput");
        System.out.println(inputValue);

    }

    /*
       Javascript executor is a selenium class that is used to run javascript codes
       We should prefer normal selenium methods, but sometimes they may not work(element.click() may not click)
       Then we can try javascript executor methods
       Popular js executor methods are click(), scroll into view
       Less popular js executor methods are get elements values, locating the elements, javascript wait
     */








}
