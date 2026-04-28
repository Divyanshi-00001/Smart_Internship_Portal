package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.model.Job;

public class CompanyChoiceUI extends JFrame implements ActionListener {

	JLabel view, recommend, update; 
	JButton viewBtn, recommendBtn, updateBtn, logout, main, exit;
    Job job;

    public CompanyChoiceUI(Job job){
        this.job = job;

        setTitle("Company Dashboard");
        setSize(500,360);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel title = new JLabel("COMPANY PANEL", JLabel.CENTER);
        title.setBounds(150,10,200,30);
        
        view = new JLabel("View Job");
        view.setBounds(50,60,200,30);

        recommend = new JLabel("Recommend Applicants");
        recommend.setBounds(50,100,200,30);

        update = new JLabel("Update Job");
        update.setBounds(50,140,200,30);

        viewBtn = new JButton("View");
        viewBtn.setBounds(250,60,150,30);

        recommendBtn = new JButton("Recommendations");
        recommendBtn.setBounds(250,100,150,30);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(250,140,150,30);

        logout = new JButton("Logout");
        logout.setBounds(225,180,200,30);

        main = new JButton("Main Menu");
        main.setBounds(225,220,200,30);

        exit = new JButton("Exit");
        exit.setBounds(225,260,200,30);

        add(title);
        add(view); add(recommend); add(update);
        add(viewBtn); add(recommendBtn); add(updateBtn);
        add(logout); add(main); add(exit);

        viewBtn.addActionListener(this);
        recommendBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        logout.addActionListener(this);
        main.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==viewBtn){
            new CompanyDashboardUI(job,"PROFILE");
            dispose();
        }

        else if(e.getSource()==recommendBtn){
            new CompanyDashboardUI(job,"RECOMMEND");
            dispose();
        }

        else if(e.getSource()==updateBtn){
            new CompanyDashboardUI(job,"UPDATE");
            dispose();
        }

        else if(e.getSource()==logout){
            new CompanyLoginUI();
            dispose();
        }

        else if(e.getSource()==main){
            new MainMenuUI();
            dispose();
        }

        else if(e.getSource()==exit){
            System.exit(0);
        }
    }
}