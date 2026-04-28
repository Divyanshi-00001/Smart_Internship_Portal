package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenuUI extends JFrame implements ActionListener {

    JButton adminBtn, studentSignup, studentLogin, companySignup, companyLogin, exitBtn;

    public MainMenuUI() {
        setTitle("Internship Portal - Main Menu");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(null);
        // setLayout(new GridLayout(7,1,10,10));
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel title = new JLabel("CHOOSE YOUR PROFILE"); // JLabel.CENTER
        title.setBounds(150,10,200,30);

        JLabel JLabeladminBtn = new JLabel("Admin Login");
        JLabeladminBtn.setBounds(50,40,150,30);
        JLabel JLabelstudentSignup = new JLabel("Applicant Signup");
        JLabelstudentSignup.setBounds(50,90,150,30);
        JLabel JLabelstudentLogin = new JLabel("Applicant Login");
        JLabelstudentLogin.setBounds(50,140,150,30);
        JLabel JLabelcompanySignup = new JLabel("Company Signup");
        JLabelcompanySignup.setBounds(50,190,150,30);
        JLabel JLabelcompanyLogin = new JLabel("Company Login");
        JLabelcompanyLogin.setBounds(50,240,150,30);
        JLabel JLabelexitBtn = new JLabel("Exit");
        JLabelexitBtn.setBounds(50,290,150,30);
        
        adminBtn = new JButton("Login");
        adminBtn.setBounds(250,40,150,30);
        studentSignup = new JButton("Signup");
        studentSignup.setBounds(250,90,150,30);
        studentLogin = new JButton("Login");
        studentLogin.setBounds(250,140,150,30);
        companySignup = new JButton("Signup");
        companySignup.setBounds(250,190,150,30);
        companyLogin = new JButton("Login");
        companyLogin.setBounds(250,240,150,30);
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(250,290,150,30);

        add(title);
        add(JLabeladminBtn);
        add(JLabelstudentSignup);
        add(JLabelstudentLogin);
        add(JLabelcompanySignup);
        add(JLabelcompanyLogin);
        add(JLabelexitBtn);
        add(adminBtn);
        add(studentSignup);
        add(studentLogin);
        add(companySignup);
        add(companyLogin);
        add(exitBtn);

        adminBtn.addActionListener(this);
        studentSignup.addActionListener(this);
        studentLogin.addActionListener(this);
        companySignup.addActionListener(this);
        companyLogin.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==adminBtn){
            new AdminLoginUI();
            dispose();
        }
        else if(e.getSource()==studentSignup){
            new StudentSignupUI();
            dispose();
        }
        else if(e.getSource()==studentLogin){
            new StudentLoginUI();
            dispose();
        }
        else if(e.getSource()==companySignup){
            new CompanySignupUI();
            dispose();
        }
        else if(e.getSource()==companyLogin){
            new CompanyLoginUI();
            dispose();
        }
        else if(e.getSource()==exitBtn){
            System.exit(0);
        }
    }
}