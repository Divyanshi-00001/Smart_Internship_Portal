package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;

import smartinternshipportal.dao.JobDAO;
import smartinternshipportal.main.MainApp;
import smartinternshipportal.model.Job;

public class CompanyUpdateFieldUI extends JFrame implements ActionListener {

    JTextField field;
    JPasswordField Pfield;
    JButton submit, back, main, exit;
    Job job;
    String type;

    public CompanyUpdateFieldUI(Job job, String type){
        this.job = job;
        this.type = type;

        setTitle("Update "+type);
        setSize(500,300);
        setLocationRelativeTo(null);
        setLayout(null);
        
        JLabel title = new JLabel("UPDATE " + type);
        title.setBounds(150,10,200,30);

        JLabel label = new JLabel("Enter New Value:");
        label.setBounds(50,80,150,30);
        
        if(type.equals("PASSWORD")) {
        	Pfield = new JPasswordField();
        	Pfield.setBounds(250,80,200,30);
        	 add(Pfield);
        } else {
        	field = new JTextField();
	        field.setBounds(250,80,200,30);
	        add(field);
        }
        submit = new JButton("Submit");
        submit.setBounds(250,130,150,30);

        back = new JButton("Back");
        back.setBounds(50,130,150,30);

        main = new JButton("Main Menu");
        main.setBounds(50,180,150,30);

        exit = new JButton("Exit");
        exit.setBounds(250,180,150,30);

        add(title); 
        add(label); add(submit);
        add(back); add(main); add(exit);

        submit.addActionListener(this);
        back.addActionListener(this);
        main.addActionListener(this);
        exit.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

    	if(e.getSource()==submit){

    	    try{
    	    	String val;
    	        if(type.equals("PASSWORD")) val = new String(Pfield.getPassword());
    	        else val = field.getText().trim();

    	        if(val.isEmpty())
    	            throw new Exception("Field cannot be empty");

    	        if(type.equals("COMPANY NAME")){
    	            if(!val.matches("[a-zA-Z ]+"))
    	                throw new Exception("Invalid Name");
    	            job.setCompanyName(val);
    	        }

    	        else if(type.equals("EMAIL")){
    	            if(!val.contains("@") || !val.contains(".") || val.equals(" "))
    	                throw new Exception("Invalid Email");

//    	            for(int i = 0; i <= MainApp.Jnum; i++){
//    	                if(MainApp.jj[i] != null &&
//    	                   MainApp.jj[i].getEmail().equals(val) &&
//    	                   MainApp.jj[i] != job){
//    	                    throw new Exception("Email already exists!");
//    	                }
//    	            }

    	            job.setEmail(val);
    	        }

    	        else if(type.equals("PASSWORD")){
    	            if(val.length() < 8)
    	                throw new Exception("Weak Password");
    	            job.setPassword(val);
    	        }

    	        else if(type.equals("TITLE")){
    	            job.setTitle(val);
    	        }

    	        else if(type.equals("LOCATION")){
    	            job.setLocation(val);
    	        }

    	        else if(type.equals("SALARY")){
    	            double sal = Double.parseDouble(val);
    	            if(sal < 0)
    	                throw new Exception("Invalid Salary");
    	            job.setSalary(sal);
    	        }

    	        else if(type.equals("QUALIFICATION")){
    	            job.setQualification(val);
    	        }

    	        else if(type.equals("CGPA")){
    	            double cgpa = Double.parseDouble(val);
    	            if(cgpa < 0 || cgpa > 10)
    	                throw new Exception("Invalid CGPA");
    	            job.setMinCgpa(cgpa);
    	        }

    	        else if(type.equals("WEB LINK")){
    	            if(!val.contains(".com"))
    	                throw new Exception("Invalid Link");
    	            job.setWebLink(val);
    	        }

    	        else if(type.equals("SKILLS")){
    	            HashSet<String> skills = new HashSet<>();
    	            String skl[] = val.split("\\s+");

    	            for(String s : skl){
    	                if(!s.isEmpty())
    	                    skills.add(s.toLowerCase());
    	            }

    	            if(skills.isEmpty())
    	                throw new Exception("Enter at least one skill");

    	            job.setRequiredSkill(skills);
    	        }

    	        JobDAO.updateJob(job);
    	        JOptionPane.showMessageDialog(this,"Updated Successfully!");
    	        new CompanyDashboardUI(job,"UPDATE");
    	        dispose();

    	    }
    	    catch(NumberFormatException ex){
    	        JOptionPane.showMessageDialog(this,"Enter valid number!");
    	    }
    	    catch(Exception ex){
    	        JOptionPane.showMessageDialog(this, ex.getMessage());
    	    }
    	}

        else if(e.getSource()==back){
        	new CompanyDashboardUI(job,"UPDATE");
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