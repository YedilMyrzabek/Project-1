package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener {

    Choice cEmpId;
    JTable table;
    JButton search, print,update, add,cancel;
    TeacherDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        cEmpId = new Choice();
        cEmpId.setBounds(180,20,150,20);
        add(cEmpId);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while (rs.next()){
                cEmpId.add(rs.getString("rollno"));
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
            ResultSet rs = c.s.executeQuery("select * from teacher");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while (rs.next()){
                cEmpId.add(rs.getString("rollno"));
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

        update = new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        add = new JButton("Add");
        add.setBounds(320,70,80,20);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(900,700);
        setLocation(300,100);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent es) {
        if(es.getSource() == search){
            String query = "select * from teacher where rollno = '"+cEmpId.getSelectedItem()+"'";
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
        }else if(es.getSource() == add){
            setVisible(false);
            new AddStudent();
        }else if(es.getSource() == update){
            setVisible(false);
            // new UpdateTeacher();
        }else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new TeacherDetails();
    }
}
