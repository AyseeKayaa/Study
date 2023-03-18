package org.example;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "dyrbkr21");
        Statement statement = connection.createStatement();

        //1.Example: Update the number of employees to 16000 if the number of employees is less than the average number of employees
        String sql1="UPDATE companies\n" +
                "SET number_of_employees=16000\n" +
                "WHERE number_of_employees<(SELECT AVG(number_of_employees)FROM companies)";
        int numOfRows =statement.executeUpdate(sql1);

            System.out.println("numOfRows" +" "+numOfRows);
        String sql2="SELECT * FROM companies";
        ResultSet resultSet=statement.executeQuery(sql2);

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
        }
        connection.close();
        statement.close();


    }
}
