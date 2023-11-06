package com.myfirstproject.day07;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.sql.SQLOutput;
import java.util.Set;

public class Day07_Cookies extends TestBase {

    @Test
    public void handleCookies() throws InterruptedException {

        //-Go to amazon and automate the tasks:
        driver.get("https://www.ebay.com");
        //1. Find the total number of cookies
        System.out.println("*****TASK 1*****");
        Set<Cookie> cookieList = driver.manage().getCookies();
        int numOfCookies = cookieList.size(); //19
        System.out.println("Cookie number: " + numOfCookies);
        //2. Print all the cookies
        System.out.println("*****TASK 2*****");
        for (Cookie w: cookieList){
            System.out.println("Cookie: " + w);
            System.out.println("Cookie Name: " + w.getName());
            System.out.println("Cookie Value: " + w.getValue());
        }
        //3. Get the cookies by their name
        System.out.println("*****TASK 3*****");
        for (Cookie w: cookieList){
            System.out.println("Cookie Name: " + w.getName());
        }
        //4. Add new cookie
        System.out.println("*****TASK 4*****");
        Cookie myFavouriteCookie = new Cookie("my-cookie", "login-cookie");
        driver.manage().addCookie(myFavouriteCookie);
        Thread.sleep(5000);
        System.out.println(driver.manage().getCookieNamed("my-cookie"));
        System.out.println("Cookie number after addition: " +driver.manage().getCookies().size());
        //5. Delete cookie by name
        System.out.println("*****TASK 5*****");
        driver.manage().deleteCookieNamed("bm_sv");
        Thread.sleep(5000);
        System.out.println("New Cookie number: " + driver.manage().getCookies().size());
        //6. Delete all the cookies
        System.out.println("*****TASK 6*****");
        driver.manage().deleteAllCookies();
        Thread.sleep(5000);
        System.out.println("Cookie number after all delete: " + driver.manage().getCookies().size());
    }






}
