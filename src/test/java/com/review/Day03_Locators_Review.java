package com.review;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Locators_Review {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void locators(){

    //When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    //And enter username
         driver.findElement(By.name("username")).sendKeys("Admin");
    //And enter password
         driver.findElement(By.name("password")).sendKeys("admin123");
    //And click on submit button
         driver.findElement(By.tagName("button")).click();
    //Then verify the login is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("dashboard"));
    //Then logout the application => click on the profile => click on the Logout
        driver.findElement(By.className("oxd-userdropdown-name")).click();
        driver.findElement(By.linkText("Logout")).click();
    //Then verify the logout is successful
        Assertions.assertTrue(driver.getCurrentUrl().contains("auth/login"));
    }

}
