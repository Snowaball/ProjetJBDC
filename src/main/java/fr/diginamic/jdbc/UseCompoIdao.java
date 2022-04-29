package fr.diginamic.jdbc;

import java.util.List;

import org.diginamic.fr.dao.Idao;
import org.diginamic.fr.model.Compo;

import fr.diginamic.jdbc.dao.impl.CompoIdao;

public class UseCompoIdao {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /**
         * Utiliser la classe CompoIdao pour afficher la liste des Compo
         */
        try {
            CompoIdao compo = new CompoIdao();
            addCompo(compo);
            updateCompo(compo);
            getAffiche(compo);
            deleteCompo(compo);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    
    public static void getAffiche(Idao<Compo> o) {
        o.extraire().forEach(co -> System.out.println(co.getId_art()));
    }

    public static void addCompo(Idao<Compo> o) {
        Compo co = new Compo(20, 15, 6, 22);
        o.insert(co);
    }

    public static void updateCompo(Idao<Compo> o) {
        List<Compo> maListe = o.extraire();
        if (maListe.size() > 0) {
            Compo ancien = maListe.get(0);
            Compo nouveau = new Compo(2, 5, 3, 3);
            o.update(ancien, nouveau);
        }
    }

    public static void deleteCompo(Idao<Compo> o) {
        List<Compo> maList = o.extraire();
        if (maList.size() > 0) {
            Compo supp = maList.get(0);
            o.delete(supp);
        }
    }

}
