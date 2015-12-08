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
    
    void addQuestion(Question q){
        if(tabQuestion.contains(q) == false)
            tabQuestion.add(q);
    }
    
    boolean delQuestion(int i){
        if(tabQuestion.contains(tabQuestion.get(i))){
            tabQuestion.remove(i);
            return true;
        }
        return false;
    }
    
    void modifQuestion(Question q, int i){
        if(this.delQuestion(i))
            tabQuestion.add(i, q);
    }
    
}
