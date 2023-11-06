package com.myfirstproject.day07;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day07_WriteExcel {

    //Create a new class: WriteExcel
    //Create a new method: writeExcel()

    @Test
    public void writeExcelTest() throws IOException {

        //Store the path of the file as string and open the file
        String path = new String("C:\\Users\\Akif\\IdeaProjects\\myseleniumproject\\resources\\Capitals.xlsx");
        //Open the workbook
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Open the first worksheet
        Sheet sheet1 = workbook.getSheetAt(0); // workbook.getSheet("Sheet1");
        //Go to the first row
        Row row1 = sheet1.getRow(0);
        //Create a cell on the 3rd column (2nd index) on the first row
        Cell r1c3 = row1.createCell(2);
        //Write “POPULATION” on that cell
        r1c3.setCellValue("Population");
        //Create a cell on the 2nd row 3rd cell(index2), and write 150000
        Cell r2c3 = sheet1.getRow(1).createCell(2);
        r2c3.setCellValue(150000);
        //Create a cell on the 3rd row 3rd cell(index2), and write 250000
        Cell r3c3 = sheet1.getRow(2).createCell(2);
        r3c3.setCellValue(250000);
        //Create a cell on the 4th row 3rd cell(index2), and write 54000
        Cell r4c3 = sheet1.getRow(3).createCell(2);
        r4c3.setCellValue(54000);
        //Write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Akif\\IdeaProjects\\myseleniumproject\\resources\\Capitals.xlsx");
        workbook.write(fileOutputStream);
        //Close the file
        fileInputStream.close();
        fileOutputStream.close();
        //Close the workbook
        workbook.close();

    }



}
