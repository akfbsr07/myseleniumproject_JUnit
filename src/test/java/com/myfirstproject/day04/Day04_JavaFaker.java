package com.myfirstproject.day04;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class Day04_JavaFaker {

    /*
        java faker can be used to get fake test data
        -Where do you get your test data?
           -BA(writes the acceptance criteria)
           -Test Lead
           -Manual Tester
           -Developer
           -Team Lead
           -Database call
           -API calls
           -java faker => randomly generates data
     */

    @Test
    public void fakerTest(){

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        System.out.println(firstName);

        System.out.println(faker.name().lastName());
        System.out.println(faker.name().title());
        System.out.println(faker.address().city());
        System.out.println(faker.address().state());
        System.out.println(faker.address().fullAddress());
        System.out.println(faker.address().zipCode());
        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.number().digits(10));
        System.out.println(faker.number().numberBetween(100,2000));
        System.out.println("*******************************************");
        System.out.println(faker.witcher().character());
        System.out.println(faker.witcher().quote());
        System.out.println(faker.witcher().location());
        System.out.println(faker.witcher().witcher());
        System.out.println(faker.witcher().school());
        System.out.println(faker.witcher().monster());
    }





}
