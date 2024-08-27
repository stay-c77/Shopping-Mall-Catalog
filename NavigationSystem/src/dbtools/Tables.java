package dbtools;

import javax.swing.JOptionPane;
public class Tables {
    public static void main(String[] args){
        try{
            String userTable="create table user(id int AUTO_INCREMENT primary key, name varchar(100), username varchar(100), password varchar(200), email varchar(200), status varchar(10), UNIQUE(username))";
            DBOperations.setDataorDelete(userTable,"User table created successfully");
            String adminDetails="insert into user(name,username,password,email,status) values('Admin','admin_123','vippassword','admin123@gmail.com','Yes')";
            DBOperations.setDataorDelete(adminDetails,"Admin details inserted successfully");
            String shopTable="create table shop(id int(10) primary key, name varchar(100), floor int(10), category varchar(500), phone int(10), UNIQUE(name))";
            DBOperations.setDataorDelete(shopTable,"Shop table created successfully");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
