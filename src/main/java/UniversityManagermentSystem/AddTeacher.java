package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname,tffname,tfaddress,tfphone,tfxii,tfemail,tfx,tfcourse;
    JLabel labelrollno;
    JDateChooser dcdob;
    JComboBox cbcourse;
    JButton submit,cancel;
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() %9000L)  + 1000L);
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lblfname = new JLabel("Surname");
        lblfname.setBounds(400,150,100,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lblrollno = new JLabel("Employee ID");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

        labelrollno = new JLabel("2303"+first4);
        labelrollno.setBounds(200,200,200,30);
        labelrollno.setFont(new Font("serif",Font.BOLD,20));
        add(labelrollno);

        JLabel lbldob = new JLabel("Date of birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);

        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

        JLabel lblcourse = new JLabel("Department");
        lblcourse.setBounds(400,350,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);

        String course[] = {"Computer Science","Software Engineering","Big Data Analysis","Media Technologies","Mathematical and Computational Science","Big Data in Healthcare","Cyber Security","Smart Technologies","Industrial Internet of Things","Electronic Engineering","IT Management","IT Entrepreneuship","Digital Jurnalism"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(600,350,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        submit = new JButton("Submit");
        submit.setBounds(250,550 ,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,16));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550 ,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cancel);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelrollno.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String course = (String) cbcourse.getSelectedItem();

            try{
                String query = "INSERT INTO teacher VALUES('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"','"+course+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);

            }catch (Exception egg){
                egg.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddTeacher();
    }
}
