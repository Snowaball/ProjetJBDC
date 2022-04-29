package org.diginamic.fr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;



/**
 * Cette Classe va me permettre de lire en JBDC la Table Fournisseur
 * et aussi d'avoir le sméthodes CRUD et d'obtenir des objets  de type Fournisseur
 * @author Hamza
 *
 */
public class FournisseurDao {
	
	/**
	 * Retourne la liste des Fournisseurs de ma base de donnée 
	 * @return
	 */
	public static List<Fournisseur> getAll() {
		Connection connection = null;
		List<Fournisseur> listeDesFournisseurs = new ArrayList<>();
		
		try {
			 connection = TestConnexionJdbc.getConnection();
			 
			 Statement stat = connection.createStatement();
			 ResultSet curseur = stat.executeQuery("SELECT * FROM FOURNISSEUR");
			 while(curseur.next()) {
				 /**
				  * Je veux récupérer la colonne ID et la colonne Nom de ma table
				  * la stocker dans un objet de type Fournisseur
				  * et la mettre dans notre list
				  */
				 
				 Fournisseur fo = new Fournisseur(curseur.getInt("ID"),
						 curseur.getString("NOM"));
				 listeDesFournisseurs.add(fo);
				 
			 }
			 /**
			  * Je ferme l'ordre mon ResultSet puis mon Statement
			  */
			 curseur.close();
			 stat.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null) connection.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
			
		}
		return listeDesFournisseurs;
	}
	
	public static void Insert(String name) {
        Connection connection = null;
        try {
                    connection = TestConnexionJdbc.getConnection();
                    Statement stat = connection.createStatement();
                    int nb = stat.executeUpdate("INSERT INTO FOURNISSEUR (NOM) VALUES ('"+name+"')");
                    stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
            if (connection != null) {
                connection.close();
            }
            } catch (Exception ex) {
            System.err.println(ex.getMessage());
            } 
        }
    }
	
	public static void Update(String name) {
        Connection connection = null;
        try {
                    connection = TestConnexionJdbc.getConnection();
                    Statement stat = connection.createStatement();
                    int nb = stat.executeUpdate("UPDATE FOURNISSEUR SET NOM='"+name+"' WHERE ID = 4");
                    stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
            if (connection != null) {
                connection.close();
            }
            } catch (Exception ex) {
            System.err.println(ex.getMessage());
            } 
        }
    }
	
	public static void Delete() {
        Connection connection = null;
        try {
                    connection = TestConnexionJdbc.getConnection();
                    Statement stat = connection.createStatement();
                    int nb = stat.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID=4");
                    stat.close();

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
            if (connection != null) {
                connection.close();
            }
            } catch (Exception ex) {
            System.err.println(ex.getMessage());
            } 
        }
    }

}
