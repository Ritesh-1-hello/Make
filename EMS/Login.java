package EMS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{ // action listener to

    JTextField tfusername, tfpassword; // global to use in different function

    Login() {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");  // label user
        lblusername.setBounds(40, 20, 100, 30);
        add(lblusername);

        tfusername = new JTextField(); // text field for username
        tfusername.setBounds(150, 20, 150, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password"); // label password
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        tfpassword = new JPasswordField(); // text field for password
        tfpassword.setBounds(150, 70, 150, 30);
        add(tfpassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setLocation(450, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText(); // getting username from text field
            String password = tfpassword.getText(); // getting password from text field

            Conn c = new Conn();// creating conn class object to use statement s
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";

            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();// next class
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);//giving pop up
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
