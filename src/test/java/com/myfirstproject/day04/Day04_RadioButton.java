package com.myfirstproject.day04;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_RadioButton extends TestBase {


    @Test
    public void radioTest() throws InterruptedException {

        // Go to https://testcenter.techproeducation.com/index.php?page=radio-buttons
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
        Thread.sleep(3000);
        //Click on red if not already checked
        WebElement redbox = driver.findElement(By.xpath("//input[@id='red']"));
        if (!redbox.isSelected()){
            redbox.click();
        }
        Thread.sleep(3000);
        //Click on football if not already checked
        WebElement football = driver.findElement(By.xpath("//input[@id='football']"));
        if (!football.isSelected()){
            football.click();
        }
        Thread.sleep(3000);
        //Verify that buttons are checked
        Assertions.assertTrue(redbox.isSelected());
        Assertions.assertTrue(football.isSelected());
        Thread.sleep(3000);

    }




}
