package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.model.Student;

public class StudentChoiceUI extends JFrame implements ActionListener {

	JLabel profile, recommend, apply, update, logout, main, exit;
    JButton profileBtn, recommendBtn, applyBtn, updateBtn, logoutBtn, mainBtn, exitBtn;
    Student student;

    public StudentChoiceUI(Student student) {
        this.student = student;

        setTitle("Student Dashboard");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("STUDENT PANEL", JLabel.CENTER);
        title.setBounds(150,10,200,30);
   
        profile = new JLabel("View Profile");
        profile.setBounds(50,60,200,30);
        recommend = new JLabel("Job Recommendations");
        recommend.setBounds(50,100,200,30);
        apply = new JLabel("Apply for Job");
        apply.setBounds(50,140,200,30);
        update = new JLabel("Update Profile");
        update.setBounds(50,180,200,30);
        
        profileBtn = new JButton("View");
        profileBtn.setBounds(250,60,150,30);
        recommendBtn = new JButton("Recommendations");
        recommendBtn.setBounds(250,100,150,30);
        applyBtn = new JButton("Apply");
        applyBtn.setBounds(250,140,150,30);
        updateBtn = new JButton("Update");
        updateBtn.setBounds(250,180,150,30);

        logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(225,220,200,30);
        mainBtn = new JButton("Main Menu");
        mainBtn.setBounds(225,260,200,30);
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(225,300,200,30);

        add(title);
        add(profile); add(recommend); add(apply);
        add(update);
        add(profileBtn); add(recommendBtn); add(applyBtn);
        add(updateBtn); add(logoutBtn);
        add(mainBtn); add(exitBtn);

        profileBtn.addActionListener(this);
        recommendBtn.addActionListener(this);
        applyBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        mainBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==profileBtn){
            new StudentDashboardUI(student, "PROFILE");
            dispose();
        }

        else if(e.getSource()==recommendBtn){
            new StudentDashboardUI(student, "RECOMMEND");
            dispose();
        }

        else if(e.getSource()==applyBtn){
            new StudentDashboardUI(student, "APPLY");
            dispose();
        }

        else if(e.getSource()==updateBtn){
        	new StudentUpdateMenuUI(student);
            dispose();
        }

        else if(e.getSource()==logoutBtn){
            JOptionPane.showMessageDialog(this,"Logged out!");
            new StudentLoginUI();
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