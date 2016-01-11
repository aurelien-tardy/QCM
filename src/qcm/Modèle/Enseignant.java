/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Modèle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import qcm.Controleur.Connexion;


/**
 *
 * @author aurélien
 */
public class Enseignant {
    String nom;
    String prenom;
    ArrayList<QCM> tabQCM;
    Connexion c;
    
    Enseignant(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        tabQCM  = new ArrayList();
        c = new Connexion("qcm.sqlite");
    }
    
    //Creer un QCM
    void createQCM(String nom, String tag){
        QCM q = new QCM(nom,tag);
    }
    
    // Ajoute un QCM creer a la liste des QCM de l'enseignant
    void addQCM(QCM q){
        tabQCM.add(q);
        this.addToBD(q);
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
    
    //Fonction permettant d'afficher les notes de tous les Qcm que le prof à créer ainsi que l'étudiant qui a répondu.
    public void afficherNotes(){
        try{
            c.connect();
            String requete = "SELECT Etudiant.nom, Etudiant.prenom, Note.note, Qcm.nom AS nomQCM"
                    + " FROM Etudiant INNER JOIN Note ON Etudiant.id = Note.idEtudiant"
                    + " INNER JOIN Qcm ON Note.idQcm = Qcm.id"
                    + " INNER JOIN Enseignant ON Qcm.idEnseignant = Enseignant.id"
                    + " WHERE Enseignant.nom LIKE '"+nom+"' AND Enseignant.prenom LIKE '"+prenom+"'";       
            ResultSet r = c.query(requete);
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
            c.connect();
            //Recuperation de l'id prof
            String requete = "SELECT id FROM Enseignant";       
            ResultSet r = c.query(requete);
            r.next();
            idprof =r.getInt("id");
            //Insersion du qcm dans la base de donnée
            requete = "INSERT INTO Qcm VALUES("+idprof+",NULL,'"+q.getNom()+"','"+q.getTag()+"','"+q.getFiliere()+")";
            c.update(requete);
            //recuperation de l'id QCM
            requete = "SELECT id FROM Qcm WHERE nom LIKE '"+q.getNom()+"'";
            r = c.query(requete);
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
            for(Question x:q.getQuestions()){
                requete = "INSERT INTO Question VALUES('"+idQcm+"',NULL,'"+x.getIntitule()+"')";
                c.update(requete);
                requete = "SELECT id FROM Question WHERE idQcm ="+idQcm+" AND enonce LIKE '"+x.getIntitule()+"'";
                r = c.query(requete);
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
            for(Choix x:q.getTabChoix()){
                requete = "INSERT INTO Choix VALUES('"+idQuestion+"',NULL,'"+x.getNom()+"','"+x.isJuste()+"')";
                c.update(requete);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}