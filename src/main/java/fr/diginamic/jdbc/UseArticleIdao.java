package fr.diginamic.jdbc;

import java.util.List;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Article;


import fr.diginamic.jdbc.dao.impl.ArticleIdao;


public class UseArticleIdao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Utiliser la classe ArticleIdao pour afficher la liste des Article
		 */

		try {
			ArticleIdao article = new ArticleIdao();
			getAffiche(article);
			addArticle(article);
			updateArticle(article);
			deleteArticle(article);

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	
	public static void getAffiche(Idao<Article> o) {
		o.extraire().forEach(ar -> System.out.println(ar.getRef() +'-'+ar.getDesignation()));
	}
	
	public static void addArticle(Idao<Article> o) {
		Article ar = new Article(11,"F05","Test",40.3,2);
		o.insert(ar);
	}
	
	public static void updateArticle(Idao<Article> o) {
		List <Article> maList = o.extraire();
		if(maList.size() > 0) {
			Article ancien = maList.get(0);
			Article nouveau = new Article(1,"F05","Article Modifier 2",40.3,2);
			o.update(ancien, nouveau);
		}
	}
	
	public static void deleteArticle(Idao<Article> o) {
		List <Article> maList = o.extraire();
		if(maList.size() > 0) {
			Article supp = maList.get(0);
			o.delete(supp);
		}
	}

}
