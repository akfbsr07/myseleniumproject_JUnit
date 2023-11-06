package com.myfirstproject.day09;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day09_FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest(){

        //Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        waitFor(1);
        //Download a file from website
        WebElement file = driver.findElement(By.xpath("//a[text()='obezyana.jpg']"));
        clickByJS(file);
        //Download takes time so use hard wait
        waitFor(3);
        //Then verify if the file downloaded successfully
        String path = System.getProperty("user.home")+"\\Downloads\\obezyana.jpg";
        boolean isDownloadedFileExists = Files.exists(Paths.get(path));
        Assertions.assertTrue(isDownloadedFileExists, "Download Fails: " +path+" does not exist!"); //if test case failed, message will display

    }

}
