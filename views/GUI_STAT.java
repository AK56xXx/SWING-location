/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import controllers.Events;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author mega
 */
public class GUI_STAT extends JFrame {
    
    public Canvas cv = new Canvas();
    public Graphics g;
    
    
     public GUI_STAT() {
                             
                   this.setTitle("STATISTICS");
                   this.setSize(700,600);
                   this.setLocationRelativeTo(getParent());
                   this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                   
                   cv.setPreferredSize(new Dimension(700,600));
                   cv.setBackground(Color.black);
                   
                Container c = getContentPane();
		c.setLayout(new BorderLayout());
                 
                c.add("South",cv); 
                   
        
                    
                  setVisible(true);  
                  
                  /*************/
                  g=cv.getGraphics();
                  Events evt = new Events(this); 

                  /*************/
                  
              
    
}
     public static void main(String[] args) {
        new GUI_STAT();
    }
  
     
}
