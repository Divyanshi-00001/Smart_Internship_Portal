package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.model.Student;
import smartinternshipportal.main.*;
import smartinternshipportal.main.ApplicationModule;
import smartinternshipportal.dao.ApplicationDAO;

public class StudentDashboardUI extends JFrame implements ActionListener {

    Student student;
    String type;

    JButton backBtn, mainBtn, exitBtn;
    JButton jobRecBtn, skillRecBtn, applyBtn;

    JTextField sidField, jidField;

    public StudentDashboardUI(Student student, String type) {
        this.student = student;
        this.type = type;

        if(type.equals("PROFILE")) {
        	
        	setTitle(type + " PANEL");
            setSize(500,480);
            setLocationRelativeTo(null);
            setLayout(null);

            JLabel title = new JLabel(type + " SECTION");
            title.setBounds(150,10,250,30);
            add(title);

            JLabel id = new JLabel("Student ID:");
            id.setBounds(50,60,200,30);
            JButton idVal = new JButton(student.getStudentID());
            idVal.setBounds(250,60,150,30);

            JLabel name = new JLabel("Name:");
            name.setBounds(50,100,200,30);
            JButton nameVal = new JButton(student.getName());
            nameVal.setBounds(250,100,150,30);

            JLabel email = new JLabel("Email:");
            email.setBounds(50,140,200,30);
            JButton emailVal = new JButton(student.getEmail());
            emailVal.setBounds(250,140,150,30);

            JLabel qual = new JLabel("Qualification:");
            qual.setBounds(50,180,200,30);
            JButton qualVal = new JButton(student.getQualification());
            qualVal.setBounds(250,180,150,30);

            JLabel cgpa = new JLabel("CGPA:");
            cgpa.setBounds(50,220,200,30);
            JButton cgpaVal = new JButton(String.valueOf(student.getCgpa()));
            cgpaVal.setBounds(250,220,150,30);

            JLabel sal = new JLabel("Expected Salary:");
            sal.setBounds(50,260,200,30);
            JButton salVal = new JButton(String.valueOf(student.getSalary()));
            salVal.setBounds(250,260,150,30);

            add(id); add(idVal);
            add(name); add(nameVal);
            add(email); add(emailVal);
            add(qual); add(qualVal);
            add(cgpa); add(cgpaVal);
            add(sal); add(salVal);
            
            mainBtn = new JButton("Main Menu");
            mainBtn.setBounds(225,300,200,30);
            backBtn = new JButton("Back");
            backBtn.setBounds(225,340,200,30);
            exitBtn = new JButton("Exit");
            exitBtn.setBounds(225,380,200,30);

            add(backBtn);
            add(mainBtn);
            add(exitBtn);

            backBtn.addActionListener(this);
            mainBtn.addActionListener(this);
            exitBtn.addActionListener(this);
        }

        else if(type.equals("RECOMMEND")) {
        	
        	setTitle(type + " PANEL");
            setSize(500,400);
            setLocationRelativeTo(null);
            setLayout(null);

            JLabel title = new JLabel(type + " SECTION");
            title.setBounds(150,10,250,30);
            add(title);

            JLabel job = new JLabel("Recommendation of Jobs");
            job.setBounds(50,80,200,30);

            JLabel skill = new JLabel("Recommendation of Skills");
            skill.setBounds(50,140,200,30);

            jobRecBtn = new JButton("Jobs");
            jobRecBtn.setBounds(250,80,200,30);

            skillRecBtn = new JButton("Skills");
            skillRecBtn.setBounds(250,140,200,30);

            add(job); add(skill);
            add(jobRecBtn); add(skillRecBtn);

            jobRecBtn.addActionListener(this);
            skillRecBtn.addActionListener(this);
            
            mainBtn = new JButton("Main Menu");
            mainBtn.setBounds(225,220,200,30);
            backBtn = new JButton("Back");
            backBtn.setBounds(225,260,200,30);
            exitBtn = new JButton("Exit");
            exitBtn.setBounds(225,300,200,30);

            add(backBtn);
            add(mainBtn);
            add(exitBtn);

            backBtn.addActionListener(this);
            mainBtn.addActionListener(this);
            exitBtn.addActionListener(this);
        }

        else if(type.equals("APPLY")) {
        	
        	setTitle(type + " PANEL");
            setSize(500,400);
            setLocationRelativeTo(null);
            setLayout(null);

            JLabel title = new JLabel(type + " SECTION");
            title.setBounds(150,10,250,30);
            add(title);

            JLabel sid = new JLabel("Student ID:");
            sid.setBounds(50,80,150,30);

            JLabel jid = new JLabel("Job ID:");
            jid.setBounds(50,130,150,30);

            sidField = new JTextField();
            sidField.setBounds(250,80,150,30);

            jidField = new JTextField();
            jidField.setBounds(250,130,150,30);

            applyBtn = new JButton("Apply");
            applyBtn.setBounds(225,180,200,30);

            add(sid); add(jid);
            add(sidField); add(jidField);
            add(applyBtn);

            applyBtn.addActionListener(this);
            
            mainBtn = new JButton("Main Menu");
            mainBtn.setBounds(225,220,200,30);
            backBtn = new JButton("Back");
            backBtn.setBounds(225,260,200,30);
            exitBtn = new JButton("Exit");
            exitBtn.setBounds(225,300,200,30);

            add(backBtn);
            add(mainBtn);
            add(exitBtn);

            backBtn.addActionListener(this);
            mainBtn.addActionListener(this);
            exitBtn.addActionListener(this);
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==jobRecBtn){
            String[] results = StudentModule.RecommendJobsUI(student.getStudentID());
            showTextFrame(results[0], "Recommended Jobs");
            dispose();
        }

        else if(e.getSource()==skillRecBtn){
            String[] results = StudentModule.RecommendJobsUI(student.getStudentID());
            showTextFrame(results[1], "Recommended Skills");
            dispose();
        }

        else if(e.getSource()==applyBtn){

        	try {
	            String sid = sidField.getText();
	            String jid = jidField.getText();
	
	            boolean studentFound = false;
	            boolean jobFound = false;
	            String link = "";
	
	            for(int i=0;i<=MainApp.Snum;i++){
	                if(MainApp.ss[i]!=null && sid.equals(MainApp.ss[i].getStudentID())){
	                    studentFound = true;
	                    break;
	                }
	            }
	
	            for(int i=0;i<=MainApp.Jnum;i++){
	                if(MainApp.jj[i]!=null && jid.equals(MainApp.jj[i].getJobId())){
	                    jobFound = true;
	                    link = MainApp.jj[i].getWebLink();
	                    break;
	                }
	            }
	
	            if(!studentFound || !jobFound){
	                JOptionPane.showMessageDialog(this,"Invalid Credentials!");
	                return;
	            }
	
	            MainApp.Anum++;
	            MainApp.aa[MainApp.Anum] = new smartinternshipportal.model.Application(sid,jid);
	
	            ApplicationDAO.insertApplication(MainApp.aa[MainApp.Anum]);
	            showApplySuccess(link, MainApp.aa[MainApp.Anum].getApplicationId());
	            dispose();
        	}
        	catch (Exception ex) {
        		ex.printStackTrace();
        	}
        }

        // ===== NAVIGATION =====
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

    public void showTextFrame(String data, String title){

        JFrame f = new JFrame(title);
        f.setSize(500,400);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        
        JLabel Stitle = new JLabel(type, JLabel.CENTER);
        Stitle.setBounds(150,10,200,30);

        JTextArea area = new JTextArea(data);
        area.setEditable(false);

        JScrollPane sp = new JScrollPane(area);
        sp.setBounds(50,50,400,150);

        JButton main = new JButton("Main Menu");
        main.setBounds(225,220,200,30);
        JButton back = new JButton("Back");
        back.setBounds(225,260,200,30);
        JButton exit = new JButton("Exit");
        exit.setBounds(225,300,200,30);


        f.add(Stitle); f.add(sp); f.add(back); f.add(main); f.add(exit);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new StudentDashboardUI(student,type);
                f.dispose();
            }
        });

        main.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new MainMenuUI();
                f.dispose();
            }
        });

        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        f.setVisible(true);
    }

    public void showApplySuccess(String link, String appId){

        JFrame f = new JFrame("Application Success");
        f.setSize(500,400);
        f.setLocationRelativeTo(null);
        f.setLayout(null);

        JLabel msg = new JLabel("Application Submitted Successfully!");
        msg.setBounds(150,10,250,30);

        JLabel linkL = new JLabel("Apply Link:");
        linkL.setBounds(50,80,200,30);
        JButton linkVal = new JButton(link);
        linkVal.setBounds(250,80,200,30);
        JLabel idL = new JLabel("Application ID:");
        idL.setBounds(50,140,200,30);
        JButton idVal = new JButton(appId);
        idVal.setBounds(250,140,200,30);

        JButton main = new JButton("Main Menu");
        main.setBounds(225,220,200,30);
        JButton back = new JButton("Back");
        back.setBounds(225,260,200,30);
        JButton exit = new JButton("Exit");
        exit.setBounds(225,300,200,30);

        f.add(msg);
        f.add(linkL); f.add(linkVal);
        f.add(idL); f.add(idVal);
        f.add(back); f.add(main); f.add(exit);

        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new StudentDashboardUI(student,type);
                f.dispose();
            }
        });

        main.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new MainMenuUI();
                f.dispose();
            }
        });

        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        f.setVisible(true);
    }
}
