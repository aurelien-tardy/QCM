/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aurélien
 */
public class Vue_Connexion extends JPanel {

    JButton connexion;
    JComboBox statut;
    JLabel label_id, label_mdp;
    JTextField text_id, text_mdp;

    public Vue_Connexion() {
        this.setPreferredSize(new Dimension(800, 600));
        connexion = new JButton("Se Connecter");
        String tab[] = {"Etudiant", "Enseignant"};
        statut = new JComboBox(tab);
        label_id = new JLabel("Identifiant :");
        label_mdp = new JLabel("Mot de passe :");
        text_id = new JTextField("");
        text_id.setPreferredSize(new Dimension(120,24));
        text_mdp = new JTextField("");
        text_mdp.setPreferredSize(new Dimension(120,24));

    }

    @Override
    public void paintComponent(Graphics g) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(label_id, gbc);

        gbc.gridy = 1;
        this.add(text_id, gbc);

        gbc.gridy = 2;
        this.add(label_mdp, gbc);

        gbc.gridy = 3;
        this.add(text_mdp, gbc);

        gbc.gridy=4;
        this.add(statut,gbc);
        
        gbc.gridy = 5;
        this.add(connexion, gbc);

        this.setVisible(true);
    }

}
