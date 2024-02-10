package UniversityManagermentSystem;

import javax.management.timer.TimerMBean;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton buttonLogin, buttonCancel;
    JTextField tfusername, tfpassword;
    Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,20);
        add(username);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,20);
        add(password);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);

        buttonLogin = new JButton("Login");
        buttonLogin.setBounds(40,140 ,120,30);
        buttonLogin.setBackground(Color.BLACK);
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.addActionListener(this);
        buttonLogin.setFont(new Font("Tahoma",Font.BOLD,16));
        add(buttonLogin);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setBounds(180,140 ,120,30);
        buttonCancel.setBackground(Color.BLACK);
        buttonCancel.setForeground(Color.WHITE);
        buttonCancel.addActionListener(this);
        buttonCancel.setFont(new Font("Tahoma",Font.BOLD,16));
        add(buttonCancel);

        ImageIcon i1 = new ImageIcon("C:\\\\Doc\\\\admin2.png");
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(360,10,200,200);
        add(image);

        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonLogin){
            String username = tfusername.getText();
            String password = tfpassword.getText();

            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Project();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                    setVisible(false);
                }
                c.s.close();
            }catch (Exception en){
                en.printStackTrace();
            }
        }else if(e.getSource() == buttonCancel){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
