package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class StudentFeeForm extends JFrame implements ActionListener {
    Choice crollno;
    JComboBox cbcourse,cbsubject,cbtrimester,cbrollno;
    JButton update,cancel,pay;
    JLabel lbltotal;
    public StudentFeeForm(){
        setSize(900,500);
        setLocation(300,100);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon("C:\\\\Doc\\\\fee.jpeg");
        Image i2 = i1.getImage().getScaledInstance(350,300,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,500,300);
        add(image);

        JLabel lblrollnumber = new JLabel("Select ID Number");
        lblrollnumber.setBounds(40, 60, 150, 20);
        lblrollnumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblrollnumber);

        crollno = new Choice();
        crollno.setBounds(200, 60, 150, 20);
        add(crollno);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(labelname);

        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40, 140,     150, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD,16));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(200, 140, 150, 20);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelfname);

        try {
            Conn c = new Conn();
            String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
            }
        } catch (Exception es) {
            es.printStackTrace();
        }

        crollno.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where rollno='"+crollno.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);

        String course[] = {"Computer Science","Software Engineering","Big Data Analysis","Media Technologies","Mathematical and Computational Science","Big Data in Healthcare","Cyber Security","Smart Technologies","Industrial Internet of Things","Electronic Engineering","IT Management","IT Entrepreneuship","Digital Jurnalism"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblsubject = new JLabel("Subject");
        lblsubject.setBounds(40,220,150,20);
        lblsubject.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblsubject);

        String subject[] = {"Linear Algebre","Calculus","Political Science","OOP","Physical Education","Discrete Mathematics","ITP","Foreign Language","Sociology","History of Kazakhstan","Psychology","Algorithms and Data Structures"};
        cbsubject = new JComboBox(subject);
        cbsubject.setBounds(200,220,150,20);
        cbsubject.setBackground(Color.WHITE);
        add(cbsubject);

        JLabel lbltrimestr = new JLabel("Trimester");
        lbltrimestr.setBounds(40, 260, 150, 20);
        lbltrimestr.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltrimestr);

        String trim[] = {"Trimester1","Trimester2","Trimester3","Trimester4","Trimester5","Trimester6","Trimester7","Trimester8","Trimester9","Trimester10","Trimester11","Trimester12"};
        cbtrimester = new JComboBox(trim);
        cbtrimester.setBounds(200,260,150,20);
        cbtrimester.setBackground(Color.WHITE);
        add(cbtrimester);

        JLabel lbltotal1 = new JLabel("Total Payable");
        lbltotal1.setBounds(40, 300, 150, 20);
        lbltotal1.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltotal1);

        lbltotal = new JLabel();
        lbltotal.setBounds(200, 300, 150, 20);
        lbltotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltotal);

        update = new JButton("Update");
        update.setBounds(30,380 ,100,25);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        pay = new JButton("Pay Fee");
        pay.setBounds(150,380 ,100,25);
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.addActionListener(this);
        pay.setFont(new Font("Tahoma",Font.BOLD,16));
        add(pay);

        cancel = new JButton("Back");
        cancel.setBounds(270,380 ,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(cancel);



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == update){
            String course = (String) cbsubject.getSelectedItem();
            String trimester = (String) cbtrimester.getSelectedItem();
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from sub where Subject = '"+course+"'");
                while (rs.next()){
                    lbltotal.setText(rs.getString(trimester));
                }
            }catch (Exception es){
                es.printStackTrace();
            }
        }else if(e.getSource() == pay){
            String rollno = crollno.getSelectedItem();
            String course = (String) cbsubject.getSelectedItem();
            String trimester = (String) cbtrimester.getSelectedItem();
            String subject = (String) cbcourse.getSelectedItem();
            String total = lbltotal.getText();

            try {
                Conn cs = new Conn();
                String query = "insert into alllfee values('"+rollno+"','"+subject+"','"+course+"','"+trimester+"','"+total+"')";
                cs.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"University Fee submitted successfully");
                setVisible(false);
            }catch (Exception af){
                af.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new StudentFeeForm();
    }

}
