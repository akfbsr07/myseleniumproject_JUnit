package com.myfirstproject.day06;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

public class Day06_NewWindows extends TestBase {

    @Test
    public void newTabTest() throws InterruptedException {
        //Open the pages in 2 NEW TABS and verify their TITLES
        //Linkedin
        driver.get("https://www.linkedin.com/feed/");
        String linkedinHandle = driver.getWindowHandle();
        String linkedinTitle = driver.getTitle();
        System.out.println(linkedinTitle); //Kayıt Olun | LinkedIn
        Assertions.assertTrue(driver.getTitle().equals("Kayıt Olun | LinkedIn"));
        //Ebay
        driver.switchTo().newWindow(WindowType.TAB); // CREATES A NEW TAB AND SWITCH TO NEW TAB
        //driver is on the new tab at this point
        driver.get("https://www.ebay.com/");
        String ebayHandle = driver.getWindowHandle();
        String ebayTitle = driver.getTitle();
        System.out.println(ebayTitle); //Electronics, Cars, Fashion, Collectibles & More | eBay
        Assertions.assertTrue(driver.getTitle().equals("Electronics, Cars, Fashion, Collectibles & More | eBay"));
        Thread.sleep(3000);
        //switch back to the linkedin page
        driver.switchTo().window(linkedinHandle);
        Thread.sleep(3000);
        //switch back to the ebay page
        driver.switchTo().window(ebayHandle);
        Thread.sleep(3000);
    }

    @Test
    public void newWindowTest() throws InterruptedException {
        //Open the pages in 2 NEW WINDOWS and verify their TITLES
        //Linkedin
        driver.get("https://www.linkedin.com/feed/");
        String linkedinHandle = driver.getWindowHandle();
        String linkedinTitle = driver.getTitle();
        Assertions.assertTrue(driver.getTitle().equals("Kayıt Olun | LinkedIn"));
        //Ebay
        driver.switchTo().newWindow(WindowType.WINDOW); // CREATES A NEW WINDOW AND SWITCH TO NEW WINDOW
        driver.get("https://www.ebay.com/");
        String ebayHandle = driver.getWindowHandle();
        String ebayTitle = driver.getTitle();
        Assertions.assertTrue(driver.getTitle().equals("Electronics, Cars, Fashion, Collectibles & More | eBay"));
        Thread.sleep(3000);
        //switch back to the linkedin page
        driver.switchTo().window(linkedinHandle);
        Thread.sleep(3000);
        //switch back to the ebay page
        driver.switchTo().window(ebayHandle);
        Thread.sleep(3000);
    }





}
