import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculatorswing implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numbers=new JButton[10];
    JButton[] functions=new JButton[8];
    JButton add,sub,mul,div,point,eq,del,clear;
    JPanel panel;
    Font f=new Font("DejaVu Serif",Font.BOLD,15);
    double num1=0, num2=0, result=0;
    char operator;

    Calculatorswing(){
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,550);
        frame.setLayout(null);

        textfield=new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(f);
        textfield.setEditable(false);

        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        point=new JButton(".");
        eq=new JButton("=");
        del=new JButton("Delete");
        clear=new JButton("Clear");

        functions[0]=add;
        functions[1]=sub;
        functions[2]=mul;
        functions[3]=div;
        functions[4]=point;
        functions[5]=eq;
        functions[6]=del;
        functions[7]=clear;

        for(int i=0; i<8; i++){
            functions[i].addActionListener(this);
            functions[i].setFont(f);
            functions[i].setFocusable(false);
        }
        for(int i=0; i<10; i++){
            numbers[i]=new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(f);
            numbers[i].setFocusable(false);
        }
        del.setBounds(150,430,100,50);
        clear.setBounds(250,430,100,50);
        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(add);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(sub);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mul);
        panel.add(point);
        panel.add(numbers[0]);
        panel.add(eq);
        panel.add(div);

        frame.add(panel);
        frame.add(del);
        frame.add(clear);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        Calculatorswing c=new Calculatorswing();
    }

    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10; i++){
            if(e.getSource()==numbers[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==point){
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource()==add){
            num1= Double.parseDouble(textfield.getText());
            operator='+';
            textfield.setText("");
        }
        if(e.getSource()==sub){
            num1= Double.parseDouble(textfield.getText());
            operator='-';
            textfield.setText("");
        }
        if(e.getSource()==mul){
            num1= Double.parseDouble(textfield.getText());
            operator='*';
            textfield.setText("");
        }
        if(e.getSource()==div){
            num1= Double.parseDouble(textfield.getText());
            operator='/';
            textfield.setText("");
        }
        if(e.getSource()==eq){
            num2= Double.parseDouble(textfield.getText());
            switch(operator){
                case '+':
                result=num1+num2;
                break;
                case '-':
                result=num1-num2;
                break;
                case '*':
                result=num1*num2;
                break;
                case '/':
                result=num1/num2;
                break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource()==clear){
            textfield.setText("");
        }
        if(e.getSource()==del){
            String string=textfield.getText();
            textfield.setText("");
            for(int i=0; i<string.length()-1; i++){
                textfield.setText(textfield.getText()+string.charAt(i));
            }
        }
    }
}
