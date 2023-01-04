package EMS;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener{

    JTextField tfcourse, tffname, tfaddress, tfphone, tfaadhar, tfemail, tffee, tfdepart;
    JLabel lblroll;
    JButton add, back;
    String roll;

    UpdateStudent(String roll) {
        this.roll = roll;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);

        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(200, 150, 150, 30);
        add(lblname);

        JLabel labelfname = new JLabel("Father's Name");
        labelfname.setBounds(400, 150, 150, 30);
        labelfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelfname);

        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);

        JLabel labeldob = new JLabel("Date of Birth");
        labeldob.setBounds(50, 200, 150, 30);
        labeldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(200, 200, 150, 30);
        add(lbldob);

        JLabel labelsalary = new JLabel("Annual Fee");
        labelsalary.setBounds(400, 200, 150, 30);
        labelsalary.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelsalary);

        tffee = new JTextField();
        tffee.setBounds(600, 200, 150, 30);
        add(tffee);

        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50, 250, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);

        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(400, 250, 150, 30);
        labelphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelphone);

        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);

        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50, 300, 150, 30);
        labelemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelemail);

        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);

        JLabel labelcourse = new JLabel("Course");
        labelcourse.setBounds(400, 300, 150, 30);
        labelcourse.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcourse);

        tfcourse = new JTextField();
        tfcourse.setBounds(600, 300, 150, 30);
        add(tfcourse);

        JLabel labeldepart = new JLabel("Department");
        labeldepart.setBounds(50, 350, 150, 30);
        labeldepart.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeldepart);

        tfdepart = new JTextField();
        tfdepart.setBounds(200, 350, 150, 30);
        add(tfdepart);

        JLabel labelaadhar = new JLabel("Aadhar Number");
        labelaadhar.setBounds(400, 350, 150, 30);
        labelaadhar.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelaadhar);

        JLabel lblaadhar = new JLabel();
        lblaadhar.setBounds(600, 350, 150, 30);
        add(lblaadhar);

        JLabel labelroll = new JLabel("Roll No.");
        labelroll.setBounds(50, 400, 150, 30);
        labelroll.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelroll);

        lblroll = new JLabel();
        lblroll.setBounds(200, 400, 150, 30);
        lblroll.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblroll);

        try {
            Conn c = new Conn();
            String query = "select * from student where roll = '"+roll+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tffee.setText(rs.getString("AnnualFee"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfcourse.setText(rs.getString("course"));
                lblaadhar.setText(rs.getString("aadhar"));
                lblroll.setText(rs.getString("roll"));
                tfdepart.setText(rs.getString("department"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Update Details");
        add.setBounds(250, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);

        back = new JButton("Back");
        back.setBounds(450, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);

        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String fname = tffname.getText();
            String fee = tffee.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String depart = tfdepart.getText();

            try {
                Conn conn = new Conn();
                String query = "update student set fname = '"+fname+"', AnnualFee = '"+fee+"', address = '"+address+"', phone = '"+phone+"', email =  '"+email+"', course = '"+course+"', department = '"+depart+"' where roll = '"+roll+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateStudent("");
    }
}
