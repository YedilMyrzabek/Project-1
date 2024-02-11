package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Marks extends JFrame implements ActionListener {
     String rollno;
     JButton cancel;
    public Marks(String rollno){
        this.rollno = rollno;

        setSize(500,600);
        setLocation(500,100);

        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Astana IT University");
        heading.setBounds(100, 10, 500, 25);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);

        JLabel subheading = new JLabel("Result of Examination 2023");
        subheading.setBounds(100, 50, 500, 25);
        subheading.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(subheading);

        JLabel lblrollno = new JLabel("ID Number: " + rollno);
        lblrollno.setBounds(60, 100, 500, 20);
        lblrollno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblrollno);

        JLabel lbltrimester = new JLabel();
        lbltrimester.setBounds(60, 130, 500, 25);
        lbltrimester.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lbltrimester);

        JLabel lblsub1 = new JLabel();
        lblsub1.setBounds(100, 200, 500, 25);
        lblsub1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsub1);

        JLabel lblsub2 = new JLabel();
        lblsub2.setBounds(100, 230, 500, 25);
        lblsub2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsub2);

        JLabel lblsub3 = new JLabel();
        lblsub3.setBounds(100, 260, 500, 25);
        lblsub3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsub3);

        JLabel lblsub4 = new JLabel();
        lblsub4.setBounds(100, 290, 500, 25);
        lblsub4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsub4);

        JLabel lblsub5 = new JLabel();
        lblsub5.setBounds(100, 320, 500, 25);
        lblsub5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(lblsub5);

        try {
            Conn c = new Conn();

            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno = '"+rollno+"'");
            while (rs1.next()){
                lblsub1.setText(rs1.getString("Subject1"));
                lblsub2.setText(rs1.getString("Subject2"));
                lblsub3.setText(rs1.getString("Subject3"));
                lblsub4.setText(rs1.getString("Subject4"));
                lblsub5.setText(rs1.getString("Subject5"));
            }

            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno = '"+rollno+"'");
            while(rs2.next()) {
                lblsub1.setText(lblsub1.getText() + "------------" + rs2.getString("marks1"));
                lblsub2.setText(lblsub2.getText() + "------------" + rs2.getString("marks2"));
                lblsub3.setText(lblsub3.getText() + "------------" + rs2.getString("marks3"));
                lblsub4.setText(lblsub4.getText() + "------------" + rs2.getString("marks4"));
                lblsub5.setText(lblsub5.getText() + "------------" + rs2.getString("marks5"));
                lbltrimester.setText("Trimester " + rs2.getString("trimester"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cancel = new JButton("Back");
        cancel.setBounds(250, 500, 120, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);

        setVisible(true);
    }
    public static void main(String[] args) {
        new Marks("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }
}
