package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;
import smartinternshipportal.main.MainApp;
import smartinternshipportal.model.Job;
import smartinternshipportal.dao.JobDAO;

public class CompanySignupUI extends JFrame implements ActionListener {

    JTextField nameField, emailField, titleField, locationField, salaryField, qualField, cgpaField, linkField, skillField;
    JPasswordField passField;
    JButton submitBtn, backBtn, clearBtn, exitBtn;

    public CompanySignupUI() {
        setTitle("Company Signup");
        setSize(500,600);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel title = new JLabel("COMPANY SIGNUP");
        title.setBounds(160,10,250,30);

        String labels[] = {"Company Name","Email","Password","Job Title","Location","Salary","Qualification Req.","Min CGPA","Web Link","Skill(Space separated)"};
        int y=50;

        JTextField fields[] = new JTextField[labels.length];

        for(int i=0;i<labels.length;i++){
            JLabel l = new JLabel(labels[i]+":");
            l.setBounds(50,y,150,30);
            add(l);

            if(labels[i].equals("Password")){
                passField = new JPasswordField();
                passField.setBounds(250,y,200,30);
                add(passField);
            } else {
                fields[i] = new JTextField();
                fields[i].setBounds(250,y,200,30);
                add(fields[i]);
            }
            y+=40;
        }

        nameField = fields[0];
        emailField = fields[1];
        titleField = fields[3];
        locationField = fields[4];
        salaryField = fields[5];
        qualField = fields[6];
        cgpaField = fields[7];
        linkField = fields[8];
        skillField = fields[9];

        submitBtn = new JButton("Submit");
        submitBtn.setBounds(280,470,150,30);

        backBtn = new JButton("Back");
        backBtn.setBounds(50,470,150,30);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(50,510,150,30);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(280,510,150,30);

        add(title); add(submitBtn); add(backBtn); add(clearBtn); add(exitBtn);

        submitBtn.addActionListener(this);
        backBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource()==submitBtn){
        	try{
        	    String name = nameField.getText().trim();
        	    String email = emailField.getText().trim();
        	    String pass = new String(passField.getPassword()).trim();
        	    String title = titleField.getText().trim();
        	    String loc = locationField.getText().trim();
        	    String qual = qualField.getText().trim();
        	    String link = linkField.getText().trim();

        	    double sal = Double.parseDouble(salaryField.getText().trim());
        	    double cgpa = Double.parseDouble(cgpaField.getText().trim());

        	    if(name.isEmpty() || !name.matches("[a-zA-Z ]+"))
        	        throw new Exception("Invalid Company Name");

        	    if(!email.contains("@") || !email.contains(".") || email.contains(" "))
        	        throw new Exception("Invalid Email");
//        	    for(int i=0;i<=MainApp.Jnum;i++){
//                    if(MainApp.jj[i]!=null &&
//                       MainApp.jj[i].getEmail().equals(email)){
//                        throw new Exception("Email exists!");
//                    }
//                }

        	    if(pass.length() < 8)
        	        throw new Exception("Password must be at least 8 characters");

        	    if(title.isEmpty())
        	        throw new Exception("Invalid Job Title");

        	    if(loc.isEmpty())
        	        throw new Exception("Invalid Location");

        	    if(sal < 0)
        	        throw new Exception("Invalid Salary");

        	    if(qual.isEmpty())
        	        throw new Exception("Invalid Qualification");

        	    if(cgpa < 0 || cgpa > 10)
        	        throw new Exception("Invalid CGPA");

        	    if(!link.contains(".com"))
        	        throw new Exception("Invalid Web Link");

        	    HashSet<String> skills = new HashSet<>();
        	    String skl[] = skillField.getText().trim().split("\\s+");

        	    for(int i = 0; i < skl.length; i++){
        	        if(!skl[i].isEmpty())
        	            skills.add(skl[i].toLowerCase());
        	    }

        	    if(skills.isEmpty())
        	        throw new Exception("Enter at least one skill");

        	    MainApp.Jnum++;
        	    if(MainApp.Jnum >= MainApp.jj.length){
        	        MainApp.jj = java.util.Arrays.copyOf(MainApp.jj, MainApp.jj.length * 2);
        	    }

        	    MainApp.jj[MainApp.Jnum] = new Job(
        	        name, email, pass, title, loc, sal, qual, cgpa, link, skills
        	    );

        	    JobDAO.insertJob(MainApp.jj[MainApp.Jnum]);
        	    JOptionPane.showMessageDialog(this,"Signup Successful!");
        	    new CompanyLoginUI();
        	    dispose();

        	}catch(NumberFormatException ex){
        	    JOptionPane.showMessageDialog(this,"Salary & CGPA must be numbers!");
        	}
        	catch(Exception ex){
        	    JOptionPane.showMessageDialog(this, ex.getMessage());
        	}
        }

        else if(e.getSource()==clearBtn){
            nameField.setText(""); emailField.setText(""); passField.setText("");
            titleField.setText(""); locationField.setText(""); salaryField.setText("");
            qualField.setText(""); cgpaField.setText(""); linkField.setText(""); skillField.setText("");
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