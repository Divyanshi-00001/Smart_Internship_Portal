package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import smartinternshipportal.main.StudentModule;

public class StudentSignupUI extends JFrame implements ActionListener {

	JLabel name, email, password, qual, cgpa, resumePath, exsalary; 
    JTextField nameField, emailField, qualField, cgpaField, resumePathField, exsalaryField;
	JPasswordField passField;
    JButton submitBtn, backBtn, clearBtn, exitBtn;

    public StudentSignupUI() {
        setTitle("Applicant Signup");
        setSize(500,520);
        setLocationRelativeTo(null);
        setLayout(null);
        // setLayout(new GridLayout(5,2,10,10));
        
        JLabel title = new JLabel("APPLICANT SIGNUP",JLabel.CENTER); 
        title.setBounds(150,10,200,30);

        name = new JLabel("Name:");
        name.setBounds(50,40,150,30);
        email = new JLabel("Email:");
        email.setBounds(50,90,150,30);
        password = new JLabel("Password:");
        password.setBounds(50,140,150,30);
        qual = new JLabel("Qualification:");
        qual.setBounds(50,190,150,30);
        cgpa = new JLabel("CGPA:");
        cgpa.setBounds(50,240,150,30);
        resumePath = new JLabel("Resume Path:");
        resumePath.setBounds(50,290,150,30);
        exsalary = new JLabel("Expected Salary:");
        exsalary.setBounds(50,340,150,30);
  
        nameField = new JTextField();
        nameField.setBounds(250,40,200,30);
        emailField = new JTextField();
        emailField.setBounds(250,90,200,30);
        passField = new JPasswordField();
        passField.setBounds(250,140,200,30);
        qualField = new JTextField();
        qualField.setBounds(250,190,200,30);
        cgpaField = new JTextField();
        cgpaField.setBounds(250,240,200,30);
        resumePathField = new JTextField();
        resumePathField.setBounds(250,290,200,30);
        exsalaryField = new JTextField();
        exsalaryField.setBounds(250,340,200,30);
        
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(280,390,150,30);
        backBtn = new JButton("Back");
        backBtn.setBounds(50,390,150,30);
        clearBtn = new JButton("Clear");
        clearBtn.setBounds(50,430,150,30);
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(280,430,150,30);
        
        add(title);
        add(name);
        add(email);
        add(password);
        add(qual);
        add(cgpa);
        add(resumePath);
        add(exsalary);
        
        add(nameField);
        add(emailField);
        add(passField);
        add(qualField);
        add(cgpaField);
        add(resumePathField);
        add(exsalaryField);
        
        add(submitBtn);
        add(clearBtn);
        add(backBtn);
        add(exitBtn);

        submitBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        backBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==submitBtn){
        	try {
	        	String name, email, password, qual, resumePath;
	        	double cgpa, exsalary;
	        	name = nameField.getText();
	        	email = emailField.getText();
	        	// password = passField.getText();
	        	password = new String(passField.getPassword());
	        	qual = qualField.getText();
	        	cgpa = Double.parseDouble(cgpaField.getText());
	        	resumePath = resumePathField.getText();
	        	exsalary = Double.parseDouble(exsalaryField.getText());
	        	if(StudentModule.StudentSignUp(name,email,password,qual,cgpa,resumePath,exsalary)) {
	            	JOptionPane.showMessageDialog(this,"Signup Successful");
	            	new StudentLoginUI();
	            	dispose();
	        	}
	        	else {
	        		JOptionPane.showMessageDialog(this,"Invalid Signup Credentials!!");
//	        		new StudentSignupUI();
//	            	dispose();
	        		nameField.setText("");
	                emailField.setText("");
	                passField.setText("");
	                qualField.setText("");
	                cgpaField.setText("");
	                resumePathField.setText("");
	                exsalaryField.setText("");
	        	}
        	} catch(Exception ex) {
        	    JOptionPane.showMessageDialog(this,"Please enter valid Credentials!");
//        	    new StudentSignupUI();
//        	    dispose();
        	    nameField.setText("");
                emailField.setText("");
                passField.setText("");
                qualField.setText("");
                cgpaField.setText("");
                resumePathField.setText("");
                exsalaryField.setText("");
        	}
        }
        else if(e.getSource()==clearBtn){
        	nameField.setText("");
            emailField.setText("");
            passField.setText("");
            qualField.setText("");
            cgpaField.setText("");
            resumePathField.setText("");
            exsalaryField.setText("");
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