package com.myfirstproject.day05;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class Day05_IFrames extends TestBase {

    //Given: Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
    //Then: Assert that "Left List Item 29" is the last element in the "Left"
    //And: Assert that "Middle List Item 39" is the last element in the "Middle"

    @Test
    public void iFrameTest(){
        //Given: Go to https://testpages.herokuapp.com/styled/frames/frames-test.html
        driver.get("https://testpages.herokuapp.com/styled/frames/frames-test.html");
        //Then: Assert that "Left List Item 29" is the last element in the "Left"
        // "Left List Item 29" is inside the iframe so switch to iframe first
        /*
            NOTE 1: There are 3 ways to switch to a frame: index, id/name, web element
            1. driver.switchTo().frame(1);
            2. driver.switchTo().frame("left");
            3. driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='left']")));

            NOTE 2: When you want to switch to non-child frames as sibling frames, we should go to parent then the child.
            We can not directly jump to the siblings
         */
        driver.switchTo().frame("left");
        //NOW WE INSIDE THE IFRAME
        //li[last()] => XPATH RETURNS THE LAST li ELEMENT
        String lastElementLeft = driver.findElement(By.xpath("//li[last()]")).getText();
        Assertions.assertTrue(lastElementLeft.equals("Left List Item 29"));
        //And: Assert that "Middle List Item 39" is the last element in the "Middle"
        //To go to sibling frames, switch to parent first then switch to child
        driver.switchTo().defaultContent(); //driver.switchTo().parentFrame()
        driver.switchTo().frame("middle");
        String lastElementMiddle = driver.findElement(By.xpath("//li[last()]")).getText();
        Assertions.assertEquals("Middle List Item 39", lastElementMiddle);

    }

}
