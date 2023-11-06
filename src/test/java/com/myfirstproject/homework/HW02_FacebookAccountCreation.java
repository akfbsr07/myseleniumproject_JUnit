package com.myfirstproject.homework;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HW02_FacebookAccountCreation extends TestBase {

    Faker faker;

    @Test
    public void accountCreate(){
        //    Navigate to Go to https://www.facebook.com/
        driver.get("https://www.facebook.com/");
        //        click on 'Create new account'
        WebElement yeniHesapOluştur = driver.findElement(By.xpath("//a[text()='Yeni hesap oluştur']"));
        clickByJS(yeniHesapOluştur);
        //        driver.findElement(By.xpath("Xpath of the popup")).click();
        //    Enter first name
        faker = new Faker();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        //    Enter last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        //    Enter mobile number or email
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());
        //    Enter new password
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password(8, 16));
        //    Enter birthday
        WebElement dropdownDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        dropdownSelectByVisibleText(dropdownDay, "12");
        WebElement dropdownMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        dropdownSelectByVisibleText(dropdownMonth, "Ara");
        WebElement dropdownYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        dropdownSelectByVisibleText(dropdownYear, "1996");
        //    Enter gender
        WebElement genderSelect = driver.findElement(By.xpath("//input[@value='2']"));
        clickByJS(genderSelect);
        //    Click Sign Up
        WebElement signUpButton = driver.findElement(By.xpath("//button[text()='Kaydol']"));
        clickByJS(signUpButton);

    }








}
