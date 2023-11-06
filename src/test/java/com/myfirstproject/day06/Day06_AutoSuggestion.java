package com.myfirstproject.day06;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day06_AutoSuggestion extends TestBase {

    @Test
    public void autoSuggestionTest() throws InterruptedException {

        //go to url https://testcenter.techproeducation.com/index.php?page=autocomplete
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        //When user type "uni" in the search box
        driver.findElement(By.xpath("//input[@id='myCountry']")).sendKeys("uni");
        Thread.sleep(3000);
        //And select the United Kingdom from the suggestions
        driver.findElement(By.xpath("//*[text()='ted Kingdom']")).click();
        Thread.sleep(3000);
        //And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        Thread.sleep(3000);
        //Then verify the result contains "United Kingdom"
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@id='result']")).isDisplayed());

    }

}
