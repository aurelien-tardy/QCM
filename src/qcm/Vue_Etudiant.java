/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import qcm.Images;

/**
 *
 * @author aurélien
 */
public class Vue_Etudiant extends JPanel{
   
    Fenetre maFenetre;
    
    public Vue_Etudiant(Fenetre maF){
        maFenetre = maF;
         this.setPreferredSize(new Dimension(800, 600));
          this.setVisible(true);
          maFenetre.changePanel(this);
    }
    
     @Override
    public void paintComponent(Graphics g) {
        g.fillOval(75, 75, 75, 75);
    }
}
