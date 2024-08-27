package dbtools;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
public class Userdb {
    public static void save(User user){
        String query="insert into user(name,username,password,email, status) values('"+user.getName()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','No')";
        DBOperations.setDataorDelete(query,"Registration applied successfully, wait for admin approval");
    }
    public static User login(String username, String password){
        User user=null;
        try{
            ResultSet rs=DBOperations.getData("select * from user where username='"+username+"' and password='"+password+"'");
            while(rs.next()){
                user=new User();
                user.setStatus(rs.getString("status"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    public static void update(int id) {
    	String query="update user set status='Yes' where id='"+id+"'";
    	DBOperations.setDataorDelete(query, "Status changed successfully");
    }
    public static ArrayList<User> getAllRecords(){
    	ArrayList<User> arrayList=new ArrayList<>();
        try{
            ResultSet rs=DBOperations.getData("select * from user");
            while(rs.next()){
            	User user=new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setUsername(rs.getString("username"));
            	user.setPassword(rs.getString("password"));
            	user.setEmail(rs.getString("email"));
            	user.setStatus(rs.getString("status"));
            	arrayList.add(user);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}

