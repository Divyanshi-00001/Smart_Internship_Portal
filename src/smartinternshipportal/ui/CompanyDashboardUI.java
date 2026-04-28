package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.model.Job;
import smartinternshipportal.main.CompanyModule;

public class CompanyDashboardUI extends JFrame {

    Job job;
    JButton back, main, exit;
   

    // ===== CONSTRUCTOR =====
    public CompanyDashboardUI(Job job, String type){
        this.job = job;
        JLabel title;

        // ===== VIEW JOB =====
        if(type.equals("PROFILE")){
        	
        	setTitle(type + " PANEL");
            setSize(500,600);
            setLocationRelativeTo(null);
            setLayout(null);

            title = new JLabel(type + " SECTION", JLabel.CENTER);
            title.setBounds(150,10,200,30);
            add(title);
        	
        	JLabel id = new JLabel("Company ID:");
            id.setBounds(50,60,200,30);
            JButton idVal = new JButton(job.getCompanyId());
            idVal.setBounds(250,60,150,30);

            JLabel name = new JLabel("Company Name:");
            name.setBounds(50,100,200,30);
            JButton nameVal = new JButton(job.getCompanyName());
            nameVal.setBounds(250,100,150,30);

            JLabel email = new JLabel("Email:");
            email.setBounds(50,140,200,30);
            JButton emailVal = new JButton(job.getEmail());
            emailVal.setBounds(250,140,150,30);

            JLabel id1 = new JLabel("Job ID:");
            id1.setBounds(50,180,200,30);
            JButton id1Val = new JButton(job.getJobId());
            id1Val.setBounds(250,180,150,30);
            
            JLabel t = new JLabel("Title:");
            t.setBounds(50,220,200,30);
            JButton tVal = new JButton(job.getTitle());
            tVal.setBounds(250,220,150,30);

            JLabel loc = new JLabel("Location:");
            loc.setBounds(50,260,200,30);
            JButton locVal = new JButton(job.getLocation());
            locVal.setBounds(250,260,150,30);

            JLabel sal = new JLabel("Salary:");
            sal.setBounds(50,300,200,30);
            JButton salVal = new JButton(String.valueOf(job.getSalary()));
            salVal.setBounds(250,300,150,30);

            JLabel cgpa = new JLabel("CGPA:");
            cgpa.setBounds(50,340,200,30);
            JButton cgpaVal = new JButton(String.valueOf(job.getMinCgpa()));
            cgpaVal.setBounds(250,340,150,30);
            
            JLabel link = new JLabel("Web Link:");
            link.setBounds(50,380,200,30);
            JButton linkVal = new JButton(String.valueOf(job.getWebLink()));
            linkVal.setBounds(250,380,150,30);


            add(id); add(idVal);
            add(name); add(nameVal);
            add(email); add(emailVal);
            add(id1); add(id1Val);
            add(t); add(tVal);
            add(loc); add(locVal);
            add(sal); add(salVal);
            add(cgpa); add(cgpaVal);
            add(link); add(linkVal);
            
            back = new JButton("Back");
            back.setBounds(225,420,200,30);

            main = new JButton("Main Menu");
            main.setBounds(225,460,200,30);

            exit = new JButton("Exit");
            exit.setBounds(225,500,200,30);

            add(back); add(main); add(exit);

            back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                	new CompanyChoiceUI(job);
                    dispose();
                }
            });

            main.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new MainMenuUI();
                    dispose();
                }
            });

            exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });

        }

        // ===== RECOMMEND MENU =====
        else if(type.equals("RECOMMEND")){
        	
        	setTitle(type + " PANEL");
            setSize(500,400);
            setLocationRelativeTo(null);
            setLayout(null);

            title = new JLabel(type + " SECTION", JLabel.CENTER);
            title.setBounds(150,10,250,30);
            add(title);
            	
        	JLabel l1 = new JLabel("Recommendation of Applicants");
            l1.setBounds(50,80,200,30);

            JLabel skill = new JLabel("Recommendation of Skills");
            skill.setBounds(50,140,200,30);

            JButton btn = new JButton("Applicants");
            btn.setBounds(250,80,200,30);

            JButton skillRecBtn = new JButton("Skills");
            skillRecBtn.setBounds(250,140,200,30);

            add(l1); 
            add(btn);
            add(skill);
            add(skillRecBtn);

            btn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new CompanyDashboardUI(job,"RECOMMEND_APPLICANTS");
                    dispose();
                }
            });
            
            skillRecBtn.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new CompanyDashboardUI(job,"RECOMMEND_SKILLS");
                    dispose();
                }
            });
            
            back = new JButton("Back");
            back.setBounds(225,220,200,30);

            main = new JButton("Main Menu");
            main.setBounds(225,260,200,30);

            exit = new JButton("Exit");
            exit.setBounds(225,300,200,30);

            add(back); add(main); add(exit);

            back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                	new CompanyChoiceUI(job);
                    dispose();
                }
            });

            main.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new MainMenuUI();
                    dispose();
                }
            });

            exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            
        }

        // ===== RECOMMEND RESULT =====
        else if(type.equals("RECOMMEND_APPLICANTS")){
        	
        	String[] results = CompanyModule.RecommendStudentsUI(job.getJobId());
        	
        	setTitle("APPLICANS PANEL");
            setSize(500,400);
            setLocationRelativeTo(null);
            setLayout(null);

            title = new JLabel("APPLICANS SECTION", JLabel.CENTER);
            title.setBounds(150,10,200,30);
            add(title);
        	
            JTextArea area = new JTextArea(results[0]);
            area.setEditable(false);

            JScrollPane scroll = new JScrollPane(area);
            scroll.setBounds(50,50,400,150);
            add(scroll);

            back = new JButton("Back");
            back.setBounds(225,220,200,30);

            main = new JButton("Main Menu");
            main.setBounds(225,260,200,30);

            exit = new JButton("Exit");
            exit.setBounds(225,300,200,30);

            add(back); add(main); add(exit);

            back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                	new CompanyDashboardUI(job, "RECOMMEND");
                    dispose();
                }
            });

            main.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new MainMenuUI();
                    dispose();
                }
            });

            exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
        }
        
        else if(type.equals("RECOMMEND_SKILLS")){
        	
        	String[] results = CompanyModule.RecommendStudentsUI(job.getJobId());
        	
        	setTitle("SKILLS PANEL");
            setSize(500,400);
            setLocationRelativeTo(null);
            setLayout(null);

            title = new JLabel("SKILLS SECTION", JLabel.CENTER);
            title.setBounds(150,10,200,30);
            add(title);
        	
            JTextArea area = new JTextArea(results[1]);
            area.setEditable(false);

            JScrollPane scroll = new JScrollPane(area);
            scroll.setBounds(50,50,400,150);
            add(scroll);

            back = new JButton("Back");
            back.setBounds(225,220,200,30);

            main = new JButton("Main Menu");
            main.setBounds(225,260,200,30);

            exit = new JButton("Exit");
            exit.setBounds(225,300,200,30);

            add(back); add(main); add(exit);

            back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                	new CompanyDashboardUI(job, "RECOMMEND");
                    dispose();
                }
            });

            main.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new MainMenuUI();
                    dispose();
                }
            });

            exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
        }

        else if(type.equals("UPDATE")){
        	
        	setTitle("Update Credentials");
            setSize(500,600);
            setLocationRelativeTo(null);
            setLayout(null);

            title = new JLabel("UPDATE  CREDENTIALS", JLabel.CENTER);
            title.setBounds(150,10,200,30);
            add(title);
        	
            String labels[] = {
                "Company Name","Email","Password","Title",
                "Location","Salary","Qualification Req.","CGPA","Web Link","skills"
            };

            int y=60;

            for(String s: labels){
                JLabel l = new JLabel(s);
                l.setBounds(50,y,200,30);

                JButton b = new JButton("Update");
                b.setBounds(250,y,150,30);

                add(l); add(b);

                b.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        new CompanyUpdateFieldUI(job,s.toUpperCase());
                        dispose();
                    }
                });

                y+=40;
            } 
            
            back = new JButton("Back");
            back.setBounds(225,y,200,30);

            main = new JButton("Main Menu");
            main.setBounds(225,y+40,200,30);

            exit = new JButton("Exit");
            exit.setBounds(225,y+80,200,30);

            add(back); add(main); add(exit);

            back.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                	new CompanyChoiceUI(job);
                    dispose();
                }
            });

            main.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    new MainMenuUI();
                    dispose();
                }
            });

            exit.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
        }
        
        setVisible(true);
    }

}