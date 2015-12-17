/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author aurélien
 */
public class Fenetre extends JFrame implements ActionListener{
    JButton connexion;
    JPanel pan;
    
    
    public Fenetre() {
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
        pan.add(connexion);
        this.setContentPane(pan);
        
        connexion.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==connexion){
            this.setVisible(false);
            this.remove(pan);
            this.setContentPane(new Vue_Connexion());
            this.setVisible(true);
            this.pack();
        }
    }
     
}
