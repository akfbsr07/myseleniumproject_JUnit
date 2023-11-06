package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW08_DatePicker extends TestBase {

    @Test
    public void datePickTest(){

        // driver.get("https://jqueryui.com/datepicker/");
        driver.get("https://jqueryui.com/datepicker/");
        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        switchIframeByWebElement(iFrame);
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("12/12/1996");


    }





}
