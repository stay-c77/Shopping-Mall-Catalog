package MyMainPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener {
	JLabel bg, timing, timing1, timing2, contactUsLabel, heading, phone1Label, phone2Label, aboutUsContent, logo, catalog;
	JMenuBar menuBar;
	JMenu homeMenu, searchMenu, mapMenu, aboutUsMenu, logoutbtn, loginbtn;
	JButton search, viewmap, editshp, verifyuser;
	JPanel aboutUs, footerPanel,panel, timingpanel, absolutePanel;
	Font f=new Font("Berlin Sans FB",Font.PLAIN,15);
	String username;
	Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setTitle("Mall Catalog");
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
                
		aboutUs = new JPanel();
		aboutUs.setLayout(null);
		aboutUs.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
		aboutUs.setBounds(0, 40, 700, 400);
		aboutUs.setBackground(Color.LIGHT_GRAY);
		aboutUs.setVisible(false);
		add(aboutUs);
		
		ImageIcon l = new ImageIcon(ClassLoader.getSystemResource("images/fire2.jpg"));
	    logo = new JLabel(l);
	    logo.setBounds(200,10,80,70);
	    aboutUs.add(logo);
	    
	    catalog = new JLabel("ACES MALL");
	    catalog.setFont(new Font("Berlin Sans FB",Font.PLAIN,32));
	    catalog.setBounds(300,17,300,60);
	    aboutUs.add(catalog);
		
		aboutUsContent = new JLabel("<html><b>AceS Mall</b> is Java’s first authentic mall and its premier family shopping hub and entertainment destination, widely known for its distinctive architecture and stimulating ambience. Ideally located in Java District, one of the fastest-growing residential and commercial districts in the state, it has a total area of 135,000 sq. m with a gross leasable area of nearly 78,000 sq. m<br><br>"
		        + "Its 315 outlets cater to various lifestyles with world-class retail; fashion and jewellery brands for quality-conscious customers. The anchor stores include Marks & Spencer, H&M, and Sun & Sand Sports. It also has several coffee shops, two food courts, and a wide range of over 55 restaurants, serving local and international cuisine.<br><br>"
		        + "AceS Mall is known for the family entertainment services it offers, particularly for children, making it an ideal destination for a family outing. It has a well-equipped children’s play area, baby care rooms and an indoor theme park. It also boasts a six-screen Cineplex as well as a ten-screen Megaplex.</html>");

		aboutUsContent.setBounds(10,64,670,350);
		aboutUsContent.setFont(new Font("Gill Sans MT",Font.PLAIN,17));
		aboutUs.add(aboutUsContent);
		
		panel = new JPanel();
        panel.setLayout(null);
		panel.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
		panel.setBounds(0, 40, 700, 400);
		panel.setOpaque(false);
		panel.setVisible(true);
		add(panel);

        menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension(700, 40));
        menuBar.setBackground(Color.LIGHT_GRAY);
        
        homeMenu = new JMenu("Home  ");
        homeMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	aboutUs.setVisible(false);
            	panel.setVisible(true);
            }
        });
        searchMenu = new JMenu(" Search Shops  ");
        searchMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setVisible(false);
            	new Searchshop();
            }
        });
        mapMenu = new JMenu(" Map  ");
        mapMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setVisible(false);
            	new Viewmap();
            }
        });
        aboutUsMenu = new JMenu(" About Us  ");
        aboutUsMenu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	panel.setVisible(false);
            	aboutUs.setVisible(true);
            }
        });
        loginbtn= new JMenu(" LOGIN  ");
        loginbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	setVisible(false);
            	new Loginpage();
            }
        });
        loginbtn.setVisible(true);
        
        logoutbtn= new JMenu(" LOGOUT  ");
        logoutbtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int a=JOptionPane.showConfirmDialog(null, "Do you want to logout?", "Select", JOptionPane.YES_NO_OPTION);
            	if(a==0) {
            		setVisible(false);
                	new Home();
            	}
            	
            }
        });
        logoutbtn.setVisible(false);
        
        homeMenu.setFont(f);
        searchMenu.setFont(f);
        mapMenu.setFont(f);
        aboutUsMenu.setFont(f);
        logoutbtn.setFont(new Font("Bookman Old Style",Font.BOLD,17));
        logoutbtn.setForeground(Color.RED);
        loginbtn.setFont(new Font("Bookman Old Style",Font.BOLD,17));
        loginbtn.setForeground(Color.RED);
        
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(homeMenu);
        menuBar.add(searchMenu);
        menuBar.add(mapMenu);
        menuBar.add(aboutUsMenu);
        menuBar.add(logoutbtn);
        menuBar.add(loginbtn);
        
        footerPanel = new JPanel();
        footerPanel.setBackground(Color.LIGHT_GRAY);
        footerPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        contactUsLabel = new JLabel("Contact Us:   ");
        contactUsLabel.setFont(f);
        footerPanel.add(contactUsLabel);

        phone1Label = new JLabel("+91 8078223129     ");
        phone1Label.setFont(f);
        phone2Label = new JLabel("+91 7777777777  ");
        phone2Label.setFont(f);
        footerPanel.add(phone1Label);
        footerPanel.add(phone2Label);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(footerPanel, BorderLayout.SOUTH);
        setVisible(true);
        
        absolutePanel = new JPanel(null);
        absolutePanel.setOpaque(false);
        absolutePanel.setPreferredSize(new Dimension(300, 200));
        absolutePanel.setBounds(0, 0, 700, 400);

        timingpanel=new JPanel();
        timingpanel.setBounds(352, 265, 335, 83);
        timingpanel.setLayout(null);
        timingpanel.setBackground(new Color(200, 200, 200, 130));
        timingpanel.setVisible(true);
        
        timing=new JLabel("<html> &#9202; </html>");
		timing.setFont(new Font("Berlin Sans FB", Font.BOLD, 33));
		timing.setBounds(10, 10, 50, 50);
		timingpanel.add(timing);
		timing1=new JLabel("MON - THU   10 AM - 10 PM");
		timing1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		timing1.setBounds(70, 10, 300, 30);
		timingpanel.add(timing1);
		timing2=new JLabel("FRI - SUN   10 AM - 12 AM");
		timing2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		timing2.setBounds(70, 40, 300, 30); 
		timingpanel.add(timing2);
		
		absolutePanel.add(timingpanel);
		getContentPane().add(absolutePanel, BorderLayout.CENTER);
        
		heading=new JLabel("Welcome to AceS Mall!");
		heading.setFont(new Font("Berlin Sans FB", Font.PLAIN, 36));
		heading.setBounds(170,11,410,85);
		heading.setForeground(new Color(215,215,215));
		panel.add(heading);
				
		editshp=new JButton("Edit shops");
		editshp.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
		editshp.setBounds(22,335,135,40);
		editshp.setForeground(new Color(35,35,35));
		editshp.setBackground(new Color(210,210,210,200));
		editshp.addActionListener(this);
		panel.add(editshp);
		editshp.setVisible(false);
		
		verifyuser=new JButton("Verify users");
		verifyuser.setFont(new Font("Berlin Sans FB",Font.PLAIN,18));
		verifyuser.setBounds(22,276,135,40);
		verifyuser.setForeground(new Color(35,35,35));
		verifyuser.setBackground(new Color(210,210,210,200));
		verifyuser.addActionListener(this);
		panel.add(verifyuser);
		verifyuser.setVisible(false);
		
		panel.add(absolutePanel);
		
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/omall.jpg"));
	    bg = new JLabel(i1);
	    bg.setBounds(0,40,700,400);
	    add(bg);
	    
		setVisible(true);

		ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
		setIconImage(icon.getImage());
    }
	Home(String username){
		this();
		this.username=username;
		if(!username.equals(null)) {
			editshp.setVisible(true);
			verifyuser.setVisible(true);
			loginbtn.setVisible(false);
			logoutbtn.setVisible(true);
		}		
	}
	public static void main(String[] args) {
		Home h=new Home();
	}
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editshp) {
        	setVisible(false);
        	Editshop ed=new Editshop(username);
        	ed.display();
        } else if (e.getSource() == verifyuser) {
        	Verifyuser v=new Verifyuser();
        	v.display();
        }
    }
}

