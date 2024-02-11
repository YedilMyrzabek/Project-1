package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    Project(){
        JButton button = new JButton("New Student Details");
        button.setForeground(Color.BLACK);
        button.addActionListener(this);
        button.setBounds(75,114,140,30);
        add(button);

        JButton Dashboard = new JButton("New Teacher Details");
        Dashboard.setForeground(Color.BLACK);
        Dashboard.addActionListener(this);
        Dashboard.setBounds(75,163,140,30);
        add(Dashboard);

        JButton Calendar = new JButton("Calendar");
        Calendar.setForeground(Color.BLACK);
        Calendar.addActionListener(this);
        Calendar.setBounds(75,215,140,30);
        add(Calendar);

        JButton Private_files = new JButton("Private files");
        Private_files.setForeground(Color.BLACK);
        Private_files.addActionListener(this);
        Private_files.setBounds(75,262,140,30);
        add(Private_files);

        JButton AppSt = new JButton("Apply Student");
        AppSt.setForeground(Color.BLACK);
        AppSt.addActionListener(this);
        AppSt.setBounds(78,312,140,30);
        add(AppSt);

        JButton AppTh = new JButton("Apply Teacher");
        AppTh.setForeground(Color.BLACK);
        AppTh.addActionListener(this);
        AppTh.setBounds(80,362,140,30);
        add(AppTh);

        JButton AppLeaveStudent = new JButton("Student Leave Details");
        AppLeaveStudent.setForeground(Color.BLACK);
        AppLeaveStudent.addActionListener(this);
        AppLeaveStudent.setBounds(80,412,140,30);
        add(AppLeaveStudent);

        JButton UpdateTeacherDetails = new JButton("Update Teacher Details");
        UpdateTeacherDetails.setForeground(Color.BLACK);
        UpdateTeacherDetails.addActionListener(this);
        UpdateTeacherDetails.setBounds(80,512,140,30);
        add(UpdateTeacherDetails);

        JButton UpdateStudentDetails = new JButton("Update Student Details");
        UpdateStudentDetails.setForeground(Color.BLACK);
        UpdateStudentDetails.addActionListener(this);
        UpdateStudentDetails.setBounds(80,562,140,30);
        add(UpdateStudentDetails);

        JButton AppLeaveTeacher = new JButton("Teacher Leave Details");
        AppLeaveTeacher.setForeground(Color.BLACK);
        AppLeaveTeacher.addActionListener(this);
        AppLeaveTeacher.setBounds(80,462,140,30);
        add(AppLeaveTeacher);

        JButton EnterMarks = new JButton("Examination");
        EnterMarks.setForeground(Color.BLACK);
        EnterMarks.addActionListener(this);
        EnterMarks.setBounds(80,612,140,30);
        add(EnterMarks);

        JButton resExam = new JButton("Examination Results");
        resExam.setForeground(Color.BLACK);
        resExam.addActionListener(this);
        resExam.setBounds(80,662,140,30);
        add(resExam);

        JButton feeStruct = new JButton("Fee Structure");
        feeStruct.setForeground(Color.BLACK);
        feeStruct.addActionListener(this);
        feeStruct.setBounds(1348,90,140,30);
        add(feeStruct);

        JButton about = new JButton("About");
        about.setForeground(Color.BLACK);
        about.addActionListener(this);
        about.setBounds(1348,40,147,33);
        add(about);

        JButton feeForm = new JButton("Fee Form");
        feeForm.setForeground(Color.BLACK);
        feeForm.addActionListener(this);
        feeForm.setBounds(1348,140,140,30);
        add(feeForm);

        setSize(1540,850);
        ImageIcon i1 = new ImageIcon("C:\\\\Doc\\\\title.png");
        Image i2 = i1.getImage().getScaledInstance(1500,750,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,10,200,200);
        add(image);

        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();

        if (msg.equals("Exit")) {
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception ae) {

            }
        } else if (msg.equals("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception ae) {

            }
        } else if (msg.equals("New Teacher Details")) {
            new AddTeacher();
        } else if (msg.equals("New Student Details")) {
            new AddStudent();
        } else if (msg.equals("Calendar")) {
            new StudentDetails();
        } else if (msg.equals("Private files")) {
            new TeacherDetails();
        } else if (msg.equals("Apply Student")) {
            new StudentLeave();
        } else if (msg.equals("Apply Teacher")) {
            new Teacherleave();
        } else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (msg.equals("Teacher Leave Details")) {
            new TeacherLeaveDetails();
        } else if (msg.equals("Update Teacher Details")) {
            new UpdateTeacher();
        } else if (msg.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (msg.equals("Examination")) {
            new EnterMarks();
        } else if (msg.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        } else if (msg.equals("About")) {
            new About();
        } else if (msg.equals("Fee Form")) {
            new StudentFeeForm();
        }
    }
    public static void main(String[] args) {
        new Project();
    }
}
