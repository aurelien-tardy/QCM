/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import qcm.Modèle.Images;

/**
 *
 * @author aurélien
 */
public class Vue_Principale extends JFrame implements ActionListener{
    JButton connexion,test;
    JPanel pan;
    
    
    public Vue_Principale() {
        this.setTitle("QCM");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        

        initialisation();
        
        this.setVisible(true);
    }
    
     private void initialisation() {
        //création des composants
        pan = new Images();
        connexion = new JButton("Connexion");
        test = new JButton("TEST");
        pan.add(connexion);
        pan.add(test);
        this.setContentPane(pan);
        
        connexion.addActionListener(this);
        test.addActionListener(this);


    }
     
     public void changePanel(Container c){
         this.setVisible(false);
         this.setContentPane(c);
         this.setVisible(true);
         this.pack();
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==connexion){
            this.setVisible(false);
            this.remove(pan);
            this.setContentPane(new Vue_Connexion(this));
            this.setVisible(true);
            this.pack();
        }
        if(e.getSource()==test){
            this.setVisible(false);
            this.remove(pan);
            this.setContentPane(new Vue_Test(this));
            this.setVisible(true);
            this.pack();
        }
    }
     
}
