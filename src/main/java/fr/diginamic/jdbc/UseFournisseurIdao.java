package fr.diginamic.jdbc;

import java.util.List;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Fournisseur;

import fr.diginamic.jdbc.dao.impl.FournisseurIdao;

public class UseFournisseurIdao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		* Utiliser la classe FournisseurIdao pour afficher la liste des Fournisseurs
		*/
		try {
		FournisseurIdao foi = new FournisseurIdao();
		getAffiche(foi);
		addFournisseur(foi);
		updateFournisseur(foi);
		deleteFournisseur(foi);
		getAffiche(foi);
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		}

		/**
		 * methode qui g�re un objet de type Idao<Fournisseur>
		 */
		public static void getAffiche(Idao<Fournisseur> o) {
			o.extraire().forEach(fo -> System.out.println(fo.getNom()));
		}
		
		public static void addFournisseur(Idao<Fournisseur> o) {
			Fournisseur fo = new Fournisseur(4,"La maison de la peinture");
			o.insert(fo);
		}
		
		public static void updateFournisseur(Idao<Fournisseur> o) {
			List <Fournisseur> maList = o.extraire();
			if(maList.size() > 0) {
				Fournisseur ancien = maList.get(0);
				Fournisseur nouveau = new Fournisseur(4,"Fournisseur Modifier");
				o.update(ancien, nouveau);
			}
		}
		
		public static void deleteFournisseur(Idao<Fournisseur> o) {
			List <Fournisseur> maList = o.extraire();
			if(maList.size() > 0) {
				Fournisseur supp = maList.get(0);
				o.delete(supp);
			}
		}
	
	

}
