package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HW05_GoogleSearch extends TestBase {

    @Test
    public void googleSearchTest(){

        //    When user goes to https://www.google.com/
    driver.get("https://www.google.com/");
//    Search for “porcelain teapot”
        driver.findElement(By.xpath("//textarea[@type='search']")).sendKeys("porcelain tea pot" + Keys.ENTER);
//    And print how many related results displayed on Google
        System.out.println(driver.findElement(By.id("result-stats")).getText());

    }

}
