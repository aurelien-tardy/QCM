package qcm.Controleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

    private String DBPath = "Chemin aux base de donnée SQLite";
    private Connection connection = null;
    private Statement statement = null;

    public Connexion(String dBPath) {
        DBPath = dBPath;
    }

    public void connect() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a " + DBPath + " avec succès");
        } catch (ClassNotFoundException notFoundException) {
            notFoundException.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("Erreur de connexion");
        }

    }

    public void close(){
         try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet query(String requet) {
        ResultSet resultat = null;
        try {
            resultat = statement.executeQuery(requet);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur dans la requete : " + requet);
        }
        return resultat;

    }
    
    public boolean update(String requet){
        try{
            statement.executeUpdate(requet);
            return true;
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Erreur dans la requete : " + requet);
            return false;
        }
    }
}
