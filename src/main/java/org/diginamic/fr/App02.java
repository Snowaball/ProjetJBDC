package org.diginamic.fr;
import java.util.List;

import org.diginamic.fr.dao.FournisseurDao;
import org.diginamic.fr.model.Fournisseur;

public class App02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Fournisseur> maListe = FournisseurDao.getAll();
		
		for(Fournisseur fo : maListe) {
			System.out.println("Id : " +fo.getId()+ "Nom : "+ fo.getNom());
		}

	}

}
