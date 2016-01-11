/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import qcm.Controleur.Controleur_Connexion;

/**
 *
 * @author aurélien
 */
public class Vue_Connexion extends JPanel {

    JButton connexion;
    JComboBox statut;
    JLabel label_id, label_mdp;
    JTextField text_id, text_mdp;
    Controleur_Connexion control = new Controleur_Connexion();
    Vue_Principale maFenetre;

    public Vue_Connexion(Vue_Principale maF) {
        maFenetre = maF;
        this.setPreferredSize(new Dimension(800, 600));
        connexion = new JButton("Se Connecter");
        String tab[] = {"Etudiant", "Enseignant"};
        statut = new JComboBox(tab);
        label_id = new JLabel("Identifiant :");
        label_mdp = new JLabel("Mot de passe :");
        text_id = new JTextField("prenom.nom");
        text_id.setPreferredSize(new Dimension(120, 24));
        text_mdp = new JPasswordField("");
        text_mdp.setPreferredSize(new Dimension(120, 24));

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

        gbc.gridy = 4;
        this.add(statut, gbc);

        gbc.gridy = 5;
        this.add(connexion, gbc);
        this.setVisible(true);
                
        connexion.addActionListener(new ActionListener() {
     
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList list_form = new ArrayList();
                list_form.add(text_id.getText());
                list_form.add(text_mdp.getText());
                list_form.add(statut.getSelectedItem());
                if(control.control(list_form)){
                    if(statut.getSelectedItem() == "Etudiant")
                        maFenetre.changePanel(new Vue_Etudiant(maFenetre, text_id.getText()));
                    else
                        try {
                            maFenetre.changePanel(new Vue_Enseignant(maFenetre, list_form));
                    } catch (SQLException ex) {
                        Logger.getLogger(Vue_Connexion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
    }

    @Override
    public void paintComponent(Graphics g) {

    }

}
