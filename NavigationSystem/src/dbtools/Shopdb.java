package dbtools;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Shop;

public class Shopdb {
	public static void save(Shop shop) {
		String query="insert into shop(id,name,floor,category,phone) values('"+shop.getId()+"','"+shop.getName()+"','"+shop.getFloor()+"','"+shop.getCategory()+"','"+shop.getPhone()+"')";
        DBOperations.setDataorDelete(query,"Shop added successfully!");
    }
    public static ArrayList<Shop> getAllRecords(){
    	ArrayList<Shop> arrayList=new ArrayList<>();
        try{
            ResultSet rs=DBOperations.getData("select * from shop");
            while(rs.next()){
            	Shop shop=new Shop();
            	shop.setId(rs.getInt("id"));
                shop.setName(rs.getString("name"));
                shop.setFloor(rs.getInt("floor"));
                shop.setCategory(rs.getString("category"));
                shop.setPhone(rs.getInt("phone"));
            	arrayList.add(shop);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static ArrayList<String> shopnames() {
        ArrayList<String> shopNames = new ArrayList<>();
        try {
            ResultSet rs = DBOperations.getData("SELECT name FROM shop");
            while (rs.next()) {
                shopNames.add(rs.getString("name"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return shopNames;
    }
    public static ArrayList<Shop> shopstartingwith(String ch) {
        ArrayList<Shop> shopNamesWith = new ArrayList<>();
        if(ch==null) {
        	try {
                ResultSet rs = DBOperations.getData("SELECT * FROM shop");
                while (rs.next()) {
                	Shop shop=new Shop();
                	shop.setId(rs.getInt("id"));
                    shop.setName(rs.getString("name"));
                    shop.setFloor(rs.getInt("floor"));
                    shop.setCategory(rs.getString("category"));
                    shop.setPhone(rs.getInt("phone"));
                    shopNamesWith.add(shop);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            return shopNamesWith;
        }
        else {
	        try {
	        	ResultSet rs = DBOperations.getData("SELECT * FROM shop WHERE name LIKE '" + ch + "%' OR name LIKE '%" + ch + "'");
	            while (rs.next()) {
	            	Shop shop=new Shop();
                	shop.setId(rs.getInt("id"));
                    shop.setName(rs.getString("name"));
                    shop.setFloor(rs.getInt("floor"));
                    shop.setCategory(rs.getString("category"));
                    shop.setPhone(rs.getInt("phone"));
                    shopNamesWith.add(shop);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, e);
	        }
	        return shopNamesWith;
        }
    }
    public static void update(int id, String name, int floor, String category, int phone) {
    	String query="update shop set name='"+name+"',floor='"+floor+"',category='"+category+"',phone='"+phone+"' where id='"+id+"'";
    	DBOperations.setDataorDelete(query, "Shop updated successfully");
    }
    public static void delete(int id) {
    	String query="delete from shop where id='"+id+"'";
    	DBOperations.setDataorDelete(query, "Shop deleted successfully");
    }
    public static boolean shopIdExists(int sid) {
    	boolean exists = false;
    	try{
            ResultSet rs=DBOperations.getData("select id from shop where id='"+sid+"'");
            if (rs.next()){
            	exists=true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    	return exists;
    }
    public static boolean shopNameExists(String sname) {
    	boolean exists = false;
    	try{
            ResultSet rs=DBOperations.getData("select name from shop where name='"+sname+"'");
            if (rs.next()){
            	exists=true;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    	return exists;
    }
}
