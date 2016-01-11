/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qcm.Vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import qcm.Controleur.Connexion;
/**
 *
 * @author p1400336
 */
public class Vue_Enseignant extends JPanel{
    
    JMenuBar menu = new JMenuBar();
    JMenu creer = new JMenu("Creer");
    JMenu modif = new JMenu("Modifier");
    JMenu supp = new JMenu("Supprimer");
    JMenu deco = new JMenu("Déconnexion");    
    JMenu vide = new JMenu("                                                                                                                                                                                 ");    
    JLabel nom = new JLabel("nom");
    String name = new String();
    ArrayList<String> listenom = new ArrayList<>();
    ArrayList<String> listetag = new ArrayList<>();
    ArrayList<String> listefiliere = new ArrayList<>();
    
    JList lister = new JList();
    
    String tab[];
    
    Vue_Principale maFenetre;
    
    
    public Vue_Enseignant(Vue_Principale maF,ArrayList<String> list) throws SQLException {
        maFenetre = maF;
        this.nom.setText((String) list.get(0));
        int i = list.get(0).lastIndexOf('.');
        name = list.get(0).substring(i+1);
        init((String)list.get(0));
        this.setPreferredSize(new Dimension(800, 600));
        this.setVisible(true);        
        maFenetre.changePanel(this);
        

    }
    
    void init(String n) throws SQLException{
        vide.setEnabled(false);
        maFenetre.setJMenuBar(menu);
        menu.add(creer);
        menu.add(modif);
        menu.add(supp);
        menu.add(vide);
        menu.add(deco);
        
        this.setLayout(null);
        this.add(nom);
        nom.setBounds(800-n.length()*7, 0, 200, 30);

        int i = 0;
        
        try {
            Connexion connexion = new Connexion("qcm.sqlite");
            connexion.connect();
            ResultSet result = connexion.query("select id from Enseignant where nom like '"+ name+"'");
            ResultSet resultSet = connexion.query("SELECT nom, tag, filiere FROM Qcm where idEnseigant = "+result.getInt("id"));
            
            while (resultSet.next()) {
                listenom.add(resultSet.getString("nom"));
                listetag.add(resultSet.getString("tag"));
                listefiliere.add(resultSet.getString("filiere"));
                i++;
            }
            tab = new String[listenom.size()];
            for(int j = 0; j<listenom.size();j++)
                tab[j] = listenom.get(j)+"     "+listetag.get(j)+"     "+listefiliere.get(j);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        lister.setListData(tab);
        
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setViewportView(lister);
        scrollPane.createVerticalScrollBar();
        scrollPane.setBounds(20, 20, 380, 560);
        this.add(scrollPane);
    }

    
    @Override
    public void paintComponent(Graphics g) {
        
    }
}
