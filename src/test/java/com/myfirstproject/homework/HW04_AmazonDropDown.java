package com.myfirstproject.homework;

import com.myfirstproject.utilities.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HW04_AmazonDropDown extends TestBase {

    @Test
    public void amazonDropDownTest() {
        //    Go to https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        waitFor(3);
//    Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
        WebElement amazonDropDown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
//    Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
        Select select = new Select(amazonDropDown);
        dropDownSelectByIndex(amazonDropDown, 0);
        Assertions.assertTrue(select.getFirstSelectedOption().getText().equals("All Departments"));
//    Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
        dropDownSelectByIndex(amazonDropDown, 3);
        //Assertions.assertTrue(select.getFirstSelectedOption().getText().equals("Amazon Devices"));
//    Print all the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
        List<WebElement> allOptions = select.getOptions();
        for (WebElement w : allOptions) {
            System.out.println(w.getText());
        }
//    Print the total number of options in the dropdown
        int sizeOptions = allOptions.size();
        System.out.println("Size: " + sizeOptions);
//    Assert if ‘Appliances’ is a drop-down option. Print true if “Appliances” is an option. Print false otherwise.
        boolean isAppliancesExist = false;
        for (WebElement w : allOptions) {
            if (w.getText().equals("Appliances")) {
                isAppliancesExist = true;
            }
        }
        if (isAppliancesExist == true) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        //            BONUS: Assert if the dropdown is in Alphabetical Order
        List<String> originalList = new ArrayList<>();
        List<String> sortedList = new ArrayList<>();

        for (WebElement w: allOptions){
            originalList.add(w.getText());
            sortedList.add(w.getText());
        }
        Collections.sort(sortedList);

        if (originalList.equals(sortedList)){
            System.out.println("In Alphabetical Order");
        }else {
            System.out.println("Not in Alphabetical Order");
        }

    }

}
