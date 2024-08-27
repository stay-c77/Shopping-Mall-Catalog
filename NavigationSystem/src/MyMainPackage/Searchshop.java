package MyMainPackage;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import dbtools.Shopdb;
import model.Shop;

public class Searchshop extends JFrame implements ActionListener{
    private JLabel browseCategoriesLabel, search;
    private JPanel panel1, panel2, panel;
    private ImageIcon searchIcon;
    private JComboBox<String> shopDropdown;
    private JTextField searchField;
    private JButton next, backbutton;
    private ArrayList<String> allShops, allCategories;
    private JTable table;
    private JScrollPane scrollPane;
	private DefaultTableModel model;
	String username;
	Font f=new Font("Berlin Sans FB",Font.PLAIN,15);

    Searchshop() {
        setTitle("Shop Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        
        String[] categories = Editshop.categories;
        allCategories = new ArrayList<>(Arrays.asList(categories));
        setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(28, 25, 630, 410);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        panel1.setBorder(border);
        panel1.setOpaque(false);
        panel1.setLayout(null);
        add(panel1);
        panel1.setBackground(new Color(235, 235, 235, 215));
        
        ImageIcon back = new ImageIcon(ClassLoader.getSystemResource("images/back2.jpg"));
        backbutton = new JButton(back);
	    backbutton.setSize(28,28);
	    backbutton.setOpaque(false);
	    backbutton.addActionListener(this);
	    panel1.add(backbutton);

        browseCategoriesLabel = new JLabel("Browse shops by Category");
        browseCategoriesLabel.setBounds(217, 103, 220, 35);
        browseCategoriesLabel.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        browseCategoriesLabel.setForeground(Color.BLACK);
        browseCategoriesLabel.setVisible(true);
    	panel1.add(browseCategoriesLabel);

        searchField = new JTextField();
        searchField.setBounds(216, 40, 200, 35);
        panel1.add(searchField);
        
        next=new JButton("\u2192");
        next.setFont(new Font("Segoe UI Symbol", Font.BOLD, 22));
        next.setForeground(Color.BLACK);
        next.setBackground(Color.LIGHT_GRAY);
        next.addActionListener(this);
        next.setPreferredSize(new Dimension(60, 60));
        next.setBounds(416,40,55,35);
        panel1.add(next);

        searchIcon = new ImageIcon(ClassLoader.getSystemResource("images/search.jpg"));
        search = new JLabel(searchIcon);
        search.setBounds(176, 40, 35, 35);
        panel1.add(search);

        panel2 = new JPanel();
        panel2.setBounds(42, 187, 600, 228);
        panel2.setLayout(new GridLayout(0, 4, 10, 10));
        panel2.setVisible(true);
        add(panel2);

        for (String category : allCategories) {
            JButton categoryButton = new JButton("<html><center>" + category + "</center></html>");
            categoryButton.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
            categoryButton.setPreferredSize(new Dimension(133, 80));
            categoryButton.setForeground(Color.DARK_GRAY);
            categoryButton.setBackground(Color.WHITE);
            categoryButton.addActionListener(e -> {
            	Categoryshops ca=new Categoryshops(category);
            	ca.display(category);
            });
            panel2.add(categoryButton);
        }
        
        setVisible(true);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
		setIconImage(icon.getImage());
    }

    Searchshop(String username){
    	this();
    	this.username=username;
    }
    public static void main(String[] args) {
        Searchshop s = new Searchshop();
    }
    public void searchname(String nm) {
    	browseCategoriesLabel.setVisible(false);
    	panel2.setVisible(false);
    	panel=new JPanel();
        panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		panel.setBounds(60, 127, 570, 282);
		add(panel);
		panel.setBackground(new Color(180, 180, 180));
		
		String[] columnNames = {"ID", "Name", "Category", "Floor", "Phone"};
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
        columnModel.getColumn(0).setPreferredWidth(27);
        columnModel.getColumn(1).setPreferredWidth(160); 
        columnModel.getColumn(2).setPreferredWidth(125);  
        columnModel.getColumn(3).setPreferredWidth(65); 
        columnModel.getColumn(4).setPreferredWidth(120); 
        
        table.setFont(new Font("Berlin Sans FB", Font.PLAIN, 14));
        table.setRowHeight(30);
        table.getTableHeader().setResizingAllowed(false);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setResizable(false);
        }
        
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 20, 500, 245);
        panel.add(scrollPane);
        
        DefaultTableModel dtm= (DefaultTableModel) table.getModel();
    	dtm.setRowCount(0); 
    	ArrayList<Shop> list=Shopdb.shopstartingwith(nm);
    	Collections.sort(list, Comparator.comparingInt(Shop::getId));
    	for (Shop shopObj : list) {
    		dtm.addRow(new Object[] {shopObj.getId(), shopObj.getName(), shopObj.getCategory(),shopObj.getFloor(), shopObj.getPhone()} );
    	}
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            String s=searchField.getText();
            searchname(s);
        } else if (e.getSource() == backbutton) {
        	setVisible(false);
            new Home(username);
        } 
    }
}
