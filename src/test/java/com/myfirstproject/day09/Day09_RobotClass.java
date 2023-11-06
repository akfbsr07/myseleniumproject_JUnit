package com.myfirstproject.day09;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Day09_RobotClass extends TestBase {

    @Test
    public void fileUploadTest() throws AWTException {

        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        waitFor(3);
        String pathOfFile = System.getProperty("user.home")+"\\Downloads\\khaleesi.jpg";

        //ROBOT CLASS
        StringSelection ss = new StringSelection(pathOfFile);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        // PRESSING CONTROL V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        waitFor(3);
        //RELEASE
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        waitFor(3);
        //CLICK ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        waitFor(3);
        //RELEASE ENTER
        robot.keyRelease(KeyEvent.VK_ENTER);
        waitFor(3);
        //FILE UPLOAD IS DONE
        //And click on the upload button
        WebElement uploadButton = driver.findElement(By.xpath("//input[@name='upload']"));
        clickByJS(uploadButton);
        waitFor(3);
        //Then verify "You uploaded a file. This is the result." message displayed
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='explanation']")).getText(), "You uploaded a file. This is the result.", "File upload is not successfull");

    }






}
