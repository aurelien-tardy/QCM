/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

/**
 *
 * @author aurélien
 */
public class Choix {
    private String nom;
    private boolean juste;
    
    
    Choix(String nom, boolean juste){
        this.nom = nom;
        this.juste = juste;
    }

    public String getNom() {
        return nom;
    }

    public boolean isJuste() {
        return juste;
    }
    
}
