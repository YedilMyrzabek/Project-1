package UniversityManagermentSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Splash extends JFrame implements Runnable{
    Thread t;
    public Splash(){
        ImageIcon i1 = new ImageIcon("C:\\\\Doc\\\\aituu.jpg");
        Image i2 = i1.getImage().getScaledInstance(1280,720,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        t = new Thread(this);
        t.start();
        setVisible(true);

        setLocation(150,50);
        setSize(1280,720);
    }
    public void run() {
        try{
            Thread.sleep(3000L);
            this.setVisible(false);

            new Login();
        }catch (Exception e){
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
