package MyMainPackage;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Viewmap extends JFrame implements ActionListener {
    private JLabel imagelabel, head;
    private JPanel panel;
    private JButton gf, ff, sf, tf, fourf, backButton;
    private ImageIcon imageGround, imageFirst, imageSecond, imageThird, imageFourth;
    private double scale = 1.0;
    String username;

    public Viewmap() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1080, 530);
        setTitle("Map");
        setLayout(null);
        setLocationRelativeTo(null);

        imageGround = new ImageIcon(ClassLoader.getSystemResource("images/gf_.jpg"));
        imageFirst = new ImageIcon(ClassLoader.getSystemResource("images/ff_.jpg"));
        imageSecond = new ImageIcon(ClassLoader.getSystemResource("images/sf_.jpg"));
        imageThird = new ImageIcon(ClassLoader.getSystemResource("images/tf_.jpg"));
        imageFourth = new ImageIcon(ClassLoader.getSystemResource("images/4f_.jpg"));

        head=new JLabel("MALL MAP");
        head.setFont(new Font("Berlin Sans FB",Font.PLAIN,32));
        head.setBounds(430, 10, 160, 60);

        gf = createButton("Ground Floor");
        gf.setBounds(120, 83, 143, 37);
        ff = createButton("First Floor");
        ff.setBounds(285, 83, 143, 37);
        sf = createButton("Second Floor");
        sf.setBounds(450, 83, 143, 37);
        tf = createButton("Third Floor");
        tf.setBounds(615, 83, 143, 37);
        fourf = createButton("Fourth Floor");
        fourf.setBounds(780, 83, 143, 37);

        gf.addActionListener(this);
        ff.addActionListener(this);
        sf.addActionListener(this);
        tf.addActionListener(this);
        fourf.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(10, 10, 1040, 470);
        Border border = BorderFactory.createLineBorder(Color.BLACK); 
        panel.setBorder(border);
        panel.setLayout(null);
        panel.add(head);
        panel.add(gf);
        panel.add(ff);
        panel.add(sf);
        panel.add(tf);
        panel.add(fourf);

        imagelabel = new JLabel();
        imagelabel.setBounds(15, 146, 1010, 300);
        imagelabel.setHorizontalAlignment(JLabel.CENTER);
        imagelabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(imagelabel);
        displayImage(imageGround);
        add(panel);
        
        ImageIcon back = new ImageIcon(ClassLoader.getSystemResource("images/back2.jpg"));
	    backButton = new JButton(back);
	    backButton.setSize(28,28);
	    backButton.setOpaque(false);
	    backButton.addActionListener(this);
	    panel.add(backButton);

        setVisible(true);
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/fire.jpg"));
        setIconImage(icon.getImage());
    }

    Viewmap(String username){
    	this();
    	this.username=username;
    }
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Berlin Sans FB", Font.PLAIN, 17));
        button.setBackground(new Color(75,75,75));
        button.setForeground(Color.WHITE);
        return button;
    }

    public static void main(String[] args) {
        Viewmap v=new Viewmap();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gf) {
            displayImage(imageGround);
        } else if (e.getSource() == ff) {
            displayImage(imageFirst);
        } else if (e.getSource() == sf) {
            displayImage(imageSecond);
        } else if (e.getSource() == tf) {
            displayImage(imageThird);
        } else if (e.getSource() == fourf) {
            displayImage(imageFourth);
        } else if (e.getSource() == backButton) {
            setVisible(false);
            new Home(username);
        }
    }

    private ImageIcon getCurrentImage() {
        Icon icon = imagelabel.getIcon();
        if (icon != null && icon instanceof ImageIcon) {
            return (ImageIcon) icon;
        }
        return null;
    }

    private void displayImage(ImageIcon imageIcon) {
        if (imageIcon != null) {
            // Resize image to fit the available space
            int newWidth = (int) (imageIcon.getIconWidth() * scale);
            int newHeight = (int) (imageIcon.getIconHeight() * scale);
            Image scaledImage = imageIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            imagelabel.setIcon(new ImageIcon(scaledImage));
        }
    }
}
