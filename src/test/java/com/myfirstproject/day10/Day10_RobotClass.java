package com.myfirstproject.day10;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day10_RobotClass extends TestBase {

    @Test
    public void fileUploadTest(){

        //Go to https://www.grammarly.com/plagiarism-checker
        driver.get("https://www.grammarly.com/plagiarism-checker");
        //Then click upload file
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div/div[2]/form/div/div[4]/button[2]/span")).click();
        //Then select a document and upload that file
        String pathOfFile = System.getProperty("user.home")+"\\Desktop\\CV.docx";
        uploadFileByRobot(pathOfFile);
        //Scan for Plagiarism
        driver.findElement(By.xpath("/html/body/div[1]/div/main/div[1]/div/div[2]/form/div/div[4]/button[1]/span/b")).click();


    }

}
