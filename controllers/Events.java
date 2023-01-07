/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import db.MyDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import views.GUI;
import views.GUI_STAT;

/**
 *
 * @author mega
 */
public class Events implements ActionListener,MouseListener {
   public GUI gui;
   public GUI_STAT gui_stat;
   String id="";
   MyDB db;
   
   public Events(GUI gui) {
      this.gui=gui;
      db = new MyDB(this);
      db.remplirJtable(gui.model);
   }
   
    public Events(GUI_STAT gui_stat) {
      this.gui_stat=gui_stat;
      db = new MyDB(this);
  //    db.remplirJtable(gui.model);
      MyThread th = new MyThread(gui_stat);
      th.start();
   }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==gui.btnAdd)
        {
            db.add();
            db.remplirJtable(gui.model);
            System.out.println("add...");
        }
        if(e.getSource()==gui.btnDelete)
        {
            db.delete();
            db.remplirJtable(gui.model);
            
            System.out.println("Delete...");
        }
        if(e.getSource()==gui.btnUpdate)
        {   
            db.update(id);
            db.remplirJtable(gui.model);
            System.out.println("Update...");
        }
        if(e.getSource()==gui.bstat)
        {
             GUI_STAT gs = new GUI_STAT();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int pos=gui.tab.getSelectedRow();
        String nom= gui.model.getValueAt(pos, 1).toString();
        String adresse= gui.model.getValueAt(pos, 2).toString();
        id=gui.model.getValueAt(pos, 0).toString();
        gui.tnom.setText(nom);
        gui.adresse.setSelectedItem(adresse);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
}
