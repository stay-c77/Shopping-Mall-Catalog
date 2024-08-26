package dbtools;

import java.sql.*;
public class DBConnection {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String password = System.getenv("MYSQL_PASSWORD");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/navsys", "root", password);
            return con;
        }catch(Exception ex){
            System.out.println("There were errors while connecting");
            return null;
        }
    }
}
