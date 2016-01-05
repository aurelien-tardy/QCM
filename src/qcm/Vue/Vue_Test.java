/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Vue;

import qcm.Controleur.Connexion;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 *
 * @author aurélien
 */
public class Vue_Test extends JPanel {

    Vue_Principale maFenetre;

    public Vue_Test(Vue_Principale maF) {
        maFenetre = maF;
        this.setPreferredSize(new Dimension(800, 600));

        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        int nb_choix = 0;

        Connexion maConnexion = new Connexion("qcm.sqlite");
        maConnexion.connect();
        String request = "SELECT count(*) FROM Qcm INNER JOIN Question ON Qcm.id = Question.idQcm"
                + " INNER JOIN Choix ON Question.id = Choix.idQuestion WHERE Question.id = 1";
        System.out.println(request);
        ResultSet result = maConnexion.query(request);

        try {
            while (result.next()) {
                nb_choix = result.getInt("count(*)");
                System.out.println(nb_choix);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
