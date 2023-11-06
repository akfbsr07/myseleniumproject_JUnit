package com.myfirstproject.day03;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Xpath_Css {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver(); // create driver
        driver.manage().window().maximize(); // maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // implicit wait, selenium wait. Waits if its necessary.
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void xpath_css(){

        //When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //And enter username
         driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        //And enter password
         driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        //And click on submit button
         driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Then verify the login is successful
         Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        //Then logout the application => click on the profile => click on the Logout
         driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
         driver.findElement(By.xpath("//a[text()='Logout']")).click();
        //Then verify the logout is successful
         Assertions.assertTrue(driver.getCurrentUrl().contains("login"));

    }








}
