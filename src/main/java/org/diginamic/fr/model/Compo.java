package org.diginamic.fr.model;

public class Compo {
    private Integer id;
    private Integer id_art;
    private Integer id_bon;
    private Integer qte;
    
    public Compo(Integer id, Integer id_art, Integer id_bon, Integer qte) {
        super();
        this.id = id;
        this.id_art = id_art;
        this.id_bon = id_bon;
        this.qte = qte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_art() {
        return id_art;
    }

    public void setId_art(Integer id_art) {
        this.id_art = id_art;
    }

    public Integer getId_bon() {
        return id_bon;
    }

    public void setId_bon(Integer id_bon) {
        this.id_bon = id_bon;
    }

    public Integer getQte() {
        return qte;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }
}
