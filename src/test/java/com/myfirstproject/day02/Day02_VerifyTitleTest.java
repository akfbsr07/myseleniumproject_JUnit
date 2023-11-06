package com.myfirstproject.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {

    public static void main(String[] args) {

        //Navigate to Amazon homepage
        //WebDriverManager.chromedriver().setup(); // NO NEED TO USE THIS ANYMORE
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
        //Verify if page title contains "Amazon"
        String actualTitle = driver.getTitle(); //returns the page title as String
        System.out.println("PAGE TITLE: " + actualTitle);
        if (actualTitle.contains("Amazon")){
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
            System.out.println("ACTUAL TITLE: " + actualTitle + "DOES NOT CONTAIN AMAZON");
            System.out.println("EXPECTED TITLE: " + "Amazon");
        }

        driver.quit(); //Always quit browser

    }

}
