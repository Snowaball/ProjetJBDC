package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Article;

public class ArticleIdao implements Idao<Article> {

	private Connection connexion = null;

	public ArticleIdao() throws Exception {
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
	public List<Article> extraire() {
		// TODO Auto-generated method stub
		List<Article> listeDesArticles = new ArrayList<Article>();
		try {
			PreparedStatement stat =
					connexion.prepareStatement("SELECT * FROM ARTICLE");
			ResultSet curseur =
					stat.executeQuery();
		
			while(curseur.next()) {
				Article article = new Article(curseur.getInt("ID"),
						curseur.getString("REF"),
						curseur.getString("DESIGNATION"),
						curseur.getDouble("PRIX"),
						curseur.getInt("ID_FOU")
						);
				listeDesArticles.add(article);

			}
			curseur.close();
			stat.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}

		return listeDesArticles;
		
	}
	
	@Override
	public void insert(Article data) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stat = connexion.prepareStatement("INSERT INTO ARTICLE (REF,DESIGNATION,PRIX,ID_FOU) VALUES (?,?,?,?)");
			stat.setString(1, data.getRef());
			stat.setString(2, data.getDesignation());
			stat.setDouble(3, data.getPrix());
			stat.setInt(4, data.getId_fou());
			int article = stat.executeUpdate();
			stat.close();

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	@Override
	public int update(Article ancienData, Article nouveauData) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stat = connexion.prepareStatement("UPDATE ARTICLE SET DESIGNATION = ? WHERE ID = ?");
			stat.setString(1, nouveauData.getDesignation());
			stat.setInt(2, ancienData.getId());
			int article = stat.executeUpdate();
			stat.close();

			return article;

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		return 0;
	}
	
	@Override
	public boolean delete(Article data) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stat = connexion.prepareStatement("DELETE FROM ARTICLE WHERE ID=?");
			stat.setInt(1, data.getId());
			int article = stat.executeUpdate();
			stat.close();

			return true;
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		return false;

	}
}
