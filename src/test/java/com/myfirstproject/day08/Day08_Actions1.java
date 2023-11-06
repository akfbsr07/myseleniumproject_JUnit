package com.myfirstproject.day08;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day08_Actions1 extends TestBase {

    //Create a class: Actions1
    //Create a test method : contextClickMethod() and test the following scenario:

    @Test
    public void actions1Test() throws InterruptedException {

        //Given user is on the https://www.amazon.com
        driver.get("https://www.amazon.com");
        driver.navigate().refresh();
        Thread.sleep(3000);
        //When user click on "Account" link
        //Locating the element that I want to hover over
        WebElement accountListTab = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
        //hover over accountListTab
        //1. Create Actions object
        //2. use moveToElement function to hover over to the element, make sure use perform() at the end
        Actions actions = new Actions(driver);
        actions.moveToElement(accountListTab).perform();
        // actionsHoverOverOnElementActions(accountListTab); //we can use reusable method also
        Thread.sleep(1000);
        WebElement account = driver.findElement(By.xpath("//span[text()='Account']"));
        actions.click(account).perform();
        Thread.sleep(1000);
        //Then verify the page title contains "Your Account"
        Assertions.assertTrue(driver.getTitle().contains("Your Account"));
        //Then scroll to Amazon Music element at the bottom of the page
        WebElement amazonMusic = driver.findElement(By.xpath("//a[text()='Amazon Music']"));
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.moveToElement(amazonMusic).build().perform();
        Thread.sleep(1000);
        //And click on it
        actions.click(amazonMusic).perform();
        Thread.sleep(3000);
        //Then verify Amazon Music page is displayed
        Assertions.assertTrue(driver.getCurrentUrl().contains("music"));
        //Scroll the page up and down
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_UP).perform();

    }
    /*
        Actions is used to perform mouse and keyboard actions
        We need to create Actions object to perform actions
        Then use the appropriate function to perform mouse or keyboard events
        NOTE: MAKE SURE TO USE PERFORM AT THE END
        actions.moveToElement(accountListTab).perform(); ==> This is used to hover over the element
        actions.sendKeys(Keys.PAGE_DOWN).perform(); ==> Scroll page down
        actions.sendKeys(Keys.PAGE_UP).perform(); ==> Scroll page up
        actions.sendKeys(Keys.ARROW_DOWN).perform(); ==> Scroll page down
        actions.sendKeys(Keys.ARROW_UP).perform(); ==> Scroll page up
        DIFFERENCE BETWEEN PAGE AND ARROW FUNCTIONS ARE ARROW SCROLLS LESS THAN PAGE
        We can use multiple actions functions: actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        build() is not mandatory, but it is recommended to use when there is method chain

     */





}
