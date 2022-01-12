
package mcr;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;


public class Main extends JFrame implements ActionListener {
    JLabel l0,l1,l2,l3,l4,l5,l6,lp1,lp2,lp3;
    JTextField t1,t2;
    JComboBox c1;
    JTextArea a1,a2;
    JTextField tf1;
    JButton b1,b2,b3,sub,clear,admin,check_s;
    
    Main(){
        setTitle("REGIONAL ISSUES PORTAL");
            lp1=new JLabel("");
            lp2=new JLabel("");
            lp3=new JLabel("");
            
            l0=new JLabel("..! WELCOME !..");
            l0.setFont(new Font("Arial",Font.BOLD,36));
            l0.setBounds(0,0,600,50);
            l0.setForeground(new Color(0, 255, 51));
            l0.setHorizontalAlignment(SwingConstants.CENTER);
            add(l0);
            
            l1=new JLabel("Name:");
            l1.setFont(new Font("Arial",Font.BOLD,20));
            l1.setBounds(30,100,90,30);            
            add(l1);
            
            t1=new JTextField();
            t1.setFont(new Font("Arial",Font.BOLD,14));
            t1.setBounds(190,100,300,30);
            t1.setBackground(Color.WHITE);
            add(t1);
            
            l2=new JLabel("Phone Number:");
            l2.setFont(new Font("Arial",Font.BOLD,20));
            l2.setBounds(30,150,150,30);
            l2.setBackground(Color.WHITE);
            add(l2);
            
            
            t2=new JTextField();
            t2.setFont(new Font("Arial",Font.BOLD,14));
            t2.setBounds(190,150,300,30);
            t2.setBackground(Color.WHITE);
            add(t2);
           
            l6=new JLabel("Mail-ID:");
            l6.setFont(new Font("Arial",Font.BOLD,20));
            l6.setBounds(30,200,150,30);
            l6.setBackground(Color.WHITE);
            add(l6);
            
            
            tf1=new JTextField();
            tf1.setFont(new Font("Arial",Font.BOLD,14));
            tf1.setBounds(190,200,300,30);
            tf1.setBackground(Color.WHITE);
            add(tf1);
            
            l3=new JLabel("Department");
            l3.setFont(new Font("Arial",Font.BOLD,20));
            l3.setBounds(30,250,150,30);
            l3.setBackground(Color.WHITE);
            add(l3);
            
            String dept[]={"Select","Road","Electricity","Town Planning","Other"};
            c1=new JComboBox(dept);
            //c1.setIntialValue("Road");
            c1.setFont(new Font("Arial",Font.BOLD,14));
            c1.setBackground(Color.white);
            c1.setBounds(190,250,300,30);
            add(c1);
            
            l4=new JLabel("Address");
            l4.setFont(new Font("Arial",Font.BOLD,20));
            l4.setBounds(30,330,150,30);
            l4.setBackground(Color.WHITE);
            add(l4);
            
            a1=new JTextArea();
            a1.setFont(new Font("Arial",Font.BOLD,14));
            a1.setBackground(Color.white);
            a1.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
            a1.setBounds(190,300,300,100);
            add(a1);
            
            
            l5=new JLabel("Description");
            l5.setFont(new Font("Arial",Font.BOLD,20));
            l5.setBounds(30,460,150,30);
            l5.setBackground(Color.WHITE);
            add(l5);
            
            a2=new JTextArea();
            a2.setFont(new Font("Arial",Font.BOLD,14));
            a2.setBackground(Color.white);
            a2.setBorder(BorderFactory.createLineBorder(new Color(153, 153, 153)));
            a2.setBounds(190,415,300,120);
            add(a2);
            
            
         
            
            ImageIcon i2=new ImageIcon("C:\\Users\\snagr\\OneDrive\\Documents\\NetBeansProjects\\MCR\\src\\mcr\\lodge.png");
            sub=new JButton(i2);
            sub.setBounds(100,570,112,50);
            sub.setBorder(BorderFactory.createLineBorder(Color.white));
            sub.setBackground(Color.white);
            add(sub);
            sub.addActionListener(this);
            
            ImageIcon i4=new ImageIcon("C:\\Users\\snagr\\OneDrive\\Documents\\NetBeansProjects\\MCR\\src\\mcr\\admin.png");
            admin=new JButton(i4);
            admin.setBounds(515,615,64,64);
            admin.setBorder(BorderFactory.createLineBorder(Color.white));
            admin.setBackground(Color.white);
            add(admin);
            admin.addActionListener(this);
            
            ImageIcon i3=new ImageIcon("C:\\Users\\snagr\\OneDrive\\Documents\\NetBeansProjects\\MCR\\src\\mcr\\reset.png");
            clear=new JButton(i3);
            clear.setBounds(0,649,73,37);
            clear.setBorder(BorderFactory.createLineBorder(Color.white));
            clear.setBackground(Color.white);
            add(clear);
            clear.addActionListener(this);
            
            ImageIcon i5=new ImageIcon("C:\\Users\\snagr\\OneDrive\\Documents\\NetBeansProjects\\MCR\\src\\mcr\\cs.png");
            check_s=new JButton(i5);
            check_s.setBounds(280,570,220,50);
            check_s.setBorder(BorderFactory.createLineBorder(Color.white));
            check_s.setBackground(Color.white);
            check_s.addActionListener(this);
            add(check_s);
            
            getContentPane().setBackground(Color.white);
            setLayout(null);
            setSize(600,720);
            setLocation(420,0);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            
    }
    public void actionPerformed (ActionEvent e){
           
         if(e.getSource()==admin){
             new admin();
         }
        
        if(e.getSource()==clear){
            t1.setText("");
            t2.setText("");
            c1.setSelectedIndex(0);
            tf1.setText("");
            a1.setText("");
            a2.setText("");
            
        }
        
         if(e.getSource()==sub){
            JFrame w=new JFrame();
            String p_n,name,m_id,department,address,descrip;
            name=t1.getText();
            p_n=t2.getText();
            m_id=tf1.getText();
            department=(String) c1.getSelectedItem();
            address=a1.getText();
            descrip=a2.getText();
       
          
            
            conn c=new conn();
             
            try{
           
               PreparedStatement ps=c.conn.prepareStatement("INSERT INTO details (`name`, `phone_no`, `mail_id`, `Department`, `address`, `descp`) values(?,?,?,?,?,?);");
               ps.setString(1,name);
               ps.setString(2,p_n);
               ps.setString(3,m_id);
               ps.setString(4,department);
               ps.setString(5,address);
               ps.setString(6,descrip);
             
                          
            int x=ps.executeUpdate();
               
             if (x==1) {
            ImageIcon q=new ImageIcon("C:\\Users\\snagr\\OneDrive\\Documents\\NetBeansProjects\\MCR\\src\\mcr\\check.png");
            JOptionPane.showMessageDialog(w,"Received your complaint\nComplaint No.: "+p_n,"THANK YOU!",JOptionPane.INFORMATION_MESSAGE,q);
            w.setSize(300,300);
            }
           }
           catch(Exception exc){
                System.out.println(exc);
           }
            
            
         }
         
         if(e.getSource()==(check_s)){
             new check_status();
         }
    }
    
    public static void main(String[] args) {
        new Main();
       
    }
    
}
