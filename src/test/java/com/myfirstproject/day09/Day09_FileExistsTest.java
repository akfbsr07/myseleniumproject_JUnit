package com.myfirstproject.day09;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day09_FileExistsTest {

    @Test
    public void fileExistTest(){

        //Pick a file on your desktop
        //And verify if that file exists on your computer or not
        String path = System.getProperty("user.home")+"\\Downloads\\khaleesi.jpg";
        System.out.println("Path: " + path);
        boolean isFileExists = Files.exists(Paths.get(path));
        Assertions.assertTrue(isFileExists);
    }




}
