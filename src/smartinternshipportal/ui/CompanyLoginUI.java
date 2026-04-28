package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.main.CompanyModule;
import smartinternshipportal.model.Job;

public class CompanyLoginUI extends JFrame implements ActionListener {

    JTextField emailField;
    JPasswordField passField;
    JButton login, back, clear, exit;

    public CompanyLoginUI(){

        setTitle("Company Login");
        setSize(500,350);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel title = new JLabel("COMPANY LOGIN", JLabel.CENTER);
        title.setBounds(150,10,200,30);

        JLabel email = new JLabel("Email:");
        email.setBounds(50,80,150,30);

        JLabel pass = new JLabel("Password:");
        pass.setBounds(50,130,150,30);

        emailField = new JTextField();
        emailField.setBounds(250,80,200,30);

        passField = new JPasswordField();
        passField.setBounds(250,130,200,30);

        login = new JButton("Login");
        login.setBounds(280,180,150,30);

        back = new JButton("Back");
        back.setBounds(50,180,150,30);

        clear = new JButton("Clear");
        clear.setBounds(50,230,150,30);

        exit = new JButton("Exit");
        exit.setBounds(280,230,150,30);

        add(title);
        add(email); add(pass); add(emailField); add(passField);
        add(login); add(back); add(clear); add(exit);

        login.addActionListener(this);
        back.addActionListener(this);
        clear.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==login){
            String email = emailField.getText();
            String pass = new String(passField.getPassword());

            Job job = CompanyModule.companyLogin(email, pass);

            if(job!=null){
                JOptionPane.showMessageDialog(this,"Login Successful!");
                new CompanyChoiceUI(job);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid Credentials!");
            }
        }

        else if(e.getSource()==clear){
            emailField.setText(""); passField.setText("");
        }

        else if(e.getSource()==back){
            new MainMenuUI();
            dispose();
        }

        else if(e.getSource()==exit){
            System.exit(0);
        }
    }
}