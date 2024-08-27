import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Loginpg implements ActionListener{
    JFrame frame;
    JTextField username, desiredUsername, email;
    JLabel l1,l2, passwordmsg, loginmsg, signup, l3, l4, l5, l6;
    private JPasswordField password, desiredPassword, confirmPassword;
    JButton login, signupButton;
    JPanel loginpanel,signuppanel,home;
    CardLayout card;
    Font f=new Font("DejaVu Serif",Font.BOLD,15);

    Loginpg(){
        frame=new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        loginpanel = new JPanel(new GridBagLayout());
        loginpanel.setBackground(new Color(192, 232, 192));

        home = new JPanel();
        home.setBackground(Color.WHITE);

        signuppanel = new JPanel(new GridBagLayout());
        signuppanel.setBackground(new Color(141, 217, 241));

        card = new CardLayout();
        frame.setLayout(card);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        l1 = new JLabel("Username: ");
        username=new JTextField(10);
        username.setFont(f);
        username.setEditable(true);
        l2 = new JLabel("Password: ");
        password=new JPasswordField(10);
        password.setFont(f);
        
        passwordmsg=new JLabel();
        loginmsg=new JLabel();
        login=new JButton("Login");
        login.setPreferredSize(new Dimension(100, 30));
        login.setBackground(Color.WHITE);
        login.addActionListener(this);

        signup = new JLabel("<html><u>Signup</u></html>"); // HTML formatting for underlined text
        signup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Set hand cursor to indicate clickable text
        signup.setForeground(new Color(26, 81, 58)); // Set text color to blue
        signup.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                card.show(frame.getContentPane(), "signuppanel");   
            }
        });

        passwordmsg.setText("");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginpanel.add(l1, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginpanel.add(username, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        loginpanel.add(l2, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        loginpanel.add(password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        loginpanel.add(loginmsg, gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(25, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        loginpanel.add(login, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(12, 5, 5, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        loginpanel.add(signup, gbc);

        l3 = new JLabel("Username: ");
        desiredUsername = new JTextField(10);
        desiredUsername.setFont(f);
        desiredUsername.setEditable(true);
        l4 = new JLabel("Password: ");
        desiredPassword = new JPasswordField(10);
        desiredPassword.setFont(f);
        desiredPassword.addActionListener(this);
        l5 = new JLabel("Confirm Password: ");
        confirmPassword = new JPasswordField(10);
        confirmPassword.setFont(f);
        l6 = new JLabel("Email id: ");
        email = new JTextField(10);
        email.setFont(f);
        signupButton = new JButton("Signup");
        signupButton.setPreferredSize(new Dimension(100, 30));
        signupButton.addActionListener(this);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 5, 5, 5);
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.anchor = GridBagConstraints.LINE_END;
        signuppanel.add(l3, gbc1);
        gbc1.gridx = 1;
        signuppanel.add(desiredUsername, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 1;
        signuppanel.add(l4, gbc1);
        gbc1.gridx = 1;
        signuppanel.add(desiredPassword, gbc1);

        gbc1.gridx = 2;
        gbc1.anchor = GridBagConstraints.CENTER;
        loginpanel.add(passwordmsg, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        signuppanel.add(l5, gbc1);
        gbc1.gridx = 1;
        signuppanel.add(confirmPassword, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 3;
        signuppanel.add(l6, gbc1);
        gbc1.gridx = 1;
        signuppanel.add(email, gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 4;
        gbc1.gridwidth = 2;
        gbc1.anchor = GridBagConstraints.CENTER;
        gbc1.insets = new Insets(25, 5, 5, 5); 
        signuppanel.add(signupButton, gbc1);

        frame.add(loginpanel, "loginpanel");
        frame.add(home, "home");
        frame.add(signuppanel, "signuppanel");
        card.show(frame.getContentPane(), "loginpanel");
        frame.setVisible(true);

        ImageIcon image=new ImageIcon("fire.jpg");
        frame.setIconImage(image.getImage());
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
        Loginpg log=new Loginpg();
    }
    private void check(){
        char[] ps = desiredPassword.getPassword();
        String passwordString = new String(ps);

        boolean hasLetter = passwordString.matches(".*[a-zA-Z].*");
        boolean hasDigit = passwordString.matches(".*\\d.*");
        boolean hasSpecialChar = passwordString.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");

        if (hasLetter && hasDigit && hasSpecialChar) {
            passwordmsg.setText("strong");
        } else {
            passwordmsg.setText("weak");
        }
    }
    private void login(){
        String usernm = username.getText();
        char[] pswd = password.getPassword();
        String passwordString = new String(pswd);

        // Here, you can implement your login logic, such as checking credentials against a database
        // For demonstration purposes, we just display a message
        loginmsg.setText("Attempting login for username: " + usernm);
        new Home();
    }
    private void signUp() {
        JOptionPane.showMessageDialog(frame, "Redirecting to Signup Page...");
        new Home();
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == password) {
            check();
        } else if (e.getSource() == login) {
            login();
        } else if (e.getSource() == signupButton) {
            signUp();
        }
    }
}
