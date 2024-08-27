package MyMainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import dbtools.Userdb;
import model.User;

public class Verifyuser extends JFrame implements ActionListener{
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel model;
	JPanel panel;
	JLabel head;
	JButton verify;
	Font f=new Font("Berlin Sans FB",Font.PLAIN,15);
	Verifyuser(){
		setSize(400,400);
		setLocationRelativeTo(null);
		setLayout(null);
		
		panel=new JPanel();
        panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBounds(10, 10, 370, 350);
		add(panel);
		panel.setBackground(new Color(180, 180, 180, 180));
		
		String[] columnNames = {"ID", "Name", "Username", "Email", "Status"};
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
        columnModel.getColumn(1).setPreferredWidth(105); 
        columnModel.getColumn(2).setPreferredWidth(90);  
        columnModel.getColumn(3).setPreferredWidth(120); 
        columnModel.getColumn(4).setPreferredWidth(60); 
        
        table.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 65, 350, 240);
        panel.add(scrollPane);
        
        head=new JLabel("VERIFY USERS");
        head.setFont(new Font("Berlin Sans FB", 0, 22));
        head.setBounds(115,5,300,55);
        panel.add(head);
        
        verify = new JButton("Verify user");
        verify.setFont(f);
        verify.setBackground(Color.BLACK);
        verify.setForeground(Color.WHITE);
        verify.setBounds(134,316,100,30);
        verify.setVisible(true);
        panel.add(verify);
        verify.addActionListener(this);
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
		setIconImage(icon.getImage());
		
        setVisible(true);
        display();
	}
	public void display() {
    	DefaultTableModel dtm= (DefaultTableModel) table.getModel();
    	dtm.setRowCount(0); 
    	ArrayList<User> list=Userdb.getAllRecords();
    	Collections.sort(list, Comparator.comparingInt(User::getId));
    	for (User userObj : list) {
    		if(!userObj.getUsername().equals("admin_123")) {
    			dtm.addRow(new Object[] {userObj.getId(), userObj.getName(), userObj.getUsername(), userObj.getEmail(), userObj.getStatus()} );
    		}
    	}
    }
	 public void actionPerformed(ActionEvent e) {
        if (e.getSource() == verify ) {
        	int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to verify.");
            } else {
            	DefaultTableModel model = (DefaultTableModel) table.getModel();
                int sid=(int) model.getValueAt(selectedRow, 0);
                String st=model.getValueAt(selectedRow, 4).toString();
                if(st.equals("Yes")) {
                	JOptionPane.showMessageDialog(null, "Status of selected user is already verified");
                }
                else {
                	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to verify this user?", "Confirm Update", JOptionPane.YES_NO_OPTION);
	                if (confirm == JOptionPane.YES_OPTION) {
	                	Userdb.update(sid);
	                	model.setValueAt("Yes", selectedRow, 4);
	                }
                }
                
            }
        }
	 }
}
