package org.example.DAO;

import org.example.DTO.EmployeeDTO;
import org.example.Printer.Printer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.sql.DriverManager;


public class MyLocalDAO
{


    private String URL="jdbc:mysql://localhost:3306/myLocal?serverTimezone=GMT";
    private Properties properties = new Properties();
    private Connection connection = null;
    private String selectPersons = "SELECT * FROM employee";
    private String insertEmployees = "INSERT INTO employees(emp_id, Name_Prefix, first_Name, middle_Initial, last_Name, gender, Email, Date_Of_Birth, Date_Of_Joining, salary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    ArrayList<String[]> arrayList = new ArrayList<String[]>();


    public Connection connectToDatabase()

    {
        try
        {

            properties.load(new FileReader("resources/login.properties"));
            connection = DriverManager.getConnection(URL, properties.getProperty("username") , properties.getProperty("password"));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(SQLException throwables)

        {
            throwables.printStackTrace();
        }
        return connection;
    }





    public void readPersons() {
        try {
            Statement statement = connectToDatabase().createStatement();
            ResultSet resultSet = statement.executeQuery(selectPersons);
            if (resultSet != null) {
                while (resultSet.next()) {
                    Printer.getInt(resultSet.getInt(1));
                    Printer.getString(resultSet.getString(2));
                    Printer.getString(resultSet.getString(3));
                    Printer.getString(resultSet.getString(4));

                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void addEmployees(HashMap<Integer, EmployeeDTO> theEmployees)  {
        connectToDatabase();
        try {
            PreparedStatement statement = connection.prepareStatement(insertEmployees);
            int i = 1;


            for (EmployeeDTO employee : theEmployees.values()) {
                statement.setInt(1, employee.getEmployeeId());
                statement.setString(2, employee.getName_Prefix());
                statement.setString(3, employee.getFirst_Name());
                statement.setString(4, employee.getMiddle_initial());
                statement.setString(5, employee.getLast_Name());
                statement.setString(6, employee.getGender());
                statement.setString(7, employee.getEmail());
                statement.setDate(8, Date.valueOf(employee.getDob()));
                statement.setDate(9, Date.valueOf(employee.getDoj()));
                statement.setInt(10, employee.getSalary());
                statement.addBatch();
                if (i == theEmployees.size()) {
                    statement.executeBatch();
                    connection.commit();
                }
                i++;

            }
        } catch (SQLException e) {

        }

    }


    public void deletePersons(int personId , String first_name)

    {
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(selectPersons);
            preparedStatement.setInt(1 , personId);
            preparedStatement.setString(2 , first_name);
            int hasrun = preparedStatement.executeUpdate();

            if(hasrun == 1)

            {
                System.out.println("Delete successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addEmployee(int personId , String first_name)

    {
        try {
            PreparedStatement preparedStatement = connectToDatabase().prepareStatement(selectPersons);
            preparedStatement.setInt(1 , personId);
            preparedStatement.setString(2 , first_name);
            int hasrun = preparedStatement.executeUpdate();

            if(hasrun == 1)

            {
                System.out.println("Delete successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

