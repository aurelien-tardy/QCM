/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import qcm.Controleur.Connexion;

/**
 *
 * @author aurélien
 */
public class Vue_Etudiant extends JPanel {

    Vue_Principale maFenetre;
    String nom,prenom,nom_prenom,filiere;

    public Vue_Etudiant(Vue_Principale maF, String nom) {
        this.nom_prenom=nom;
        int i = nom_prenom.lastIndexOf('.');
        prenom = nom_prenom.substring(0, i);
        nom = nom_prenom.substring(i+1);
        maFenetre = maF;
        this.setPreferredSize(new Dimension(800, 600));
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        int nb_choix = 0;

        Connexion maConnexion = new Connexion("qcm.sqlite");
        maConnexion.connect();
        String request = "SELECT filiere FROM Etudiant WHERE Etudiant.nom = '"+nom+"' AND Etudiant.prenom = '"+prenom+"'";
        ResultSet result = maConnexion.query(request);

        try {
            while (result.next()) {
                filiere = result.getString("filiere");
                System.out.println(filiere);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        request = "SELECT nom FROM QCM WHERE QCM.filiere = '"+filiere+"'";
        System.out.println(request);
         try {
            while (result.next()) {
                String a = result.getString("nom");
                System.out.println(a);
         
        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.pink);
        g.fillOval(75, 75, 75, 75);
    }
}
