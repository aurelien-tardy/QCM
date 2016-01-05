package qcm;

import java.util.ArrayList;

public class Question {
 
    String intitule;
    ArrayList<Choix> tabChoix;
    ArrayList<String> repjuste; 

    public String getIntitule() {
        return intitule;
    }

    public ArrayList<Choix> getTabChoix() {
        return tabChoix;
    }
    
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
    // Récupère les bonne réponses.
    void choixJuste(){
        for(int i=0; i<this.getTabChoix().size();i++){
            if(this.getTabChoix().get(i).isJuste()==true)
                repjuste.add(this.getTabChoix().get(i).getNom());
        }
    }
    
}
