package EMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Splash extends JFrame implements ActionListener {

    Splash() {

        getContentPane().setBackground(Color.WHITE);// changing color of the window by awt package
        setLayout(null); // don't want to use layout of swing

        JLabel heading = new JLabel("STUDENT MANAGEMENT SYSTEM"); // to adding heading on window
        heading.setBounds(80, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.PLAIN, 60)); // setting location of heading
        heading.setForeground(Color.RED); // setting color of the heading
        add(heading); // adding component on window or frame

        // using images on frame or window
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));// getting images from system
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);//scaling image
        ImageIcon i3 = new ImageIcon(i2); // converting image into image icon
        JLabel image = new JLabel(i3);  // creating jlabel to insert image on frame
        image.setBounds(50, 100, 1050, 500);// setting location of image of jlabel class
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE"); // to add button on frame
        clickhere.setBounds(400, 400, 300, 70);
        clickhere.setBackground(Color.BLACK);
        clickhere.setForeground(Color.WHITE);
        clickhere.addActionListener(this);//click on button
        image.add(clickhere);// adding button on w.r.t image


        setSize(1170, 650); // frame size
        setLocation(200, 50);  // location of frame on window
        setVisible(true); // frame will be visible

       while(true) {
          /*  heading.setVisible(false);   // using to splash heading for 0.5 second
            try {
                Thread.sleep(500);
            } catch (Exception e){

            }

*/
            heading.setVisible(true);
            try {
               // Thread.sleep(500);
            } catch (Exception e){

            }
        }
    }

    public void actionPerformed(ActionEvent ae) {// overriding the method what to do after clicking on button
        setVisible(false);//current frame close
        new Login();//opens the login frame
    }

    public static void main(String args[]) {
        new Splash(); // calling splash method 
    }
}
