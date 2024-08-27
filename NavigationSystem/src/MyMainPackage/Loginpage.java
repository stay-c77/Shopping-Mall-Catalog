package MyMainPackage;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;
import dbtools.Userdb;
import java.awt.*;
import java.awt.event.*;
import model.User;

public class Loginpage extends JFrame implements ActionListener{
    JTextField username, desiredName, desiredUsername, email;
    JLabel l1,l2, passwordmsg, signup, l3, l4, l5, l6, loginhead, signuphead, bg;
    private JPasswordField password, desiredPassword;
    JButton login, signupButton, backbutton,backbutton2;
    JPanel loginpanel,signuppanel,home;
    Font f=new Font("Berlin Sans FB",Font.PLAIN,15);
    public String emailPattern="^[a-zA-Z0-9._]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";

    Loginpage(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
		setLocationRelativeTo(null);
		setLayout(null);
        
        loginpanel = new JPanel();
        loginpanel.setBounds(95, 45, 400, 380);
        Border border = BorderFactory.createLineBorder(Color.BLACK); 
        loginpanel.setBorder(border);
        loginpanel.setLayout(null);
        add(loginpanel);
        loginpanel.setBackground(new Color(235, 235, 235, 215));

        signuppanel = new JPanel();
        signuppanel.setBounds(95, 45, 400, 380);
        signuppanel.setBorder(border);
        signuppanel.setLayout(null);
        add(signuppanel);	
        signuppanel.setVisible(false);
        signuppanel.setBackground(new Color(235, 235, 235, 215));

        loginhead=new JLabel("ADMIN LOGIN");
        loginhead.setFont(new Font("Berlin Sans FB", 0, 27));
        loginhead.setBounds(116,22,400,75);
        loginpanel.add(loginhead);
        
        signuphead=new JLabel("SIGN UP");
        signuphead.setFont(new Font("Berlin Sans FB", 0, 27));
        signuphead.setBounds(153,0,400,75);
        signuppanel.add(signuphead);
        
        l1 = new JLabel("Username: ");
        l1.setFont(new Font("Berlin Sans FB", 0, 18));
        l1.setBounds(79,88,400,75);
        loginpanel.add(l1);
        
        username=new JTextField();
        username.setFont(f);
        username.setBounds(184,111,150,30);
        loginpanel.add(username);
        
        l2 = new JLabel("Password: ");
        l2.setFont(new Font("Berlin Sans FB", 0, 18));
        l2.setBounds(79,170,100,30);
        loginpanel.add(l2);
        
        password=new JPasswordField();
        password.setFont(f);
        password.setBounds(184,173,150,30);
        loginpanel.add(password);
        
        login=new JButton("LOGIN");
        loginhead.setFont(new Font("Berlin Sans FB", 0, 28));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBounds(154,245,100,30);
        loginpanel.add(login);
        
        ImageIcon back = new ImageIcon(ClassLoader.getSystemResource("images/back2.jpg"));
	    backbutton = new JButton(back);
	    backbutton.setSize(28,28);
	    backbutton.setOpaque(false);
	    backbutton.setBackground(new Color(0,0,0,0));
	    backbutton.addActionListener(this);
	    loginpanel.add(backbutton);
        
	    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/mall6.jpg"));
	    bg = new JLabel(i1);
	    bg.setSize(600,500);
	    add(bg);
        
        signup = new JLabel("<html><u>Signup</u></html>"); 
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        signup.setForeground(new Color(65,11,129)); 
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loginpanel.setVisible(false);
                signuppanel.setVisible(true);
            }
        });
        signup.setBounds(181, 279, 120, 30);
        loginpanel.add(signup);
        
        backbutton2 = new JButton(back);
	    backbutton2.setSize(28,28);
	    backbutton2.setOpaque(false);
	    backbutton2.setBackground(new Color(0,0,0,0));
	    backbutton2.addActionListener(this);
        signuppanel.add(backbutton2);

        l3 = new JLabel("Name: ");
        l3.setFont(new Font("Berlin Sans FB", 0, 18));
        l3.setBounds(75,58,400,75);
        signuppanel.add(l3);
        
        desiredName = new JTextField();
        desiredName.setFont(f);
        desiredName.setEditable(true);
        desiredName.setBounds(180,81,150,30);
        signuppanel.add(desiredName);
        
        l4 = new JLabel("Username: ");
        l4.setFont(new Font("Berlin Sans FB", 0, 18));
        l4.setBounds(75,137,100,30);
        signuppanel.add(l4);
        
        desiredUsername = new JTextField();
        desiredUsername.setFont(f);
        desiredUsername.setBounds(180,140,150,30);
        signuppanel.add(desiredUsername);
        
        l5 = new JLabel("Password: ");
        l5.setBounds(75,197,100,30);
        l5.setFont(new Font("Berlin Sans FB", 0, 18));
        signuppanel.add(l5);
        
        desiredPassword = new JPasswordField();
        desiredPassword.setFont(f);
        desiredPassword.setBounds(180,199,150,30);
        desiredPassword.addActionListener(this);
        signuppanel.add(desiredPassword);
        
        passwordmsg=new JLabel();
        passwordmsg.setFont(new Font("Berlin Sans FB", 0, 13));
        passwordmsg.setBounds(285,220,100,27);
        passwordmsg.setVisible(false);
        passwordmsg.setOpaque(false);
        passwordmsg.setBackground(new Color(0,0,0,0));
        passwordmsg.setForeground(Color.RED);
        passwordmsg.setText("");
        signuppanel.add(passwordmsg);
        
        l6 = new JLabel("Email id: ");
        l6.setFont(new Font("Berlin Sans FB", 0, 18));
        l6.setBounds(75,253,100,30);
        signuppanel.add(l6);
        
        email = new JTextField();
        email.setFont(f);
        email.setBounds(180,256,150,30);
        signuppanel.add(email);
        
        signupButton = new JButton("Sign up");
        signupButton.setBounds(152,313,100,30);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.WHITE);
        signupButton.addActionListener(this);
        signuppanel.add(signupButton);
        
        //add(signuppanel);
        setVisible(true);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
		setIconImage(icon.getImage());

        loginpanel.setPreferredSize(new Dimension(300, 200));

        desiredPassword.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                check();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                check();
            }
        });
    }
    public static void main(String[] args){
        Loginpage log=new Loginpage();
    }
    private void check(){
        char[] ps = desiredPassword.getPassword();
        String passwordString = new String(ps);

        passwordmsg.setVisible(true);
        boolean hasLetter = passwordString.matches(".*[a-zA-Z].*");
        boolean hasDigit = passwordString.matches(".*\\d.*");
        boolean hasSpecialChar = passwordString.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
        if (passwordString.isEmpty()) {
            passwordmsg.setVisible(false);
            passwordmsg.setOpaque(false);
            passwordmsg.setBackground(new Color(0, 0, 0, 0));
            passwordmsg.setText("");
        }
        if(hasLetter && hasDigit && hasSpecialChar && passwordString.length()>7){
            passwordmsg.setText("Strength: High");
	    }
	    else if((hasLetter && hasDigit || hasLetter && hasSpecialChar  || hasDigit && hasSpecialChar) && passwordString.length()>5){
	    	passwordmsg.setText("Strength: Moderate");
	    }
	    else{
	    	passwordmsg.setText("Strength: Low");
	    }
    }
	    
    private void login(){
        String usernm = username.getText();
        char[] pswd = password.getPassword();
        String passwordString = new String(pswd);
        User user=null;
        user=Userdb.login(usernm, passwordString);
        if(usernm.isEmpty() || passwordString.isEmpty()){
            JOptionPane.showMessageDialog(null,"Username/Password should not be empty","Error",JOptionPane.ERROR_MESSAGE);
        }   
        else if( user==null) {
        	JOptionPane.showMessageDialog(null, "Incorrect username or password","Message", JOptionPane.ERROR_MESSAGE);
        }
    	else {
    		if(user.getStatus().equals("No")) {
    			JOptionPane.showMessageDialog(null, "Wait for admin approval","Message", JOptionPane.ERROR_MESSAGE);
    		}
    		else {
    			setVisible(false);
    			new Home(usernm);
    		}
    	}    
    }
    private void signUp() {
    	String usname=desiredUsername.getText();
        String eml=email.getText();
        String nm=desiredName.getText();
        char[] p=desiredPassword.getPassword();
        String pswd = new String(p);
        if(!nm.equals("") && !usname.equals("") && eml.matches(emailPattern) && !pswd.equals("")){
        	User user=new User();
        	user.setUsername(usname);
        	user.setEmail(eml);
        	user.setName(nm);
        	user.setPassword(pswd);
        	Userdb.save(user);
        	setVisible(false);
        	new Home();
        }
        else{
        	if(nm.equals("") || usname.equals("") || pswd.equals("")){
        		JOptionPane.showMessageDialog(null,"Enter all fields","Error",JOptionPane.ERROR_MESSAGE);
            }
        	else if( !eml.matches(emailPattern)) {
        		JOptionPane.showMessageDialog(null,"Email is not valid","Error",JOptionPane.ERROR_MESSAGE);
        	}
        	else {
        		JOptionPane.showMessageDialog(null,"There has been an error","Error",JOptionPane.ERROR_MESSAGE);
        	}
        	
        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == password) {
            check();
        } else if (e.getSource() == login) {
            login();
        } else if (e.getSource() == signupButton) {
            signUp();
        } else if (e.getSource() == backbutton) {
        	setVisible(false);
            new Home();
        } else if (e.getSource() == backbutton2) {
            signuppanel.setVisible(false);
            loginpanel.setVisible(true);
        }
    }
}
