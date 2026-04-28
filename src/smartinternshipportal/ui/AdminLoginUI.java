package smartinternshipportal.ui;

import javax.swing.*;

import smartinternshipportal.model.Admin;

import java.awt.*;
import java.awt.event.*;

public class AdminLoginUI extends JFrame implements ActionListener {

    JTextField idField, userField;
    JPasswordField passField;
    JButton loginBtn, backBtn, clearBtn, exitBtn;

    public AdminLoginUI() {
        setTitle("Admin Login");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(null);
        //setLayout(new GridLayout(6,2,10,10));

        JLabel title = new JLabel("Authorized Authentication Login"); // JLabel.CENTER
        title.setBounds(150,10,200,30);

        JLabel UserId = new JLabel("User ID:");
        UserId.setBounds(50,60,150,30);
        JLabel Username = new JLabel("Username:");
        Username.setBounds(50,110,150,30);
        JLabel Password = new JLabel("Password:");
        Password.setBounds(50,160,150,30);
        
        idField = new JTextField();
        idField.setBounds(250,60,200,30);
        
        userField = new JTextField();
        userField.setBounds(250,110,200,30);

        passField = new JPasswordField();
        passField.setBounds(250,160,200,30);
        
        loginBtn = new JButton("Submit");
        loginBtn.setBounds(250,210,150,30);
        backBtn = new JButton("Back");
        backBtn.setBounds(50,260,150,30);
        clearBtn = new JButton("Clear");
        clearBtn.setBounds(50,210,150,30);
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(250,260,150,30);
        
        add(title);
        add(UserId);
        add(Username);
        add(Password);
        add(idField);
        add(userField);
        add(passField);

        add(loginBtn);
        add(clearBtn);
        add(backBtn);
        add(exitBtn);

        loginBtn.addActionListener(this);
        backBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==loginBtn){
        	try {
        	    int uid = Integer.parseInt(idField.getText());
        	    String name = userField.getText();
        	    // String password = passField.getText();
        	    String password = new String(passField.getPassword());
        	    
        	    Admin adm = new Admin(uid, name, password);

        	    if(adm.Authentication()) {
        	        JOptionPane.showMessageDialog(this,"Login Successful");
        	        new AdminChoiceUI();
        	        dispose();
        	    } else {
        	        JOptionPane.showMessageDialog(this,"Invalid Credentials!");
//        	        new AdminLoginUI();
//        	        dispose();
        	        idField.setText("");
                    userField.setText("");
                    passField.setText("");
        	    }

        	} catch(Exception ex) {
        	    JOptionPane.showMessageDialog(this,"Please enter valid ID!");
//        	    new AdminLoginUI();
//        	    dispose();
        	    idField.setText("");
                userField.setText("");
                passField.setText("");
        	}
        }
        else if(e.getSource()==backBtn){
            new MainMenuUI();
            dispose();
        }
        else if(e.getSource()==clearBtn){
        	idField.setText("");
            userField.setText("");
            passField.setText("");
        }
        else if(e.getSource()==exitBtn){
            System.exit(0);
        }
    }
}