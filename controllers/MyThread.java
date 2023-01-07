/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import db.MyDB;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import views.GUI_STAT;

/**
 *
 * @author mega
 */
public class MyThread extends Thread {
    MyDB db;
    GUI_STAT gui_stat;
    
    public MyThread(GUI_STAT gui_stat)
    {
        this.gui_stat=gui_stat;
        db  = new MyDB(); 
    }
    
    
    
    public void graph(Graphics g, Canvas cv,int nbrTot,int nbrS,int nbrT)
    {
            
        cv.update(g); // update t3awed tasna3 l graph ilou w jdid bech mat5alich li9dim fou9 ba3dhou
        
        double ph=(nbrS*100)/nbrTot;
        double pf=(nbrT*100)/nbrTot;

        String H = "Sousse : "+ String.valueOf(nbrS);
        String F = "Tunis : "+ String.valueOf(nbrT);
        String T = "Total : "+ String.valueOf(nbrTot);
        String nb = "Nbr \n"+ String.valueOf(nbrTot);

        g.setColor(Color.blue);
        g.drawString(H,16,16);
        g.fillRect(10,cv.getHeight() - (int)ph,70,(int)ph);

        g.setColor(Color.red);
        g.drawString(F,100,16);
        g.fillRect(90,cv.getHeight() - (int)pf,70,(int)pf);

        g.setColor(Color.green);
        g.drawString(nb,5,90);
        g.drawString(T,200,16);

        g.setColor(Color.green);
        g.drawLine(1, cv.getHeight(), 1, 120);


              
    }
    
    
    public void stat (Graphics g , Canvas cv)
    {
        int nbrS = 0; 
        int nbrT = 0;
        int nbrTot = 0;
        try {
           db.stm = db.con.createStatement();
        }
            catch (SQLException e)
            {
                System.out.println(e.getMessage());
            }
        
        try {
                ResultSet res = db.stm.executeQuery("select * from user");
                while(res.next()) {
                    nbrTot ++;
                    if (res.getString(3).equals("Sousse")) {
                        nbrS++;
                        
                    }
                    else if(res.getString(3).equals("Tunis")) {
                        nbrT++;
                    }
                }
            }
         catch (SQLException e)
                 {
                    System.out.println(e.getMessage());
                 }
       
        graph( g,cv, nbrTot, nbrS, nbrT);
        
    }
    
    
     public void run() {
        while(true) {
            
            stat(gui_stat.g, gui_stat.cv);
            
            try {sleep(200);}catch(Exception e) {}
        }
    }
    
}
