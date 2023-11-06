package com.myfirstproject.day11;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day11_NoSuchElementException extends TestBase {

    @Test
    public void noSuchTest(){

        driver.get("https://www.amazon.com");
        waitFor(1);
        driver.navigate().refresh();
        //NoSuchElementException due to the space, wrong locator
        driver.findElement(By.xpath("//input[@id=' twotabsearchtextbox']")).sendKeys("tea pot" + Keys.ENTER);
    }


    @Test
    public void noSuchTest2(){

        driver.get("https://jqueryui.com/droppable/");
        //switchIframeByIndex(0);
        //NoSuchElementException due to we did not switch to iframe first
        WebElement source = driver.findElement(By.id("draggable")); //inside the iframe
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
    }






}
