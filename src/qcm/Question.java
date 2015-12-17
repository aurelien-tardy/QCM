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
    
    void createChoix(String nom, boolean juste){
        Choix c = new Choix(nom,juste);
        addChoix(c);
    }
    
    
    void addChoix(Choix c){
        if(tabChoix.contains(c) == false)
            tabChoix.add(c);
    }
    
    
    
    
}
