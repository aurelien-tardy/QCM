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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import qcm.Controleur.Connexion;
/**
 *
 * @author p1400336
 */
public class Vue_Enseignant extends JPanel{
    
    JMenuBar menu = new JMenuBar();
    JMenu creer = new JMenu("Creer");
    JMenu modif = new JMenu("Modifier");
    JMenu supp = new JMenu("Supprimer");
    JMenu deco = new JMenu("Déconnexion");    
    JMenu vide = new JMenu("                                                                                                                                                                                 ");    
    JLabel nom = new JLabel("nom");
//    JButton deconnexion = new JButton("deconnexion");
//    JButton creerQCM = new JButton("Nouveau QCM");
//    ArrayList qcm = new ArrayList();
    Vue_Principale maFenetre;
    
    
    public Vue_Enseignant(Vue_Principale maF,String nom) {
        maFenetre = maF;
        this.nom.setText(nom);
        init(nom);
        this.setPreferredSize(new Dimension(800, 600));
        this.setVisible(true);        
        maFenetre.changePanel(this);
        

    }
    
    void init(String n){
        vide.setEnabled(false);
        maFenetre.setJMenuBar(menu);
        menu.add(creer);
        menu.add(modif);
        menu.add(supp);
        menu.add(vide);
        menu.add(deco);
        
        this.setLayout(null);
        this.add(nom);
        nom.setBounds(800-n.length()*7, 0, 200, 30);
        
        
//        this.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.fill = GridBagConstraints.BOTH;
//
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        this.add(nom,gbc);
//        gbc.gridx = 3;
//        gbc.gridy = 0;
//        this.add(deco,gbc);
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        this.add(creer,gbc);
//        
//        int i = 0;
//        Connexion connexion = new Connexion("qcm.sqlite");
//        connexion.connect();
//        ResultSet resultSet = connexion.query("SELECT * FROM Qcm");
//        try {
//            while (resultSet.next()) {
//                gbc.gridx = 0;
//                gbc.gridy = i+2;
//                this.add(new JLabel(resultSet.getString("nom")),gbc);
//                i++;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    
    @Override
    public void paintComponent(Graphics g) {
        
    }
}
