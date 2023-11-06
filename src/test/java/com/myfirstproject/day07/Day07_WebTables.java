package com.myfirstproject.day07;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

public class Day07_WebTables extends TestBase {

    /*
       https://the-internet.herokuapp.com/tables
Create a class: WebTables
Task 1 : Print the entire table
Task 2 : Print All Rows
Task 3 : Print Last row data only
Task 4 : Print column 5 data in the table body
Task 5 : Write a method that accepts 2 parameters
Parameter 1 = row number
Parameter 2 = column number
printData(2,3); => prints data in 2nd row 3rd column WebTables
     */

    @Test
    public void webTableTest(){

        // Go to https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");
        //Task 1 : Print the entire table
        System.out.println("*****ENTIRE TABLE*****");
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);
        //*****ALTERNATIVELY*****
        System.out.println("*****ENTIRE TABLE/ALTERNATIVE WAY*****");
        List<WebElement> elementsList = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement w: elementsList){
            System.out.println(w.getText());
        }
        //Assert if the last element in the table is "edit delete"
        Assertions.assertEquals(elementsList.get(elementsList.size()-1).getText(),"edit delete"); //get the last element from the list
        String lastElement = driver.findElement(By.xpath("//table[@id='table1']//td[last()]")).getText();
        Assertions.assertEquals("edit delete", lastElement);
        //Task 2 : Print All Rows
        System.out.println("*****ALL ROWS*****");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr"));
        int rowNum = 1;
        for (WebElement w: allRows){
            System.out.println("Row "+rowNum+": "+w.getText());
            rowNum++;
        }
        //Task 3 : Print Last row data only
        System.out.println("*****LAST ROW*****");
        String lastRow = allRows.get(allRows.size()-1).getText();
        System.out.println(lastRow);
        //Task 4 : Print column 5 data in the table body
        System.out.println("*****COLUMN 5 DATA*****");
        List<WebElement> columnFive = driver.findElements(By.xpath("//table[@id='table1']//tbody//td[5]"));
        for (WebElement w: columnFive){
            System.out.println(w.getText());
        }
        //Task 5 : Write a method that accepts 2 parameters
        //Parameter 1 = row number
        //Parameter 2 = column number
        //printData(2,3); => prints data in 2nd row 3rd colum WebTables
        System.out.println("*****SECOND ROW, THIRD COLUMN*****");
        webTableDataFinder(2, 3);


    }

    @Test
    public void webTableTest2(){

       //Go to https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");
       //Task 1 : Print the entire table 2
        System.out.println("*****ENTIRE TABLE*****");
        List<WebElement> table2 = driver.findElements(By.xpath("//table[@id='table2']//td"));
        for (WebElement w: table2){
            System.out.println(w.getText());
        }
       //Task 2 : Print Last column data only
        System.out.println("*****LAST COLUMN*****");
        List<WebElement> lastColumn = driver.findElements(By.xpath("//table[@id='table2']//tbody//td[6]"));
        for (WebElement w: lastColumn){
            System.out.println(w.getText());
        }
       //Task 3 : Print row 3 data in the table body
        System.out.println("*****ROW 3*****");
        String row3 = driver.findElement(By.xpath("//table[@id='table2']//tr[3]")).getText();
        System.out.println(row3);
       //Task 4 : Write a method that accepts 2 parameters
       //Parameter 1 = row number
       //Parameter 2 = column number
       //printData(3,4); => prints data in 3rd row 4th column WebTables
        webTableDataFinder(3, 4);

    }








}
