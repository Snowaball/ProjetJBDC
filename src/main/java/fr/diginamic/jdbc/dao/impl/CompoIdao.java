package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Compo;

public class CompoIdao implements Idao<Compo> {
	private Connection connexion = null;

	public CompoIdao() throws Exception {
		connexion = TestConnexionJdbc.getConnection();
	}
	
	public void close() throws Exception {
		if (connexion != null && connexion.isClosed() == false) {
			connexion.close();
		}
	}

    @Override
    public List<Compo> extraire() {
        List<Compo> listeDesCompo = new ArrayList<Compo>();
        try {
            PreparedStatement stat = connexion.prepareStatement("SELECT ID,ID_ART,ID_BON,QTE FROM COMPO");
            ResultSet curseur = stat.executeQuery();
            while (curseur.next()) {
                /**
                 * Je veux récupérer la colonne ID et la colonne Nom de ma table la stocker dans
                 * un objet de type Fournisseur et la mettre dans notre Liste
                 */
                Compo co = new Compo(curseur.getInt(1), curseur.getInt(1), curseur.getInt(1), curseur.getInt(1));
                listeDesCompo.add(co);

            }
            /**
             * Je ferme dans l'ordre mon ResulSet puis mon Statement
             */
            curseur.close();
            stat.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return listeDesCompo;
    }
    
    @Override
    public void insert(Compo data) {
        try {
            PreparedStatement stat = connexion.prepareStatement("INSERT INTO COMPO (ID_ART,ID_BON,QTE) VALUES (?,?,?)");
            stat.setInt(1, data.getId_art());
            stat.setInt(2, data.getId_bon());
            stat.setInt(3, data.getQte());
            int co = stat.executeUpdate();
            stat.close();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public int update(Compo ancienData, Compo nouveauData) {
        try {
            PreparedStatement stat = connexion.prepareStatement("UPDATE COMPO SET ID_ART = ?,ID_BON = ?,QTE = ? WHERE ID = ?");
            stat.setInt(1, nouveauData.getId_art());
            stat.setInt(2, nouveauData.getId_bon());
            stat.setInt(3, nouveauData.getQte());
            stat.setInt(4, ancienData.getId());
            int co = stat.executeUpdate();
            stat.close();

            return co;

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return 0;
    }

    @Override
    public boolean delete(Compo data) {
        try {
            PreparedStatement stat = connexion.prepareStatement("DELETE FROM COMPO WHERE ID=?");
            stat.setInt(1, data.getId());
            int co = stat.executeUpdate();
            stat.close();

            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

}

