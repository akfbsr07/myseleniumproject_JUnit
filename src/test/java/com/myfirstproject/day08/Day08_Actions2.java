package com.myfirstproject.day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions2 extends TestBase {

    @Test
    public void actions2Test() throws InterruptedException {

    //Go to https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");
        switchIframeByIndex(0);
    // Move target element to destination
        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement  target = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

    }

    @Test
    public void actions3Test(){
        driver.get("https://jqueryui.com/droppable/");
        switchIframeByIndex(0);
        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();
        //actions.dragAndDropBy(source, 454, 274).perform(); // moves to element to the target coordinate
    }
    /*
        actions.dragAndDrop(source, target).perform(); moving the source element on the target element
        actions.clickAndHold(source).moveToElement(target).release().build().perform(); moving the source element on the target element
        actions.dragAndDropBy(source, 454, 274).perform(); moving the source element on the target by specific coordinates on the page
     */


    @Test
    public void contextClickMethod(){

        //HOMEWORK:
        //Go to the URL https://testcenter.techproeducation.com/index.php?page=context-menu
        driver.get("https://testcenter.techproeducation.com/index.php?page=context-menu");
        //When user right clicks on the box
        WebElement box = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
        //Then verify the alert message is "You selected a context menu"
        String alertMessage = alertGetText();
        Assertions.assertEquals("You selected a context menu", alertMessage);
        //Then accept the alert
        alertAccept();
    }






}
