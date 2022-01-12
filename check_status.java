
package mcr;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class check_status extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField tf1;
    JButton b1;
    JTextArea ta1;
    JFrame f;
    check_status(){
        f=new JFrame();
        
        f.setTitle("CHECK STATUS");
        
        l1=new JLabel("..CHECK STATUS..");
        l1.setBounds(0,0,400,45);
        l1.setFont(new Font("Arial",Font.BOLD,30));
        l1.setForeground(new Color(0, 255, 51));
        l1.setBackground(new Color(255,255,255));
        l1.setHorizontalAlignment(SwingConstants.CENTER);
        f.add(l1);
                
        l2=new JLabel("Complaint No.");
        l2.setBounds(10,100, 150, 30);
        l2.setFont(new Font("Arial",Font.BOLD,16));
        l2.setForeground(new Color(0, 0, 0));
         l2.setBackground(new Color(255,255,255));
        f.add(l2);     
        
        tf1=new JTextField();
        tf1.setBounds(170,100,150,30);
        tf1.setFont(new Font("Arial",Font.BOLD,16));
        tf1.setForeground(new Color(0, 0, 0));
        tf1.setBackground(new Color(255,255,255));
        f.add(tf1);     
        
        b1=new JButton("Check");
        b1.setFont(new Font("Arial",Font.BOLD,14));
        b1.setForeground(new Color(255,255,255));
        b1.setBounds(130,160,100,30);
        b1.setBackground(new Color(0, 0, 0));
        b1.addActionListener(this);
        f.add(b1);
        
        
        ta1=new JTextArea();
        ta1.setFont(new Font("Arial",Font.BOLD,16));
        ta1.setBackground(Color.white);
        ta1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
        ta1.setBounds(20, 220, 350, 300);
        ta1.setEditable(false);
        f.add(ta1);
        
        f.getContentPane().setBackground(Color.white);
        f.setLayout(null);
        f.setSize(400,600);
        f.setLocation(420,0);
        f.setVisible(true);
       // f.setDefaultCloseOperation(EXIT_ON_CLOSE);

}
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==b1){
            String s=tf1.getText();
        
        conn c=new conn();
        ResultSet rs;
        String data = null;
        try {
            rs = c.stmt.executeQuery("select complaint_status from details where phone_no='"+s+"';");
            while (rs.next()){
            data=rs.getString("complaint_status");
            
            }
            if (data==null){
            ta1.setText("Enter correct complaint number");
            }
            else{
            ta1.setText(data);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       
        }
        
    }


}
