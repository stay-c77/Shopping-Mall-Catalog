package dbtools;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Shop;


public class Categorydb {
	public static ArrayList<Shop> getAllShops(String cat){
    	ArrayList<Shop> arrayList=new ArrayList<>();
        try{
            ResultSet rs=DBOperations.getData("select * from shop where category='" + cat +"'");
            while (rs.next()) {
            	Shop shop=new Shop();
            	shop.setId(rs.getInt("id"));
                shop.setName(rs.getString("name"));
                shop.setFloor(rs.getInt("floor"));
                shop.setCategory(rs.getString("category"));
                shop.setPhone(rs.getInt("phone"));
            	arrayList.add(shop);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
