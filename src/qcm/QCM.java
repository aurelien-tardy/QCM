/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.util.ArrayList;

/**
 *
 * @author aurélien
 */
public class QCM {
    String nom;
    String tag;
    ArrayList<Question> tabQuestion;
    
    QCM(String nom,String tag){
        this.nom = nom;
        this.tag = tag;
        tabQuestion = new ArrayList();
    }
    
    String getTag(){
        return this.tag;
    }
    
    //Creer une question 
    void  createQuestion(String intitule){
        Question quest = new Question(intitule);
    }
    
    //Ajoute une question a la liste des question du QCM
    void addQuestion(Question q){
        if(tabQuestion.contains(q) == false)
            tabQuestion.add(q);
    }
    
    //Supprime une question du QCM
    boolean delQuestion(int i){
        if(tabQuestion.contains(tabQuestion.get(i))){
            tabQuestion.remove(i);
            return true;
        }
        return false;
    }
    
    //Remplace une question par une nouvelle
    void modifQCM(Question q,Question r){
        int x = tabQuestion.indexOf(q);
        tabQuestion.remove(q);
        tabQuestion.add(x, r);
    }
    
}