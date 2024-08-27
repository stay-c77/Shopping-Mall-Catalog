import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Home implements ActionListener{
	JFrame frame;
	JPanel homepanel;
    JButton gotomap, inputshp, editshp;
    Font f=new Font("DejaVu Serif",Font.BOLD,15);
    Home(){
    	frame=new JFrame("Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        
        homepanel = new JPanel(new GridBagLayout());
        homepanel.setBackground(new Color(192, 232, 192));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        inputshp=new JButton("Add");
        inputshp.setPreferredSize(new Dimension(100, 30));
        inputshp.setBackground(Color.WHITE);
        inputshp.addActionListener(this);
        
        editshp=new JButton("Edit");
        editshp.setPreferredSize(new Dimension(100, 30));
        editshp.setBackground(Color.WHITE);
        editshp.addActionListener(this);

        gotomap=new JButton("Go to map");
        gotomap.setPreferredSize(new Dimension(100, 30));
        gotomap.setBackground(Color.WHITE);
        gotomap.addActionListener(this);

        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        homepanel.add(inputshp, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        homepanel.add(editshp, gbc);
        
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        homepanel.add(gotomap, gbc);

        frame.add(homepanel);
        frame.setVisible(true);
        ImageIcon image=new ImageIcon("fire.jpg");
        frame.setIconImage(image.getImage());
    }
    public static void main(String[] args){
        Home h=new Home();
    }
    private void signUp() {
        JOptionPane.showMessageDialog(frame, "Redirecting to Signup Page...");
        new Home();
    }
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == inputshp) {
            check();
        } else if (e.getSource() == editshp) {
            login(); */
    }
}
