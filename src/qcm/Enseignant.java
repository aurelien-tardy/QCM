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
    }
}
