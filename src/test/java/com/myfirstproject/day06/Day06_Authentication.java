package com.myfirstproject.day06;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day06_Authentication extends TestBase {

    @Test
    public void authTest() throws InterruptedException {
        //username: admin, password: admin
        //url: the-internet.herokuapp.com/basic_auth
        //syntax to enter: https://username:password@the-internet.herokuapp.com/basic_auth

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(3000);
        Assertions.assertTrue(driver.findElement(By.xpath("//p")).getText().contains("Congratulations!"));
    }



}
