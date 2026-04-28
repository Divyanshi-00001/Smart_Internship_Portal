package smartinternshipportal.ui;

import javax.swing.*;
import java.awt.event.*;
import smartinternshipportal.model.Student;
import smartinternshipportal.main.MainApp;
import smartinternshipportal.dao.ApplicantDAO;

public class UpdateFieldUI extends JFrame implements ActionListener {

    Student student;
    String type;

    JTextField field;
    JPasswordField Pfield;
    JButton submit, back, main, exit;

    public UpdateFieldUI(Student student, String type){

        this.student = student;
        this.type = type;

        setTitle("Update " + type);
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
        }
        else {
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

        add(title); add(label); 
        add(submit); add(back); add(main); add(exit);

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

                if(type.equals("NAME")){
                    val = val.trim();
                    if(val.isEmpty() || !val.matches("[a-zA-Z ]+"))
                        throw new Exception("Invalid Name");

                    student.setName(val);
                }

                else if(type.equals("EMAIL")){
                    if(!val.contains("@") || !val.contains(".") || val.contains(" ")) throw new Exception("Invalid Email");

                    for(int i=0;i<=MainApp.Snum;i++){
                        if(MainApp.ss[i]!=null &&
                           MainApp.ss[i].getEmail().equals(val) &&
                           MainApp.ss[i]!=student){
                            throw new Exception("Email exists!");
                        }
                    }
                    student.setEmail(val);
                }

                else if(type.equals("PASSWORD")){
                    if(val.length()<8) throw new Exception("Weak Password");
                    student.setPassword(val);
                }

                else if(type.equals("QUAL")){
                    if(val.isEmpty()) throw new Exception("Invalid Qualification");
                    student.setQualification(val);
                }

                else if(type.equals("CGPA")){
                    double cg = Double.parseDouble(val);
                    if(cg<0 || cg>10) throw new Exception("Invalid CGPA");
                    student.setCgpa(cg);
                }

                else if(type.equals("RESUME")){
                    if(!val.endsWith(".txt")) throw new Exception("Must be .txt file");
                    student.setResumePath(val);
                }

                else if(type.equals("SALARY")){
                    double sal = Double.parseDouble(val);
                    if(sal<0) throw new Exception("Invalid Salary");
                    student.setSalary(sal);
                }

                ApplicantDAO.updateApplicant(student);
                JOptionPane.showMessageDialog(this,"Updated Successfully!");
                new StudentUpdateMenuUI(student);
                dispose();

            } catch(Exception ex){
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }

        else if(e.getSource()==back){
            new StudentUpdateMenuUI(student);
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