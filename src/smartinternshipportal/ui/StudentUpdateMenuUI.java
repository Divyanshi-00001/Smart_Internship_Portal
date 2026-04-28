package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.model.Student;

public class StudentUpdateMenuUI extends JFrame implements ActionListener {

    Student student;

    JLabel name, email, pass, qual, cgpa, resume, salary;
    
    JButton nameBtn, emailBtn, passBtn, qualBtn, cgpaBtn, resumeBtn, salaryBtn;
    JButton backBtn, mainBtn, exitBtn;

    public StudentUpdateMenuUI(Student student) {

        this.student = student;

        setTitle("Update Credentials");
        setSize(500,500);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("UPDATE CREDENTIALS", JLabel.CENTER);
        title.setBounds(150,10,200,30);
        
        name = new JLabel("Update Name");
        name.setBounds(50,60,200,30);

        email = new JLabel("Update Email");
        email.setBounds(50,100,200,30);

        pass = new JLabel("Update Password");
        pass.setBounds(50,140,200,30);

        qual = new JLabel("Update Qualification");
        qual.setBounds(50,180,200,30);

        cgpa = new JLabel("Update CGPA");
        cgpa.setBounds(50,220,200,30);

        resume = new JLabel("Update Resume");
        resume.setBounds(50,260,200,30);

        salary = new JLabel("Update Salary");
        salary.setBounds(50,300,200,30);
        

        nameBtn = new JButton("Update Name");
        nameBtn.setBounds(250,60,150,30);

        emailBtn = new JButton("Update Email");
        emailBtn.setBounds(250,100,150,30);

        passBtn = new JButton("Update Password");
        passBtn.setBounds(250,140,150,30);

        qualBtn = new JButton("Update Qualification");
        qualBtn.setBounds(250,180,150,30);

        cgpaBtn = new JButton("Update CGPA");
        cgpaBtn.setBounds(250,220,150,30);

        resumeBtn = new JButton("Update Resume");
        resumeBtn.setBounds(250,260,150,30);

        salaryBtn = new JButton("Update Salary");
        salaryBtn.setBounds(250,300,150,30);

        mainBtn = new JButton("Main Menu");
        mainBtn.setBounds(225,340,200,30);
        
        backBtn = new JButton("Back");
        backBtn.setBounds(225,380,200,30);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(225,420,200,30);

        add(title);
        add(name); add(email); add(pass);
        add(qual); add(cgpa); add(resume); add(salary);
        add(nameBtn); add(emailBtn); add(passBtn);
        add(qualBtn); add(cgpaBtn); add(resumeBtn); add(salaryBtn);
        add(backBtn); add(mainBtn); add(exitBtn);

        nameBtn.addActionListener(this);
        emailBtn.addActionListener(this);
        passBtn.addActionListener(this);
        qualBtn.addActionListener(this);
        cgpaBtn.addActionListener(this);
        resumeBtn.addActionListener(this);
        salaryBtn.addActionListener(this);

        backBtn.addActionListener(this);
        mainBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==nameBtn) {
            new UpdateFieldUI(student,"NAME");
            dispose();
        }

        else if(e.getSource()==emailBtn) {
            new UpdateFieldUI(student,"EMAIL");
            dispose();
        }
        	
        else if(e.getSource()==passBtn) {
            new UpdateFieldUI(student,"PASSWORD");
            dispose();
        }

        else if(e.getSource()==qualBtn) {
            new UpdateFieldUI(student,"QUAL");
            dispose();
        }

        else if(e.getSource()==cgpaBtn) {
            new UpdateFieldUI(student,"CGPA");
            dispose();
        }

        else if(e.getSource()==resumeBtn) {
            new UpdateFieldUI(student,"RESUME");
            dispose();
        }

        else if(e.getSource()==salaryBtn) {
            new UpdateFieldUI(student,"SALARY");
            dispose();
        }

        else if(e.getSource()==backBtn){
            new StudentChoiceUI(student);
            dispose();
        }

        else if(e.getSource()==mainBtn){
            new MainMenuUI();
            dispose();
        }

        else if(e.getSource()==exitBtn){
            System.exit(0);
        }
    }
}