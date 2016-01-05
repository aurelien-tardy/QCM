/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Modèle;

/**
 *
 * @author aurélien
 */
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class Images extends JPanel {
     
   @Override
    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("mon_image.png"));
            g.drawImage(img,0,0,800,600,this);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }
}