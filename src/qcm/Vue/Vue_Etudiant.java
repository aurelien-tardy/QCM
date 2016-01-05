/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author aurélien
 */
public class Vue_Etudiant extends JPanel {

    Vue_Principale maFenetre;

    public Vue_Etudiant(Vue_Principale maF) {
        maFenetre = maF;
        this.setPreferredSize(new Dimension(800, 600));
        

        maFenetre.changePanel(this);
       
    }

    @Override
    public void paintComponent(Graphics g) {
        g.fillOval(75, 75, 75, 75);
    }
}
