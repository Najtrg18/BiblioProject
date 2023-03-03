package com.m2i.biblioSpringBoot.bo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "livre")
@DiscriminatorValue("Livre")
public class Livre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int livreId;

	@Column(name = "nom")
	private String titre;

	@Column(name = "description", length = 60, nullable = true, columnDefinition = "varchar(60) default 'blabla'")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<Avis> avis = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Categorie> categories = new ArrayList<>();

	/**
	 * 
	 */
	public Livre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param livreId
	 * @param nom
	 * @param description
	 * @param aen
	 * @param avis
	 * @param categories
	 */
	public Livre(int livreId, String titre, String description, List<Avis> avis) {
		super();
		this.livreId = livreId;
		this.titre = titre;
		this.description = description;
		this.avis = avis;
		// this.categories = categories;
	}

	public int getLivreId() {
		return livreId;
	}

	public void setLivreId(int livreId) {
		this.livreId = livreId;
	}

	public String getTitle() {
		return titre;
	}

	public void setTitle(String title) {
		this.titre = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

//	public List<Categorie> getCategories() {
//		return categories;
//	}
//
//	public void setCategories(List<Categorie> categories) {
//		this.categories = categories;
//	}

}
