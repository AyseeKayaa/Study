import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "dyrbkr21");
        Statement statement = connection.createStatement();

        String sql1 = "SELECT country_name FROM countries WHERE region_id =1";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " + r1);

        //To see the records we have another method which is executeQuery();
         ResultSet resultSet1 = statement.executeQuery(sql1);
        // resultSet1.next();
        //  resultSet1.next();
        // resultSet1.next();
        //  resultSet1.next();
        //   System.out.println(resultSet1.getString(1));

        while(resultSet1.next()){
            System.out.println(resultSet1.getString(1));
        }
//2.Example: Select the country_id and country_name whose region_id's are greater than 2

        String sql2="SELECT country_id, country_name FROM countries WHERE region_id>2";
        ResultSet resultSet2 = statement.executeQuery(sql2);
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("country_id")+"-->"+resultSet2.getString("country_name"));
        }
      String sql3 = "SELECT * FROM companies WHERE number_of_employees =(SELECT MIN(number_of_employees) FROM companies)";
        ResultSet resultSet3 = statement.executeQuery(sql3);
        while (resultSet3.next()){
            System.out.println(resultSet3.getInt(1)+" "+resultSet3.getString(2)+" "+resultSet3.getInt(3));
        }
    }
}
