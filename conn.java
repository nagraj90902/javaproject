package mcr;

import java.sql.*;

/**
 *
 * @author snagr
 */
public class conn {
    Connection conn;
    Statement stmt;
    conn(){
        
        try{
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mcr","root","snraj123");
        stmt=conn.createStatement();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
}
