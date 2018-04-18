package com.company.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataProvider implements IDataProvider {
    private static final String url = "jdbc:postgresql://159.89.28.157/register";
    private static final String user = "postgres";
    private static final String password = "mysecretpassword";

    public List<String> getAllPersons() throws SQLException, ClassNotFoundException {
        List<String> persons = new ArrayList<String>();
        Connection connection = new DatabaseConnect().connectToDatabase(url, user, password);
        Statement st = connection.createStatement();
        String query = "SELECT * FROM person";
        ResultSet res = st.executeQuery(query);

        while (res.next()) {
            String id = String.valueOf(res.getInt(1));
            String name = res.getString(2);
            String age = String.valueOf(res.getInt(3));
            persons.add(id + ": " + name + ". Age:" + age);
        }
        connection.close();
        return persons;
    }

    public List<String> getPersonByName(String name) throws SQLException, ClassNotFoundException {
        List<String> persons = new ArrayList<String>();
        Connection connection = new DatabaseConnect().connectToDatabase(url, user, password);
        Statement st = connection.createStatement();
        String query = "SELECT * FROM person WHERE name LIKE '%" + name + "%'";
        ResultSet res = st.executeQuery(query);

        while (res.next()) {
            String id = String.valueOf(res.getInt(1));
            String personName = res.getString(2);
            String age = String.valueOf(res.getInt(3));
            persons.add(id + ": " + personName + ". Age:" + age);
        }
        connection.close();
        return persons;
    }

    public void createPerson(String name, int age) throws SQLException, ClassNotFoundException {
        Connection connection = new DatabaseConnect().connectToDatabase(url, user, password);
        int id = generateNewId();
        String query = "INSERT INTO person (id, name, age)" + " VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, age);
        preparedStatement.execute();

        System.out.println(name + " created in the database!");
        connection.close();
    }

    public void deletePersonById(int id) throws SQLException, ClassNotFoundException {
        Connection connection = new DatabaseConnect().connectToDatabase(url, user, password);
        Statement st = connection.createStatement();
        String query = "DELETE FROM person WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();

        System.out.println("Person with id " + id + " is deleted from the database!");
    }

    public int generateNewId() {
        int timestampId = (int) new Date().getTime() + 1000000000;
        return timestampId;
    }
}
