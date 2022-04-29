package org.diginamic.fr.model;

public class Bon {
    private Integer id;
    private Integer numero;
    private String date;
    private Integer delai;
    private Integer id_fou;

	public Bon(Integer id, Integer numero, String date, Integer delai, Integer id_fou) {
		super();
		this.id = id;
		this.numero = numero;
		this.date = date;
		this.delai = delai;
		this.id_fou = id_fou;
	}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getDelai() {
        return delai;
    }
    public void setDelai(Integer delai) {
        this.delai = delai;
    }
    public Integer getId_fou() {
        return id_fou;
    }
    public void setId_fou(Integer id_fou) {
        this.id_fou = id_fou;
    }

}
