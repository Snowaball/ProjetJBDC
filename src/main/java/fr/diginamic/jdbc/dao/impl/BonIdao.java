package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Bon;


public class BonIdao implements Idao<Bon> {
    
	private Connection connexion = null;
    
    public BonIdao() throws Exception {
        connexion = TestConnexionJdbc.getConnection();
    }

    public void close() throws Exception {
        if (connexion != null && connexion.isClosed() == false) {
            connexion.close();
        }
    }

    @Override
    public List<Bon> extraire() {

        List<Bon> listeDesBons = new ArrayList<Bon>();
        try {
            PreparedStatement stat = connexion.prepareStatement("SELECT ID,NUMERO,DATE_CMDE,DELAI,ID_FOU FROM BON");
            ResultSet curseur = stat.executeQuery();
            while (curseur.next()) {
                
                Bon bo = new Bon(curseur.getInt(1), 
                		curseur.getInt(1), 
                		curseur.getString("DATE_CMDE"), 
                		curseur.getInt(1), 
                		curseur.getInt(1));
                listeDesBons.add(bo);

            }
           
            curseur.close();
            stat.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return listeDesBons;
    }
    @Override
    public void insert(Bon data) {
        try {
            PreparedStatement stat = connexion.prepareStatement("INSERT INTO BON (NUMERO,DATE_CMDE,DELAI,ID_FOU) VALUES (?,?,?,?)");
            stat.setInt(1, data.getNumero());
            stat.setString(2, data.getDate());
            stat.setInt(3, data.getDelai());
            stat.setInt(4, data.getId_fou());
            
            int bo = stat.executeUpdate();
            stat.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public int update(Bon ancienData, Bon nouveauData) {
        // TODO Auto-generated method stub
        try {
            PreparedStatement stat = connexion.prepareStatement("UPDATE BON SET NUMERO = ?,DATE_CMDE = ?,DELAI= ?,ID_FOU = ? WHERE ID = ?");
            stat.setInt(1, nouveauData.getNumero());
            stat.setString(2, nouveauData.getDate());
            stat.setInt(3, nouveauData.getDelai());
            stat.setInt(4, nouveauData.getId_fou());
            stat.setInt(5, ancienData.getId());
            int bo = stat.executeUpdate();
            stat.close();

            return bo;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return 0;
    }

    @Override
    public boolean delete(Bon data) {
        try {
            PreparedStatement stat = connexion.prepareStatement("DELETE FROM BON WHERE ID=?");
            stat.setInt(1, data.getId());
            int bo = stat.executeUpdate();
            stat.close();

            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}