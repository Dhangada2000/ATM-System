package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField repin;
    JTextField pin;
    JButton back, change;
    String pinnumber;
    
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 300, 400, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        JLabel npin = new JLabel("New PIN:");
        npin.setBounds(195, 400, 400, 20);
        npin.setForeground(Color.WHITE);
        npin.setFont(new Font("System", Font.BOLD, 16));
        image.add(npin);
        
        pin = new JTextField();
        pin.setBounds(350, 400, 120, 20);
        pin.setForeground(Color.BLACK);
        pin.setFont(new Font("System", Font.BOLD, 16));
        image.add(pin);
        
        JLabel rpin = new JLabel("Re-Enter New PIN:");
        rpin.setBounds(195, 450, 400, 20);
        rpin.setForeground(Color.WHITE);
        rpin.setFont(new Font("System", Font.BOLD, 16));
        image.add(rpin);
        
        repin = new JPasswordField();
        repin.setForeground(Color.BLACK);
        repin.setBounds(350, 450, 120, 20);
        repin.setFont(new Font("System", Font.BOLD, 16));
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(350, 500, 100, 30);
        change.addActionListener(this);
        image.add(change);
  
        back = new JButton("BACK");
        back.setBounds(195, 500, 100, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(300, 0);
        //setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if (npin.equals("")) {
                    JOptionPane.showConfirmDialog(null, "Please enter PIN");
                    return;
                }
                
                if (rpin.equals("")) {
                    JOptionPane.showConfirmDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
       
    
    public static void main (String args[]) {
        new PinChange("").setVisible(true);
    }
    
}
