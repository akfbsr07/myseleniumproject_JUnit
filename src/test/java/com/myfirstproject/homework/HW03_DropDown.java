package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW03_DropDown extends TestBase {

    //Go to https://testcenter.techproeducation.com/index.php?page=dropdown


    @Test
    public void selectByIndexTest(){
        //1.Create method selectByIndexTest and Select Option 1 using index from Simple dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        dropDownSelectByIndex(simpleDropDown, 1);
    }


    @Test
    public void selectByValueTest(){
        //2.Create method selectByValueTest Select Option 2 by value from Simple dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        dropdownSelectByValue(simpleDropDown, "2");
    }


    //3.Create method selectByVisibleTextTest Select Option 1 value by visible text from Simple dropdown
    @Test
    public void selectByVisibleTextTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement simpleDropDown = driver.findElement(By.id("dropdown"));
        dropdownSelectByVisibleText(simpleDropDown, "Option 1");
    }


    @Test
    public void printAllTest(){
        //4.Create method printAllTest
        //Print all dropdown elements from State selection dropdown,
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement stateDropDown = driver.findElement(By.id("state"));
        Select select = new Select(stateDropDown);
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w: allOptions){
            System.out.print(w.getText()+ " ");
        }
        //and print the size of  State selection dropdown
        int sizeStates = allOptions.size();
        System.out.println("Size: " + sizeStates);
        //and Verify State selection dropdown contains Texas text
        boolean isTexasExist = false;
        for (WebElement w: allOptions){
            if (w.getText().equals("Texas")){
                isTexasExist = true;
            }
        }
        Assertions.assertTrue(isTexasExist);
    }


    @Test
    public void printFirstSelectedOptionTest(){
        //5. Create method printFirstSelectedOptionTest Print first selected option of State selection dropdown
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        WebElement stateDropDown = driver.findElement(By.id("state"));
        dropDownSelectByIndex(stateDropDown, 1);
        Select select = new Select(stateDropDown);
        System.out.println(select.getFirstSelectedOption().getText());
    }






}
