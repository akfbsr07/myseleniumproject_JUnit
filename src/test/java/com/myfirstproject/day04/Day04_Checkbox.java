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

import javax.xml.xpath.XPath;
import java.time.Duration;

public class Day04_Checkbox extends TestBase {

    /*
         remove @Before and @After methods from this class and extend TestBase class
         now this class is shorter and cleaner
     */

    @Test
    public void checkboxTest() throws InterruptedException {

        // Go to https://testcenter.techproeducation.com/index.php?page=checkboxes
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
        // Locate the elements of checkboxes
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));
        Thread.sleep(3000);
        // Then click on checkbox1 if box is not selected
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        Thread.sleep(3000);
        // Then click on checkbox2 if box is not selected
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        Thread.sleep(3000);
        // Then verify that checkbox1 and checkbox2 are selected
        Assertions.assertTrue(checkbox1.isSelected());
        Assertions.assertTrue(checkbox2.isSelected());
    }

}
