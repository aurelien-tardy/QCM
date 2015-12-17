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
public class Enseignant {
    String nom;
    String prenom;
    ArrayList<QCM> tabQCM;
    
    Enseignant(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        tabQCM  = new ArrayList();
    }
    
    void createQCM(String nom, String tag){
        QCM q = new QCM(nom,tag);
        addQCM(q);
    }
    
    void addQCM(QCM q){
        tabQCM.add(q);
    }
    
    void delQCM(QCM q){
        if(tabQCM.isEmpty() == false)
            tabQCM.remove(q);
    }
    
    void modifQCM(QCM q,QCM r){
        int x = tabQCM.indexOf(q);
        tabQCM.remove(q);
        tabQCM.add(x, r);
    }
    
    QCM getQCM(int i){
        return tabQCM.get(i);
    }
}
