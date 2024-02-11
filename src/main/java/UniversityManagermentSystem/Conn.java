package UniversityManagermentSystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    String connectionString = "jdbc:postgresql://localhost:1234/simple";
    public Conn(){
        try{
            c = DriverManager.getConnection(connectionString,"postgres","1234");
            s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
