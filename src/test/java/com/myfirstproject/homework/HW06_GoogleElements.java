package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class HW06_GoogleElements extends TestBase {

    @Test
    public void titleTest(){

        //titleTest =>Verify if google title = “Google"
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.getTitle().equals("Google"));
    }

    @Test
    public void imageTest(){

        //imageTest => Verify if google image displays or not
        driver.get("https://www.google.com");
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='lnXdpd']")).isDisplayed());
    }

    @Test
    public void gmailLinkTest(){

        //gmailLinkTest => Verify if the Gmail link is displayed or not
        driver.get("https://www.google.com");
        Assert.assertTrue
                (driver.findElement(By.xpath("//a[@aria-label='Gmail (yeni bir sekme açar)']")).isDisplayed());
    }






}
