package com.m2i.biblioSpringBoot.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avis")
/**
 * 
 * @author najwa
 *
 */
public class Avis {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avisId;

	@Column(name = "contenu")
	private String contenu;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "livre_id")
	private Livre livre;

}