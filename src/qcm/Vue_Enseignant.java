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
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author p1400336
 */
public class Vue_Enseignant extends JPanel{
    
    JLabel nom = new JLabel("nom");
    JButton deconnexion = new JButton("deconnexion");
    JButton creerQCM = new JButton("Nouveau QCM");
    Fenetre maFenetre;
    
    
    public Vue_Enseignant(Fenetre maF) {
        maFenetre = maF;
        init();
        this.setPreferredSize(new Dimension(800, 600));
        this.setVisible(true);        
        maFenetre.changePanel(this);
        

    }
    
    void init(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 2;
        gbc.gridy = 0;
        this.add(nom,gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(deconnexion,gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(creerQCM,gbc);
        
//        int i = 0;
//        Connexion connexion = new Connexion("qcm.sqlite");
//        connexion.connect();
//        ResultSet resultSet = connexion.query("SELECT * FROM Qcm");
//        try {
//            while (resultSet.next()) {
//                gbc.gridx = 0;
//                gbc.gridy = i+2;
//                vue.add(new JLabel(resultSet.getString("nom")),gbc);
//                i++;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

//    
//    @Override
//    public void paintComponent(Graphics g) {
//        

}
