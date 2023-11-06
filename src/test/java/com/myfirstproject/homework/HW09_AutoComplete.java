package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW09_AutoComplete extends TestBase {

    @Test
    public void autoCompleteTest(){

        //    When user goes to https://jqueryui.com/autocomplete/
        driver.get("https://jqueryui.com/autocomplete/");
        //    And type Apple
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        switchIframeByWebElement(iFrame);
        WebElement tags = driver.findElement(By.id("tags"));
        tags.sendKeys("Apple");
        //    Then select Applescript
        WebElement autoComplete = driver.findElement(By.xpath("//li//div[@tabindex='-1']"));
        autoComplete.click();
        //    And check if AppleScript is selected(you can get value by js to get text of the input)
        String inputValue = getValueByJS("tags");
        System.out.println("Input Value = " + inputValue);
        Assert.assertEquals("AppleScript", inputValue);

    }



}
