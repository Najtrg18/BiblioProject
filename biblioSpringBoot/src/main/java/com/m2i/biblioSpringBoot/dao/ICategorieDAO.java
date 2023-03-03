package com.m2i.biblioSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.biblioSpringBoot.bo.Categorie;

@Repository
public interface ICategorieDAO extends JpaRepository<Categorie, Integer> {

	// public List<Categorie> findByName(String name);

	// public List<Categorie> findByProductsName(String name);

}