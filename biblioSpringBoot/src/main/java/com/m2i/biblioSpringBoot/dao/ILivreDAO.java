package com.m2i.biblioSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.biblioSpringBoot.bo.Livre;

@Repository
public interface ILivreDAO extends JpaRepository<Livre, Integer> {

	// public List<Livre> findByTitle(String title);

	// public List<Livre> findByCategorie(String categorie);

}