package dbtools;

import java.sql.*;
public class DBConnection {
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/navsys","root","acemysql77");
            return con;
        }catch(Exception ex){
            System.out.println("There were errors while connecting");
            return null;
        }
    }
}
