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
public class Question {
 
    String intitule;
    ArrayList<Choix> tabChoix;
    
    
    
    Question(String intitule){
        this.intitule = intitule;
        tabChoix = new ArrayList();
    }
    
    //Creer un choix possible pour la question
    void createChoix(String nom, boolean juste){
        Choix c = new Choix(nom,juste);
    }
    
    //Ajoute le choix a la liste des choix
    void addChoix(Choix c){
        if(tabChoix.contains(c) == false)
            tabChoix.add(c);
    }
    
    
    // Supprime un choix de la liste
    boolean delChoix(int i){
        if(tabChoix.contains(tabChoix.get(i))){
            tabChoix.remove(i);
            return true;
        }
        return false;
    }
    
    //Remplace une Choix par une nouvelle
    void modifChoix(Choix q,Choix r){
        int x = tabChoix.indexOf(q);
        tabChoix.remove(q);
        tabChoix.add(x, r);
    }
    
    
}