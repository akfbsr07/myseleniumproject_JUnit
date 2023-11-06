package com.myfirstproject.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxTest {

    public static void main(String[] args) throws InterruptedException {

        //Open Firefox home page https://www.amazon.com/
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.com/");
        Thread.sleep(3000);
        //Maximize the window
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //Close/Quit the browser
        driver.quit();

    }

}
