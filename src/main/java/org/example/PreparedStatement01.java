package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "dyrbkr21");
        Statement statement = connection.createStatement();

        //1.Example: Update the number of employees to 9999 if the company name is IBM by using prepared statement
        //1.step Create Prepared Statement Query
        String sql1 ="UPDATE companies SET number_of_employees=? WHERE  company =?";

        //2.step=Create Prepared Statement object
        PreparedStatement ps1= connection.prepareStatement(sql1);

        //3.step-Assign the values by using setInt() setString() method
        ps1.setInt(1,9999);
        ps1.setString(2,"IBM");

        //4.Execute the query for the update
        int numOfRows=ps1.executeUpdate();
         String sql2="SELECT * FROM companies";

         //5.Step:Display result

        statement=connection.createStatement();
        ResultSet rs2 = statement.executeQuery(sql2);

        List<String> mylist = new ArrayList<>();

        while(rs2.next()){
            System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getInt(3));

        }


        connection.close();
        statement.close();
    }
}
