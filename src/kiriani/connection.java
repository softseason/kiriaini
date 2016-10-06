/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kiriani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KINUTHIA
 */
public class connection {
 static String constring = "jdbc:mysql://localhost:3306/kiriaini";
 static String username = "root";
 static String password = "";
 
 
  public boolean Insert(String sql){
     try
     {
        Connection con = DriverManager.getConnection(constring, username, password);
        //prepare stmnset
        Statement s = con.prepareStatement(sql);
        s.execute(sql);
        return true;
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         return false;
     } 
  }    
  
  
  public DefaultTableModel PopulateTable(String sql){
     Connection con = null;
     Statement s = null;
     try{
        con = DriverManager.getConnection(constring, username, password); 
        s = con.prepareStatement(sql);       
        ResultSet rs = s.executeQuery(sql);
        ResultSetMetaData metadata = rs.getMetaData();
        
        Vector<String> ColumNames = new Vector<String>();
        int ColumnCount = metadata.getColumnCount();
        
        for(int column=1; column<=ColumnCount; column++){
            ColumNames.add(metadata.getColumnName(column));
        }
        //names of columns
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        
        while(rs.next()){
           Vector<Object> vector = new Vector<Object>(); 
           
           for(int columindex=1; columindex<=ColumnCount; columindex++){
               vector.add(rs.getObject(columindex));
           }
           data.add(vector);
        }
        
        return new DefaultTableModel(data, ColumNames);
     }catch(Exception e){
         new JOptionPane().showMessageDialog(null, e);
         return null;
     }finally{
         try{
            if(con!=null){
                con.close();
            }
            if(s!=null){
                s.close();
            }
         }catch(Exception e){
           e.printStackTrace();
         }
     }
}
  
}
