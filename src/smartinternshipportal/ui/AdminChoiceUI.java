package smartinternshipportal.ui;

import javax.swing.*;

import smartinternshipportal.main.MainApp;

import java.awt.*;
import java.awt.event.*;

public class AdminChoiceUI extends JFrame implements ActionListener {

    JButton studentBtn, companyBtn, appBtn, mainBtn, backBtn, exitBtn;

    public AdminChoiceUI() {
        setTitle("Admin Options");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(null);
        // setLayout(new GridLayout(6,1,10,10));

        JLabel title = new JLabel("ADMIN PANEL"); //JLabel.CENTER
        title.setBounds(150,10,200,30);
        
        JLabel student = new JLabel("View Student Details");
        student.setBounds(50,60,150,30);
        JLabel company = new JLabel("View Company Details");
        company.setBounds(50,110,150,30);
        JLabel app = new JLabel("View Applications");
        app.setBounds(50,160,150,30);
        
        studentBtn = new JButton("Students");
        studentBtn.setBounds(250,60,150,30);
        companyBtn = new JButton("Companys");
        companyBtn.setBounds(250,110,150,30);
        appBtn = new JButton("Applications");
        appBtn.setBounds(250,160,150,30);

        mainBtn = new JButton("Main Menu");
        mainBtn.setBounds(225,210,200,30);
        backBtn = new JButton("Back");
        backBtn.setBounds(225,260,200,30);
        exitBtn = new JButton("Exit");
        exitBtn.setBounds(225,310,200,30);

        add(title);
        add(student);
        add(company);
        add(app);
        add(studentBtn);
        add(companyBtn);
        add(appBtn);
        add(mainBtn);
        add(backBtn);
        add(exitBtn);

        studentBtn.addActionListener(this);
        companyBtn.addActionListener(this);
        appBtn.addActionListener(this);
        mainBtn.addActionListener(this);
        backBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void showData(String data, String title) {
        JFrame frame = new JFrame(title);
        frame.setSize(500,400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        JLabel ftitle = new JLabel(title); //JLabel.CENTER
        ftitle.setBounds(150,10,200,30);

        JTextArea area = new JTextArea();
        area.setText(data);
        area.setEditable(false);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setBounds(50,60,400,150);
        
        JButton main = new JButton("Main Menu");
        main.setBounds(225,220,200,30);
        JButton back = new JButton("Back");
        back.setBounds(225,260,200,30);
        JButton exit = new JButton("Exit");
        exit.setBounds(225,300,200,30);
        
        frame.add(ftitle);
        frame.add(scroll);
        frame.add(main);
        frame.add(back);
        frame.add(exit);
        
        main.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainMenuUI();
                frame.dispose();
            }
        });

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	new AdminChoiceUI();
                frame.dispose();   // go back to previous screen
            }
        });

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==studentBtn){
            JOptionPane.showMessageDialog(this,"Opening Students Information");
            String data = "";
            if(MainApp.Snum >= 0) {
                data += "----- STUDENT DETAILS -----\n\n";
                for(int i=0;i<=MainApp.Snum;i++) {
                    if(MainApp.ss[i] != null) {
                        data += "ID: " + MainApp.ss[i].getStudentID() + "\n";
                        data += "Name: " + MainApp.ss[i].getName() + "\n";
                        data += "Email: " + MainApp.ss[i].getEmail() + "\n";
                        data += "Qualification: " + MainApp.ss[i].getQualification() + "\n";
                        data += "CGPA: " + MainApp.ss[i].getCgpa() + "\n";
                        data += "Expected Job Salary: "+MainApp.ss[i].getSalary() + "\n";
                        data += "--------------------------\n\n";
                    }
                }
            } else {
                data = "No Student records found !!";
            }
            showData(data, "Student Details");
            dispose();
        }
        
        else if(e.getSource()==companyBtn){
            JOptionPane.showMessageDialog(this,"Opening Companys Information");
            String data = "";
            if(MainApp.Jnum >= 0) {
                data += "----- COMPANY & JOB DETAILS -----\n\n";
                for(int i=0;i<=MainApp.Jnum;i++) {
                    if(MainApp.jj[i] != null) {
                    	data += "Company Id: " + MainApp.jj[i].getCompanyId() + "\n";
                        data += "Company Name: " + MainApp.jj[i].getCompanyName() + "\n";
                        data += "Company Official Email: " + MainApp.jj[i].getEmail() + "\n";
                        data += "Job ID: " + MainApp.jj[i].getJobId() + "\n";
                        data += "Title: " + MainApp.jj[i].getTitle() + "\n";
                        data += "Location: " + MainApp.jj[i].getLocation() + "\n";
                        data += "Salary: " + MainApp.jj[i].getSalary() + "\n";
                        data += "Highest Qualification Req.: " + MainApp.jj[i].getQualification() + "\n";
                        data += "Min. CGPA: " + MainApp.jj[i].getMinCgpa() + "\n";
                        data += "--------------------------\n\n";
                    }
                }
            } else {
                data = "No company/job records found !!";
            }
            showData(data, "Company Details");
            dispose();
        }
        
        else if(e.getSource()==appBtn){
            JOptionPane.showMessageDialog(this,"Opening Applications");
            String data = "";
            if(MainApp.Anum >= 0) {
                data += "----- APPLICATIONS -----\n\n";
                for(int i=0;i<=MainApp.Anum;i++) {
                    if(MainApp.aa[i] != null) {
                        data += "App ID: " + MainApp.aa[i].getApplicationId() + "\n";
                        data += "Student ID: " + MainApp.aa[i].getStudentId() + "\n";
                        data += "Job ID: " + MainApp.aa[i].getJobId() + "\n";
                        data += "Status: " + MainApp.aa[i].getStatus() + "\n";
                        data += "--------------------------\n\n";
                    }
                }
            } else {
                data = "No Application records found !!";
            }
            showData(data, "Application Details");
            dispose();
        }
        else if(e.getSource()==mainBtn){
            new MainMenuUI();
            dispose();
        }
        else if(e.getSource()==backBtn){
            new AdminLoginUI();
            dispose();
        }
        else if(e.getSource()==exitBtn){
            System.exit(0);
        }
    }
}