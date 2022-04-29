package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Fournisseur;

public class FournisseurIdao implements Idao<Fournisseur> {

	private Connection connexion = null;

	public FournisseurIdao() throws Exception {
		connexion = TestConnexionJdbc.getConnection();
	}

	public void close() throws Exception {
		if (connexion != null && connexion.isClosed() == false) {
			connexion.close();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		close();
	}

	@Override
	public List<Fournisseur> extraire() {
		List<Fournisseur> listeDesFournisseurs = new ArrayList<Fournisseur>();
		try {
			PreparedStatement stat =
					connexion.prepareStatement("SELECT ID,NOM FROM FOURNISSEUR");
			ResultSet curseur =
					stat.executeQuery();
		
			while(curseur.next()) {
				Fournisseur fo = new Fournisseur(curseur.getInt("ID"),
						curseur.getString("NOM"));
				listeDesFournisseurs.add(fo);

			}
			curseur.close();
			stat.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}

		return listeDesFournisseurs;
		}

		@Override
		public void insert(Fournisseur data) {
			// TODO Auto-generated method stub
			try {
				PreparedStatement stat = connexion.prepareStatement("INSERT INTO FOURNISSEUR (NOM) VALUES (?)");
				stat.setString(1, data.getNom());
				int nb = stat.executeUpdate();
				stat.close();

			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}

		}

		@Override
		public int update(Fournisseur ancienData, Fournisseur nouveauData) {
			// TODO Auto-generated method stub
			try {
				PreparedStatement stat = connexion.prepareStatement("UPDATE FOURNISSEUR SET NOM = ? WHERE ID = ?");
				stat.setString(1, nouveauData.getNom());
				stat.setInt(2, ancienData.getId());
				int nb = stat.executeUpdate();
				stat.close();

				return nb;

			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}

			return 0;
	}

	@Override
	public boolean delete(Fournisseur data) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stat = connexion.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID=?");
			stat.setInt(1, data.getId());
			int nb = stat.executeUpdate();
			stat.close();

			return true;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		return false;

	}
}



