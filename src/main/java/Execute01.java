import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","dyrbkr21");
        Statement statement = connection.createStatement();

        String sql1="CREATE TABLE workers(worker_id VARCHAR(10), worker_name VARCHAR(50), worker_salary INT)";
        boolean r1 =statement.execute(sql1);
        System.out.println("r1 = " + r1);//false-

        String sql2 ="ALTER TABLE workers ADD worker_address VARCHAR(100)";
        boolean r2 =statement.execute(sql2);
        System.out.println("r2 = " + r2);

        String sql3="DROP TABLE workers";
        statement.execute(sql3);
        connection.close();
        statement.close();


    }
}
