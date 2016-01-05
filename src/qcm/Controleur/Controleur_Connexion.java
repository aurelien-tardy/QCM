/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aurélien
 */
public class Controleur_Connexion extends AbstractControleur {

    @Override
    public boolean control(ArrayList<String> list) {
        if (list.get(0) == "" || list.get(1) == "") {
            return false;
        }
        String status = list.get(2);
        String prenom,nom,isCo="";
        int i = list.get(0).lastIndexOf('.');
        prenom = list.get(0).substring(0, i);
        nom = list.get(0).substring(i+1);
        Connexion maConnexion = new Connexion("qcm.sqlite");
        maConnexion.connect();
        String request = "SELECT count(*) FROM " + status + " WHERE nom='"+nom+"' and prenom='"+prenom+"' and mdp='"+list.get(1)+"'";
        System.out.println(request);
        ResultSet result = maConnexion.query(request);
        
        try {
            while (result.next()) {
                isCo=result.getString("count(*)");
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if(Integer.decode(isCo)!=1) return false;
        
        maConnexion.close();
        return true;
    }

}
