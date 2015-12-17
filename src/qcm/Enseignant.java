/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author aurélien
 */
public class Enseignant {
    private String nom;
    private String prenom;
    private ArrayList<QCM> tabQCM;
    private Connection c;
    
    Enseignant(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        tabQCM  = new ArrayList();
        try{
            Class.forName("org.sqlite.JDBC").newInstance();
        }
        catch(Exception e){
            
        } 
    }
    
    //Creer un QCM
    void createQCM(String nom, String tag){
        QCM q = new QCM(nom,tag);
    }
    
    // Ajoute un QCM creer a la liste des QCM de l'enseignant
    void addQCM(QCM q){
        tabQCM.add(q);
    }
    
    //Supprime un QCM de la liste
    void delQCM(QCM q){
        if(tabQCM.isEmpty() == false)
            tabQCM.remove(q);
    }
    
    // Remplace un QCM par un autre
    void modifQCM(QCM q,QCM r){
        int x = tabQCM.indexOf(q);
        tabQCM.remove(q);
        tabQCM.add(x, r);
    }
    
    
    QCM getQCM(int i){
        return tabQCM.get(i);
    }
    
    void afficherNotes(){
        try{
            c = DriverManager.getConnection("jdbc:sqlite:qcm.sqlite");
            String requete = "SELECT Etudiant.nom, Etudiant.prenom, Note.note, Qcm.nom AS nomQCM"
                    + " FROM Etudiant INNER JOIN Note ON Etudiant.id = Note.idEtudiant"
                    + " INNER JOIN Qcm ON Note.idQcm = Qcm.id"
                    + " INNER JOIN Enseignant ON Qcm.idEnseignant = Enseignant.id"
                    + " WHERE Enseignant.nom LIKE '"+nom+"' AND Enseignant.prenom LIKE '"+prenom+"'";       
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(requete);
            while(r.next()){
                System.out.println(r.getObject("nom")+" "+r.getObject("prenom")+" "+r.getObject("note")+" "+r.getObject("nomQCM"));
            }
            c.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
