package com.myfirstproject.homework;


import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW07_DragDrop extends TestBase {

    @Test
    public void dragDropTest(){

        // driver.get("https://jqueryui.com/accordion/");
        driver.get("https://jqueryui.com/accordion/");
        // And user moves the target element(Drag me to my target) in to  destination(Drop here)
        driver.findElement(By.xpath("//a[text()='Droppable']")).click();
        // We need to use Actions class to drag and drop
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        switchIframeByWebElement(iFrame);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        actionsDragAndDropActions(source, target);

    }





}
