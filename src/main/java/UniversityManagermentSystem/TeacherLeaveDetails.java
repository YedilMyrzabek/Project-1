package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice crollno;
    JTable table;
    JButton search, print,update, add,cancel;
    public TeacherLeaveDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by ID Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(300,100);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent es) {
        if(es.getSource() == search){
            String query = "select * from teacherleave where rollno = '"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(es.getSource() == print){
            try{
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherLeaveDetails();
    }
}
