package com.myfirstproject.day04;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Day04_DropDown extends TestBase {

    /*
        -How to select from a dropdown?
        3 ways to select a dropdown option: index, value, visibleText
        -How to get selected option from a dropdown?
        We can use getFirstSelectedOption() method
     */


    @Test
    public void dropdownTest() throws InterruptedException {

        // Go to the URL https://testcenter.techproeducation.com/index.php?page=dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //Select your birthday with dropdown options
        //1. Locate the dropdown elements
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        //2. Create Select objects
        Select yearOptions = new Select(year);
        Select monthOptions = new Select(month);
        Select dayOptions = new Select(day);
        Thread.sleep(3000);
        //3. Select the options by using id, value or text
        yearOptions.selectByVisibleText("1996");
        monthOptions.selectByValue("11");
        dayOptions.selectByIndex(11);
        Thread.sleep(3000);

    //******************************************************************************************************************
        //SELECTING MONT BY REUSABLE METHODS
        dropDownSelectByIndex(driver.findElement(By.id("month")), 11); //Web Element, index

        dropDownSelectByIndex(By.xpath("//select[@id='month']"), 11); //locator, index
        dropDownSelectByIndex(By.id("month"), 11); //locator, index

        dropDownSelectByIndex("//select[@id='month']", 11); //xpath, index
    //******************************************************************************************************************

        //Assert if 1996 selected
        WebElement selectedYear = yearOptions.getFirstSelectedOption(); // We get the first selected option from dropdown as a web element
        Assertions.assertEquals(selectedYear.getText(), "1996"); // Take web element as string and assert that it is equal to our selection

        //Get all the months and assert if April is an option
        List<WebElement> monthList = monthOptions.getOptions();
        boolean isAprilExist = false;
        for (WebElement w: monthList){
            System.out.println(w.getText());
            if (w.getText().equals("April")){
                isAprilExist=true;
            }
        }

        Assertions.assertTrue(isAprilExist);
    }

    /*
    HW 1: Create a new test method: stateTest in this class
    https://testcenter.techproeducation.com/index.php?page=dropdown
    Then print the total number of states from the dropdown
    Then print all the state names
    Select 'Texas' option from dropdown
    Assert if Texas is selected or not
    Then check is the state names are in alphabetical order (THIS WILL FAIL BECAUSE STATE LIST IS NOT IN ALPHABETICAL ORDER)
     */

    @Test
    public void stateTest(){

        // Then print the total number of states from the dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement states = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateOptions = new Select(states);
        List<WebElement> stateList = stateOptions.getOptions();
        int numOfStates = stateList.size();
        System.out.println("Number of states: " + numOfStates);
        // Then print all the state names
        for (WebElement w: stateList){
            System.out.println(w.getText());
        }
        // Select 'Texas' option from dropdown
        stateOptions.selectByVisibleText("Texas");
        // Assert if Texas is selected or not
        WebElement selected = stateOptions.getFirstSelectedOption();
        Assertions.assertEquals(selected.getText(), "Texas");
        // Then check is the state names are in alphabetical order (THIS WILL FAIL BECAUSE STATE LIST IS NOT IN ALPHABETICAL ORDER)
        for (int i=1; i < stateList.size(); i++){
             String firstElement = stateList.get(i-1).getText();
             String nextElement = stateList.get(i).getText();

             if (firstElement.compareTo(nextElement)>0){
                 System.out.println("States are not in the alphabetical order.");
                 Assertions.assertTrue(false);
             }else {
                 Assertions.assertTrue(true);
                 System.out.println("States are in alphabetical order.");
             }
        }


    }








}
