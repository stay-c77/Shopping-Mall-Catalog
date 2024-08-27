package MyMainPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dbtools.Categorydb;
import model.Shop;

public class Categoryshops extends JFrame{
	private ArrayList<String> allshopsincat;
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel model;
	JPanel panel;
	JLabel head;
	Font f=new Font("Berlin Sans FB",Font.PLAIN,15);
	Categoryshops(String cat){
        setSize(400,400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		panel=new JPanel();
        panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBounds(10, 10, 368, 344);
		add(panel);
		panel.setBackground(new Color(180, 180, 180, 180));
		
		String[] columnNames = {"ID", "Name", "Floor", "Phone"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Rockwell", Font.BOLD, 16)); 
        header.setBackground(Color.WHITE);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(30);  
        columnModel.getColumn(1).setPreferredWidth(155); 
        columnModel.getColumn(2).setPreferredWidth(54);  
        columnModel.getColumn(3).setPreferredWidth(108); 
        
        table.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 67, 350, 270);
        panel.add(scrollPane);
        
        head=new JLabel(cat);
        head.setFont(new Font("Berlin Sans FB", 0, 22));
        head.setBounds(20,5,300,55);
        panel.add(head);
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
		setIconImage(icon.getImage());
		
        setVisible(true);
		
	}
	public void display(String cat) {
    	DefaultTableModel dtm= (DefaultTableModel) table.getModel();
    	dtm.setRowCount(0); 
    	ArrayList<Shop> list=Categorydb.getAllShops(cat);
    	Collections.sort(list, Comparator.comparingInt(Shop::getId));
    	for (Shop shopObj : list) {
    		dtm.addRow(new Object[] {shopObj.getId(), shopObj.getName(), shopObj.getFloor(), shopObj.getPhone()} );
    	}
    }
}


