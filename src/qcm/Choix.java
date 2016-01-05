
package qcm;

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
