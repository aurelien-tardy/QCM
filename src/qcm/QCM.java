package qcm;

import java.util.ArrayList;

public class QCM {
    private String nom;
    private String tag;
    private ArrayList<Question> tabQuestion;
    private ArrayList<ArrayList<String>> reponse;  // Réponse du candidat.
    
    QCM(String nom,String tag){
        this.nom = nom;
        this.tag = tag;
        tabQuestion = new ArrayList();
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String getTag(){
        return this.tag;
    }
    
    public ArrayList<Question> getQuestions(){
        return this.tabQuestion;
    }
    
    
    
    //Creer une question 
    public void  createQuestion(String intitule){
        Question quest = new Question(intitule);
    }
    
    //Ajoute une question a la liste des question du QCM
    public void addQuestion(Question q){
        if(tabQuestion.contains(q) == false)
            tabQuestion.add(q);
    }
    
    //Supprime une question du QCM
    public boolean delQuestion(int i){
        if(tabQuestion.contains(tabQuestion.get(i))){
            tabQuestion.remove(i);
            return true;
        }
        return false;
    }
    
    //Remplace une question par une nouvelle
    public void modifQCM(Question q,Question r){
        int x = tabQuestion.indexOf(q);
        tabQuestion.remove(q);
        tabQuestion.add(x, r);
    }
    //Récupère la liste de bonnes réponses d'un QCM.
    public void qcmRep(){
        
        for (int i=0; i<this.getQuestions().size();i++){
             this.reponse.add(this.getQuestions().get(i).repjuste);
            
        }
    }
    
}
