package com.myfirstproject.day07;

import com.myfirstproject.utilities.TestBase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xdgf.usermodel.shape.ShapeTextVisitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day07_ReadExcel extends TestBase {

    //Import the apache poi dependency in your pom file
    //Create resources directory under project
    //Add the Excel file on the resources folder
    //Create a new class : ReadExcel

    @Test
    public void readExcelTest(){

        //Create a new test method : readExcel()
        //Store the path of the  file in a string
        String path = new String("C:\\Users\\Akif\\IdeaProjects\\myseleniumproject\\resources\\Capitals.xlsx");
        //Open the file
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            //Open the workbook using fileinputstream
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            //Open the first worksheet
            Sheet sheet1 = workbook.getSheetAt(0); // workbook.getSheet("Sheet1");
            //Go to first row
            Row row1 = sheet1.getRow(0);
            //Go to first cell on that first row and print
            Cell cell1 = row1.getCell(0);
            System.out.println(cell1.toString());
            Cell cell2 = row1.getCell(1);
            System.out.println(cell2.toString());
            //Go to 2nd row first cell  and assert if the data equal to USA
            Row row2 = sheet1.getRow(1);
            String r2c1 = row2.getCell(0).toString();
            System.out.println(r2c1);
            Assertions.assertEquals("USA", r2c1);
            //Go to 3rd row 2nd cell-chain the row and cell
            String r3c2 = sheet1.getRow(2).getCell(1).toString();
            System.out.println(r3c2);
            //Find the number of row
            int totalRowNum = sheet1.getLastRowNum()+1; //index starts at 0
            System.out.println("Total number of row: " + totalRowNum);
            //Find the number of used row
            int usedRowNum = sheet1.getPhysicalNumberOfRows(); //start count from 1
            System.out.println("Number of used row: " + usedRowNum);

             /*
        HOMEWORK : Print country, capitol key value pairs as map object()
        create a map
        then use a loop to add key value pains in the map, use the pattern of indexes
        String countries = sheet1.getRow(row number).getCell(0).toString
        String capitals = sheet1.getRow(row number).getCell(1).toString
        add this to the map
        then print
        {greece = athens, Canada= Ottowa,...}
         */
        Map<String, String> countryMap = new HashMap<>();
        for (int i=0; i<sheet1.getLastRowNum()+1; i++){
            String countries = sheet1.getRow(i).getCell(0).toString();
            String capitols = sheet1.getRow(i).getCell(1).toString();
            countryMap.put(countries, capitols);
        }
            System.out.println(countryMap);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }







}
