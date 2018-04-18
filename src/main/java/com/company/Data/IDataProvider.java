package com.company.Data;

import java.sql.SQLException;
import java.util.List;

public interface IDataProvider {
    public List<String> getAllPersons() throws SQLException, ClassNotFoundException;

    public List<String> getPersonByName(String name) throws SQLException, ClassNotFoundException;

    public void createPerson(String name, int age) throws SQLException, ClassNotFoundException;

    public void deletePersonById(int id) throws SQLException, ClassNotFoundException;
}
