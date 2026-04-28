package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.main.StudentModule;
import smartinternshipportal.model.Student;

public class StudentLoginUI extends JFrame implements ActionListener {

    JTextField emailField;
    JPasswordField passField;
    JButton loginBtn, backBtn, clearBtn, exitBtn;

    public StudentLoginUI() {
        setTitle("Student Login");
        setSize(500,350);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("APPLICANT LOGIN", JLabel.CENTER);
        title.setBounds(150,10,200,30);

        JLabel email = new JLabel("Email:");
        email.setBounds(50,80,150,30);
        JLabel pass = new JLabel("Password:");
        pass.setBounds(50,130,150,30);

        emailField = new JTextField();
        emailField.setBounds(250,80,200,30);
        passField = new JPasswordField();
        passField.setBounds(250,130,200,30);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(280,180,150,30);
        backBtn = new JButton("Back");
        backBtn.setBounds(50,180,150,30);
        clearBtn = new JButton("Clear");
        clearBtn.setBounds(50,230,150,30);
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(280,230,150,30);

        add(title); 
        add(email); 
        add(pass);
        add(emailField); 
        add(passField);
        add(loginBtn); 
        add(backBtn); 
        add(clearBtn); 
        add(exitBtn);

        loginBtn.addActionListener(this);
        backBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==loginBtn){
            String email = emailField.getText();
            String password = new String(passField.getPassword());

            Student loggedStudent = StudentModule.studentLogin(email, password);

            if(loggedStudent != null){
                JOptionPane.showMessageDialog(this,"Login Successful!");
                new StudentChoiceUI(loggedStudent);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,"Invalid Credentials!");
                emailField.setText("");
                passField.setText("");
            }
        }

        else if(e.getSource()==clearBtn){
            emailField.setText("");
            passField.setText("");
        }

        else if(e.getSource()==backBtn){
            new MainMenuUI();
            dispose();
        }

        else if(e.getSource()==exitBtn){
            System.exit(0);
        }
    }
}