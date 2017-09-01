package sample;
import java.sql.*;

public class ConObj
{
    public Connection getCon()
    {
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/wisdom arena","root","");
            return  connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}
