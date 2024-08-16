package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    JComboBox religion, category, income, EduQual, occupation;
    JTextField panTextField, aadharTextField; 
    JButton next;
    JRadioButton citizen_yes, citizen_no, exisitiingAccount_yes, exisitiingAccount_no;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raieway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raieway", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindi", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
               
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("Raieway", Font.BOLD, 20));
        fname.setBounds(100, 185, 200, 30);
        add(fname);
        
        String valCategory[] = {"ST", "SC", "OBC", "NT", "Other"};
        category = new JComboBox(valCategory);
        category.setBounds(300, 185, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("Raieway", Font.BOLD, 20));
        dob.setBounds(100, 230, 200, 30);
        add(dob);
        
        String valIncome[] = {"Below 1 Lac", "1 to 4 Lac", "More then 5 Lac"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 230, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Raieway", Font.BOLD, 20));
        gender.setBounds(100, 275, 200, 30);
        add(gender);
        
        String valEduQual[] = {"Below 10th", "12th", "Graduate", "Post-Graduate", "PHD"};
        EduQual = new JComboBox(valEduQual);
        EduQual.setBounds(300, 275, 400, 30);
        EduQual.setBackground(Color.WHITE);
        add(EduQual);
        
        JLabel email = new JLabel("Occupation:");
        email.setFont(new Font("Raieway", Font.BOLD, 20));
        email.setBounds(100, 320, 200, 30);
        add(email);
        
        String valOccu[] = {"Navy", "Army", "Goverment officer", "Other"};
        occupation = new JComboBox(valOccu);
        occupation.setBounds(300, 320, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        JLabel marital = new JLabel("PAN Number:");
        marital.setFont(new Font("Raieway", Font.BOLD, 20));
        marital.setBounds(100, 365, 200, 30);
        add(marital);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Taieway", Font.BOLD, 14));
        panTextField.setBounds(300, 365, 400, 30);
        add(panTextField);
        
        JLabel address = new JLabel("Aadhar Number:");
        address.setFont(new Font("Raieway", Font.BOLD, 20));
        address.setBounds(100, 410, 200, 30);
        add(address);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Taieway", Font.BOLD, 14));
        aadharTextField.setBounds(300, 410, 400, 30);
        add(aadharTextField);
        
        JLabel citizen = new JLabel("Senior Citizen:");
        citizen.setFont(new Font("Raieway", Font.BOLD, 20));
        citizen.setBounds(100, 455, 200, 30);
        add(citizen);
        
        citizen_yes = new JRadioButton("Yes");
        citizen_yes.setBounds(300, 455, 60, 30);
        citizen_yes.setBackground(Color.WHITE);
        add(citizen_yes);
        
        citizen_no = new JRadioButton("No");
        citizen_no.setBounds(450, 455, 120, 30);
        citizen_no.setBackground(Color.WHITE);
        add(citizen_no);
        
        JLabel exisitiingAccount = new JLabel("Exisitiing Account:");
        exisitiingAccount.setFont(new Font("Raieway", Font.BOLD, 20));
        exisitiingAccount.setBounds(100, 500, 200, 30);
        add(exisitiingAccount);
        
        exisitiingAccount_yes = new JRadioButton("Yes");
        exisitiingAccount_yes.setBounds(300, 500, 60, 30);
        exisitiingAccount_yes.setBackground(Color.WHITE);
        add(exisitiingAccount_yes);
        
        exisitiingAccount_no = new JRadioButton("No");
        exisitiingAccount_no.setBounds(450, 500, 120, 30);
        exisitiingAccount_no.setBackground(Color.WHITE);
        add(exisitiingAccount_no);
      
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font ("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seduQual = (String) EduQual.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String pan = panTextField.getText();
        String aadha = aadharTextField.getText();

        String citizen = null;
        if (citizen_yes.isSelected()) {
            citizen = "Yes";
        } else if (citizen_no.isSelected()) {
            citizen = "No";
        }
         String exisitiingAccount = null;
        if (exisitiingAccount_yes.isSelected()) {
            exisitiingAccount = "Yes";
        } else if (exisitiingAccount_no.isSelected()) {
            exisitiingAccount = "No";
        } 
        
        try {
            if (religion.equals("")) {
                JOptionPane.showMessageDialog(null, "Religion is Required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seduQual+"', '"+soccupation+"', '"+pan+"', '"+aadha+"', '"+citizen+"', '"+exisitiingAccount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }  
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
}
