/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import controllers.Events;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mega
 */
public class MyDB {
    
   public Events evt;
   public Connection con=null;
   public Statement stm;
   public int res;
    
    public MyDB(Events evt)
    {
        this.evt=evt;
        getCnx();
    }
    
    public MyDB()
    {
        getCnx();
    }
    
    
    public void getCnx()
    {
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("driver error !");
            }
            
            con =  DriverManager.getConnection("jdbc:mysql://localhost/madb","root","root");
        } catch (SQLException ex) {
            Logger.getLogger(MyDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("not connected !");
            
        }
    }
    
    public void remplirJtable (DefaultTableModel model){
        model.setRowCount(0);
        try{
            stm = con.createStatement();
            
        }catch(SQLException e) {
            System.out.println("error stm " + e.getMessage());
        }
        
        try{
            ResultSet rs =stm.executeQuery("select * from user");
            while (rs.next())
            {
                model.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3)
                
                });
            }
            
        }catch(SQLException e){
            System.out.println("error ! "+ e.getMessage());
        }
    }
    
     public void getSelected (DefaultTableModel model){
      
            int column = 0;
            int row = evt.gui.tab.getSelectedRow();
            String value = evt.gui.tab.getModel().getValueAt(row, column).toString();
        
    }
    

  
    public void add()
    {
        
        try {
        String sql = "insert into user (nom, adresse) values ('"+evt.gui.tnom.getText()+"','"+evt.gui.adresse.getSelectedItem()+"');";
        /*PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, "ee" );
        statement.setString(2, "gg");*/
        stm = con.createStatement();
        stm.executeUpdate(sql);
        }
        catch(SQLException e) {
            
            System.out.println(" CRUD error");
            System.out.println(e);
        }
    }
    
    public void delete()
    {
        
        try {
        
        String sql = "delete from user where nom= '"+evt.gui.tnom.getText()+"'";
   
        stm = con.createStatement();
        stm.executeUpdate(sql);
        }
        catch(SQLException e) {
            
            System.out.println(" CRUD error");
            System.out.println(e.getMessage());
        }
        
    }
    
    public void update(String id)
    {
        try {
        String sql = "update user set nom = '"+evt.gui.tnom.getText()+"', adresse = '"+evt.gui.adresse.getSelectedItem()+"' where id="+id;
        stm = con.createStatement();
        stm.executeUpdate(sql);
        }
        catch(SQLException e) {
            
            System.out.println(" CRUD error");
            System.out.println(e);
        }
    }
    
}
