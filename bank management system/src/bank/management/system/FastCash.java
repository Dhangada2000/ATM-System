package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class FastCash extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton withdrawal, exit, one, two, three, four;
    String pinnumber;
    
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Choose amount you want to fast cash");
        text.setBounds(195, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        one = new JButton("Rs 10000");
        one.setBounds(200, 350, 100, 30);
        one.addActionListener(this);
        image.add(one);
        
        two = new JButton("Rs 20000");
        two.setBounds(200, 400, 100, 30);
        two.addActionListener(this);
        image.add(two);
        
        three = new JButton("Rs 50000");
        three.setBounds(350, 350, 100, 30);
        three.addActionListener(this);
        image.add(three);
        
        four = new JButton("Rs 100000");
        four.setBounds(350, 400, 100, 30);
        four.addActionListener(this);
        image.add(four);
  
        exit = new JButton("Back");
        exit.setBounds(200, 500, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(300, 0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); // Ts 500
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));  
                    }
                }
                    
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Fast Cash', '"+amount+"')";
                c.s.execute(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            } catch (Exception e) {
                    System.out.println(e);
            }
        }
    }
       
    
    public static void main (String args[]) {
        new FastCash("");
    }
    
}
