package com.company;

import com.company.Data.DataProvider;

import java.sql.*;
import java.util.List;

public class Main {
    private static List<String> persons;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataProvider dataProvider = new DataProvider();

        //List all persons from the database
//        persons = dataProvider.getAllPersons();
//        for (String person: persons) {
//            System.out.println(person);
//        }
//

        //Get persons by name
        persons = dataProvider.getPersonByName("Niels");
        for (String person: persons) {
            System.out.println(person);
        }

        //Creates a person
//        dataProvider.createPerson("Charlie Peterson", 88);

//        dataProvider.deletePersonById(352492278);
    }
}
