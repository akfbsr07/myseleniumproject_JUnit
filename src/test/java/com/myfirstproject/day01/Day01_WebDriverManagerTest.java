package com.myfirstproject.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_WebDriverManagerTest {

    public static void main(String[] args) {

        /*
            add WebDriverManager dependency in pom.xml
            get the latest version
            This dependency is used to instantiate the drivers
         */


        // 1.WebDriverManager is used to instantiate the drivers
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.safaridriver().setup();

        // 2. Create the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // 3.Now that we have our driver ready to use, we can start automation
        driver.get("https://www.google.com");

    }

}
