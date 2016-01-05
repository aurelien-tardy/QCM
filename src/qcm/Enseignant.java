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
            System.out.println(e.getMessage());
        } 
    }
    
    //Creer un QCM
    public void createQCM(String nom, String tag){
        QCM q = new QCM(nom,tag);
    }
    
    // Ajoute un QCM creer a la liste des QCM de l'enseignant
    public void addQCM(QCM q){
        tabQCM.add(q);
        this.addToBD(q);
    }
    
    //Supprime un QCM de la liste
    public void delQCM(QCM q){
        if(tabQCM.isEmpty() == false)
            tabQCM.remove(q);
    }
    
    // Remplace un QCM par un autre
    public void modifQCM(QCM q,QCM r){
        int x = tabQCM.indexOf(q);
        tabQCM.remove(q);
        tabQCM.add(x, r);
    }
    
    
    public QCM getQCM(int i){
        return tabQCM.get(i);
    }
    
    //Fonction permettant d'afficher les notes de tous les Qcm que le prof à créer ainsi que l'étudiant qui a répondu.
    public void afficherNotes(){
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
    
    //fonction permettant d'ajouter le QCM à la base de donnée
    private void addToBD(QCM q){
        try{
            int idprof= -1;
            int idQcm = -1;
            c = DriverManager.getConnection("jdbc:sqlite:qcm.sqlite");
            //Recuperation de l'id prof
            String requete = "SELECT id FROM Enseignant";       
            Statement st = c.createStatement();
            ResultSet r = st.executeQuery(requete);
            r.next();
            idprof =r.getInt("id");
            //Insersion du qcm dans la base de donnée
            requete = "INSERT INTO Qcm(idEnseignant,id,nom,tag) VALUES("+idprof+",NULL,'"+q.getNom()+"','"+q.getTag()+"')";
            st.executeUpdate(requete);//erreur
            //recuperation de l'id QCM
            requete = "SELECT id FROM Qcm WHERE nom LIKE '"+q.getNom()+"'";
            r = st.executeQuery(requete);
            r.next();
            idQcm = r.getInt("id");
            //ajout des question à la bd
            this.addQuestToBd(q, idQcm);
            
            c.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    //fonction permettant d'ajouter une question
    private void addQuestToBd(QCM q,int idQcm){
        String requete;
        int idQuestion=-1;
        ResultSet r ;
        try{
            Statement st = c.createStatement();
            for(Question x:q.getQuestions()){
                requete = "INSERT INTO Question VALUES('"+idQcm+"',NULL,'"+x.getIntitule()+"')";
                st.executeUpdate(requete);
                requete = "SELECT id FROM Question WHERE idQcm ="+idQcm+" AND enonce LIKE '"+x.getIntitule()+"'";
                r = st.executeQuery(requete);
                r.next();
                idQuestion = r.getInt("id");
                this.addRepToBd(x, idQuestion);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    private void addRepToBd(Question q,int idQuestion){
        String requete;
        try{
            Statement st = c.createStatement();
            for(Choix x:q.getTabChoix()){
                requete = "INSERT INTO Choix VALUES('"+idQuestion+"',NULL,'"+x.getNom()+"','"+x.isJuste()+"')";
                st.executeUpdate(requete);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
