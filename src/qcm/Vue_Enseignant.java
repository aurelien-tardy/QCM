/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author p1400336
 */
public class Vue_Enseignant extends JPanel{
    JPanel vue_enseignant;
    JLabel nom;
    JButton deconnexion;
    JButton creerQCM;
    
    public Vue_Enseignant() {
        this.setPreferredSize(new Dimension(800, 600));
        deconnexion = new JButton("deconnexion");
        creerQCM = new JButton("Nouveau QCM");
        nom = new JLabel("nom");
        

    }
    
    @Override
    public void paintComponent(Graphics g) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 2;
        gbc.gridy = 0;
        vue_enseignant.add(nom,gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        vue_enseignant.add(deconnexion,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        vue_enseignant.add(creerQCM,gbc);
        
        
        

        this.setVisible(true);
    }
   
}
