package org.diginamic.fr.model;

public class Article {

	private Integer id;
	private String ref;
	private String designation;
	private Double prix;
	private Integer id_fou;
	
	public Article(Integer id, String ref, String designation, Double prix, Integer i) {
		super();
		this.id = id;
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
		this.id_fou = i;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getId_fou() {
		return id_fou;
	}

	public void setId_fou(Integer id_fou) {
		this.id_fou = id_fou;
	}
}
