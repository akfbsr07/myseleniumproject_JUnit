package com.myfirstproject.day09;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day09_FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest(){

        //Go to https://testpages.herokuapp.com/styled/file-upload-test.html
        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        waitFor(3);
        //When user clicks on Choose File
        //When user selects an image from the desktop
        /*
           file upload system is created using "input type=file", so we can use sendKeys(PATH) to upload the file
         */
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='fileinput']"));
        String pathOfFile = System.getProperty("user.home")+"\\Downloads\\khaleesi.jpg";
        chooseFile.sendKeys(pathOfFile);
        waitFor(3);
        //And click on the upload button
        WebElement uploadButton = driver.findElement(By.xpath("//input[@name='upload']"));
        clickByJS(uploadButton);
        waitFor(3);
        //Then verify "You uploaded a file. This is the result." message displayed
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='explanation']")).getText(), "You uploaded a file. This is the result.", "File upload is not successfull");
    }




}
