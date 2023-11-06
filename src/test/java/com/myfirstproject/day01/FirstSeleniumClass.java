package com.myfirstproject.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {


        // 1. System.setProperty is used to instantiate the driver
        //System.setProperty("WHICH DRIVER", "WHERE IS IT");
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        // 2. Create the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 3.Now that we have our driver ready to use, we can start automation
        driver.get("https://www.google.com");


    }

}
