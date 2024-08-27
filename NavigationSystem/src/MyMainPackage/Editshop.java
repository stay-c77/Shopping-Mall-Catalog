package MyMainPackage;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import model.Shop;
import dbtools.Shopdb;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Editshop extends JFrame implements ActionListener {
	JTable table;
	JScrollPane scrollPane;
	DefaultTableModel model;
	JButton addButton,removeButton, editButton, updateButton, backButton;
	JLabel head, l1, l2, l3, l4, l5,bg;
	JTextField sid, sname, sfloor, sphone;
	JPanel panel;
	String username;
	JComboBox<String> categoryDropdown; 
	public static String[] categories = {"Entertainment", "Food and Beverages", "Adult Fashion", "Kids Fashion", "Toys", "Accessories", "Electronics", "Supermarket", "Banks", "Optics", "Services"};
	Font f=new Font("Berlin Sans FB",Font.PLAIN,15);
	
    Editshop() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY);
        
        panel=new JPanel();
        panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBounds(10, 10, 667, 440);
		add(panel);
		panel.setBackground(new Color(180, 180, 180, 180));
		
        String[] columnNames = {"ID", "Name", "Floor", "Category", "Phone"};
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
        header.setFont(f);

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(27);  // ID
        columnModel.getColumn(1).setPreferredWidth(150); // Name
        columnModel.getColumn(2).setPreferredWidth(55);  // Floor
        columnModel.getColumn(3).setPreferredWidth(120); // Category
        columnModel.getColumn(4).setPreferredWidth(110); // Phone
        
        table.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(330, 45, 320, 280);
        panel.add(scrollPane);
        
        head=new JLabel("EDIT SHOPS");
        head.setFont(new Font("Berlin Sans FB", 0, 27));
        head.setBounds(115,2,400,75);
        panel.add(head);
        
        l1 = new JLabel("Shop ID: ");
        l1.setFont(new Font("Berlin Sans FB", 0, 18));
        l1.setBounds(57,60,130,75);
        panel.add(l1);
        
        sid=new JTextField();
        sid.setFont(f);
        sid.setBounds(164,83,150,30);
        panel.add(sid);
        
        l2 = new JLabel("Shop Name: ");
        l2.setFont(new Font("Berlin Sans FB", 0, 18));
        l2.setBounds(43,139,130,30);
        panel.add(l2);
        
        sname=new JTextField();
        sname.setFont(f);
        sname.setBounds(164,142,150,30);
        panel.add(sname);
        
        l3 = new JLabel("Shop Floor: ");
        l3.setFont(new Font("Berlin Sans FB", 0, 18));
        l3.setBounds(45,177,130,75);
        panel.add(l3);
        
        sfloor=new JTextField();
        sfloor.setFont(f);
        sfloor.setBounds(164,201,150,30);
        panel.add(sfloor);
        
        l4 = new JLabel("Shop Category: ");
        l4.setFont(new Font("Berlin Sans FB", 0, 18));
        l4.setBounds(37,258,130,30);
        panel.add(l4);

        categoryDropdown = new JComboBox<>(categories);
        categoryDropdown.setFont(f);
        categoryDropdown.setBounds(164, 260, 150, 30);
        panel.add(categoryDropdown);
        
        l5 = new JLabel("Shop Phone: ");
        l5.setFont(new Font("Berlin Sans FB", 0, 18));
        l5.setBounds(45,294,130,75);
        panel.add(l5);
        
        sphone=new JTextField();
        sphone.setFont(f);
        sphone.setBounds(164,319,150,30);
        panel.add(sphone);
        
        addButton = new JButton("Add");
        addButton.setFont(f);
        addButton.setBackground(Color.BLACK);
        addButton.setForeground(Color.WHITE);
        addButton.setBounds(134,383,100,30);
        addButton.addActionListener(this);
        addButton.setVisible(true);
        panel.add(addButton);
        addButton.setEnabled(false);
        
        removeButton = new JButton("Remove");
        removeButton.setFont(f);
        removeButton.setBackground(Color.BLACK);
        removeButton.setForeground(Color.WHITE);
        removeButton.setBounds(514,345,100,30);
        removeButton.addActionListener(this); 
        panel.add(removeButton);
        
        editButton = new JButton("Edit");
        editButton.setFont(f);
        editButton.setBackground(Color.BLACK);
        editButton.setForeground(Color.WHITE);
        editButton.setBounds(394,345,100,30);
        editButton.addActionListener(this);
        panel.add(editButton);
        
        updateButton = new JButton("Update");
        updateButton.setFont(f);
        updateButton.setBackground(Color.BLACK);
        updateButton.setForeground(Color.WHITE);
        updateButton.setBounds(134,383,100,30);
        updateButton.setVisible(false);
        panel.add(updateButton);
        updateButton.addActionListener(this);
        
        DocumentListener textFieldListener = new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        validateadd();
		    }
		    
		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        validateadd();
		    }
		    
		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        validateadd();
		    }
        };

	    sid.getDocument().addDocumentListener(textFieldListener);
	    sname.getDocument().addDocumentListener(textFieldListener);
	    sfloor.getDocument().addDocumentListener(textFieldListener);
	    sphone.getDocument().addDocumentListener(textFieldListener);

	    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/mall4.jpg"));
	    bg = new JLabel(i1);
	    bg.setSize(700,500);
	    add(bg);
	    
	    ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
		setIconImage(icon.getImage());
		
		ImageIcon back = new ImageIcon(ClassLoader.getSystemResource("images/back2.jpg"));
	    backButton = new JButton(back);
	    backButton.setSize(28,28);
	    backButton.setOpaque(false);
	    backButton.setBackground(new Color(0,0,0,0));
	    backButton.addActionListener(this);
	    panel.add(backButton);
		
        setVisible(true);
    }
    Editshop(String username) {
    	this();
    	this.username=username;
    }
    public void display() {
    	DefaultTableModel dtm= (DefaultTableModel) table.getModel();
    	dtm.setRowCount(0); 
    	ArrayList<Shop> list=Shopdb.getAllRecords();
    	Collections.sort(list, Comparator.comparingInt(Shop::getId));
    	for (Shop shopObj : list) {
    		dtm.addRow(new Object[] {shopObj.getId(), shopObj.getName(), shopObj.getFloor(), shopObj.getCategory(), shopObj.getPhone()} );
    	}
    }
    public static void main(String[] args) {
    	Editshop e=new Editshop();
    	e.display();
    }
    public void validateadd() {
    	String shopid=sid.getText();
    	String shopname=sname.getText();
    	String shopfloor=sfloor.getText();
    	String shopcat=(String) categoryDropdown.getSelectedItem();
    	String shopphone=sphone.getText();
    	if(!shopid.equals("") &&!shopname.equals("") && !shopfloor.equals("") && !shopcat.equals("") && !shopphone.equals("")) {
    		addButton.setEnabled(true);
    	}
    	else {
    		addButton.setEnabled(false);
    	}
    }
    public void clear() {
    	sid.setText("");
    	sname.setText("");
    	sfloor.setText("");
//    	categoryDropdown.setSelectedIndex(-1);
    	sphone.setText("");
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton ) {
        	int newid = Integer.parseInt(sid.getText());
            if (Shopdb.shopIdExists(newid)) {
                JOptionPane.showMessageDialog(null, "Shop ID already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            String newname = sname.getText();
            if (Shopdb.shopNameExists(newname)) {
                JOptionPane.showMessageDialog(null, "Shop Name already exists", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
        	Shop shop=new Shop();
        	shop.setId(Integer.parseInt(sid.getText()));
        	shop.setName(sname.getText());
        	shop.setFloor(Integer.parseInt(sfloor.getText()));
        	shop.setCategory((String) categoryDropdown.getSelectedItem());
        	shop.setPhone(Integer.parseInt(sphone.getText()));
        	Shopdb.save(shop);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {shop.getId(), shop.getName(), shop.getFloor(), shop.getCategory(), shop.getPhone()});
        	display();
        	clear();
        }
        else if (e.getSource() == removeButton) {
        	int index=table.getSelectedRow();
        	if (index == -1) {
        	    JOptionPane.showMessageDialog(null, "Please select a row to remove.");
        	} 
        	else  {
    			TableModel model=table.getModel();
    			String shopid=model.getValueAt(index, 0).toString();
    			String shopname=model.getValueAt(index, 1).toString();
    			int a=JOptionPane.showConfirmDialog(null, "Do you want to delete "+shopname+" Shop?","Select", JOptionPane.YES_NO_OPTION);
    			if(a==0) {
    				Shopdb.delete(Integer.parseInt(shopid));
    				((DefaultTableModel) model).removeRow(index);
    				display();
    			}
        	}
        }
        else if (e.getSource() == editButton) {
        	int selectedRow=table.getSelectedRow();
        	if (selectedRow == -1) {
        	    JOptionPane.showMessageDialog(null, "Please select a row to edit.");
        	} 
        	else {
        		sid.setEditable(false);
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                sid.setText(model.getValueAt(selectedRow, 0).toString());
                sname.setText(model.getValueAt(selectedRow, 1).toString());
                sfloor.setText(model.getValueAt(selectedRow, 2).toString());
                categoryDropdown.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
                sphone.setText(model.getValueAt(selectedRow, 4).toString());
                addButton.setVisible(false);
                updateButton.setVisible(true);
            }
        }else if (e.getSource() == updateButton) {
        	int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a row to update.");
            } else {
            	int shopId = Integer.parseInt(sid.getText());
                String shopName = sname.getText();
                int shopFloor = Integer.parseInt(sfloor.getText());
                String shopCategory = (String) categoryDropdown.getSelectedItem();
                int shopPhone = Integer.parseInt(sphone.getText());

                int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update this record?", "Confirm Update", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                	Shopdb.update(shopId, shopName, shopFloor, shopCategory, shopPhone);
                    model.setValueAt(shopName, selectedRow, 1);
                    model.setValueAt(shopFloor, selectedRow, 2);
                    model.setValueAt(shopCategory, selectedRow, 3);
                    model.setValueAt(shopPhone, selectedRow, 4);
                }
            }
            addButton.setVisible(true);
            updateButton.setVisible(false);
            sid.setEditable(true);
            clear();
        } else if (e.getSource() == backButton) {
        	setVisible(false);
        	new Home(username);
        }
    }
}
