package mcr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class admin extends JFrame implements ActionListener{
     JFrame f;
     JTextField f1,f2;
     JLabel l1,l2,l3;
     JPasswordField pw;
     JButton b1;
    admin(){        
        
        f=new JFrame("Admin Login");
        l1=new JLabel("Admin: ");
        l1.setBounds(50,50,100,30);
        f1=new JTextField();
        f1.setBounds(120, 50, 100, 30);
        l2=new JLabel("Password: ");
        l2.setBounds(50,100,100,30);
        pw=new JPasswordField();
        pw.setBounds(120, 100, 100, 30);
        b1=new JButton("LOGIN");
        b1.setBounds(100,150,100,50);
        b1.addActionListener(this);
        f.add(l1);f.add(f1);f.add(l2);f.add(pw);f.add(b1);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setLocation(500,300);
        f.setVisible(true);
        
        
    }
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==b1){
          try{
            conn c=new conn();
            ResultSet rs=c.stmt.executeQuery("select * from login where user_id='"+f1.getText()+"' and password='"+pw.getText()+"';");
            
                if(rs.next()){
                new admin_page().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Either password or user id is wrong");
                }
            
          }
          catch(Exception ex){
              System.out.println(ex);
          }
            
        }
    }
}
