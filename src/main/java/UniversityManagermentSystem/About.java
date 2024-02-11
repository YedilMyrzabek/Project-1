package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    public About(){
        setSize(700,500);
        setLocation(400,150);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon("C:\\\\Doc\\\\yedil.jpg");
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,20,300,200);
        add(image);

        JLabel heading = new JLabel("<html>Project: Moodle JR</br></html>");
        heading.setBounds(40,20,300,130);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JLabel name = new JLabel("Developed By: Myrzabek Yedil, Akerke Sugirbek");
        name.setBounds(40,230,750,40);
        name.setFont(new Font("Tahoma",Font.BOLD,26));
        add(name);

        JLabel idnumber = new JLabel("ID Number: 230760");
        idnumber.setBounds(40,278,550,40);
        idnumber.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(idnumber);

        JLabel contact = new JLabel("Contact: 230760@astanait.edu.kz");
        contact.setBounds(40,330,550,40);
        contact.setFont(new Font("Tahoma",Font.PLAIN,30));
        add(contact);

        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new About();
    }
}
