/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.Events;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mega
 */
public class GUI extends JFrame {
    
     JMenu menu, submenu;  
          JMenuItem i1, i2, i3, i4, i5;  
    
   public JLabel lnom = new JLabel ("Nom");
   public JTextField tnom = new JTextField();
   public JLabel lville = new JLabel("Ville");
   String villes[] ={"Sousse","Tunis"};
   public JComboBox adresse = new JComboBox(villes);
   String entete[]={"id","Nom","Adresse"};
                public DefaultTableModel model= new DefaultTableModel((entete),0);
                public JTable tab = new JTable(model);
                public JScrollPane sp = new JScrollPane(tab);
   public JButton btnDelete = new JButton("Delete");
   public JButton btnUpdate = new JButton("Update");
   public JButton btnAdd = new JButton("Add");
   public JButton bstat = new JButton("Statistics");
     
    
    public GUI() {
       this.setTitle("BD1");
       this.setSize(500, 500);
       this.setLocationRelativeTo(this.getParent());
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       JPanel pnorth = new JPanel(new GridLayout(2,2));
            pnorth.add(lnom);
            pnorth.add(tnom);
            pnorth.add(lville);
            pnorth.add(adresse);
            
       JPanel psouth = new JPanel(new GridLayout(2,3));
              psouth.add(btnDelete);
              psouth.add(btnUpdate);
              psouth.add(btnAdd);
              psouth.add(bstat);
              
              Container c = getContentPane();
                c.setLayout(new BorderLayout());
                c.add("North",pnorth);
                c.add("Center",sp);
                c.add("South",psouth);
                
            //sending actions to Events   
            Events evt = new Events(this);
            btnAdd.addActionListener(evt);
            btnDelete.addActionListener(evt);
            btnUpdate.addActionListener(evt);
            tab.addMouseListener(evt);
            bstat.addActionListener(evt);
                    
       
       /*   JMenuBar mb=new JMenuBar();  
          menu=new JMenu("Menu");  
          submenu=new JMenu("Sub Menu");  
          i1=new JMenuItem("Item 1");  
          i2=new JMenuItem("Item 2");  
          i3=new JMenuItem("Item 3");  
          i4=new JMenuItem("Item 4");  
          i5=new JMenuItem("Item 5");  
          menu.add(i1); menu.add(i2); menu.add(i3);  
          submenu.add(i4); submenu.add(i5);  
          menu.add(submenu);  
          mb.add(menu); 
            
          this.setJMenuBar(mb);*/
            
            
        
      this.setVisible(true);   
    
    }
    
    public static void main(String[] args) {
        new GUI();
    }
    
    
}
