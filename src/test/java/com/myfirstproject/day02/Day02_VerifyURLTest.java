package com.myfirstproject.day02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;

public class Day02_VerifyURLTest {

    public static void main(String[] args) {

        //Navigate to Amazon homepage
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
        //Verify if amazon homepage url is "https://amazon.com/"
        String currentURL = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentURL);
        if (currentURL.equals("https://amazon.com/")){
            System.out.println("PASS");
        } else {
            System.out.println("FAIL: Actual URL is " + currentURL + " but expected URL is https://amazon.com/");
        }

        driver.quit();



    }

}
/*
   QUOTE OF THE DAY:
   - Testers do not write a code to PASS
   - We write a code to CATCH A BUG

   - Our test case failed for this reason: FAIL: Actual URL is https://www.amazon.com/ but expected URL is https://amazon.com/
   - As tester, I should not fix the code to PASS
     STEPS:
   -1. Communicate with the Test Lead, Team Lead or BA to check if that is a documentation issue.
   If it is a documentation issue, BA should fix AC, and then we should update our script.
   -2. If it is an actual bug, then we should communicate with the team to see if a ticket should be raised
   or a new story should be created,...
 */
