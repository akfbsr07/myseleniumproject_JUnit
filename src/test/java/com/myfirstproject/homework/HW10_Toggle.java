package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW10_Toggle extends TestBase {

    @Test
    public void toggleTest(){

        //driver.get("https://jqueryui.com/toggle/");
        driver.get("https://jqueryui.com/toggle/");
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        switchIframeByWebElement(iFrame);
        WebElement toggle = driver.findElement(By.xpath("//h3[text()='Toggle']"));
        Assertions.assertTrue(toggle.isDisplayed());
        WebElement hideButton = driver.findElement(By.xpath("//button[@id='button']"));
        hideButton.click();
        waitFor(2);
        Assertions.assertFalse(toggle.isDisplayed());
        hideButton.click();
        waitFor(2);
        Assertions.assertTrue(toggle.isDisplayed());

    }



}
