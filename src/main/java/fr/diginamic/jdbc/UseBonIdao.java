package fr.diginamic.jdbc;

import java.util.List;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Bon;

import fr.diginamic.jdbc.dao.impl.BonIdao;

public class UseBonIdao {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         * Utiliser la classe FournisseurIdao pour afficher la liste des Fournisseurs
         */
        try {
            BonIdao bon = new BonIdao();
            addBon(bon);
            updateBon(bon);
            getAffiche(bon);
            deleteFB(bon);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }


    public static void getAffiche(Idao<Bon> o) {
        o.extraire().forEach(bon -> System.out.println(bon.getNumero()));
    }
    
    public static void addBon(Idao<Bon> o) {
        Bon bon = new Bon(7,7,"2022-04-29",1,1);
        o.insert(bon);
    }

	public static void updateBon(Idao<Bon> o) {
		List<Bon> maListe = o.extraire();
		if (maListe.size() > 0) {
			Bon ancien = maListe.get(0);
			Bon nouveau = new Bon(5, 5, "2022-05-05", 5, 5);
			o.update(ancien, nouveau);
		}
	}
    public static void deleteFB(Idao<Bon> o) {
        List <Bon> maListe = o.extraire();
        if(maListe.size() > 0) {
            Bon supp = maListe.get(6);
            o.delete(supp);
        }
    }

}
