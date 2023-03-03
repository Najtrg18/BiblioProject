package com.m2i.biblioSpringBoot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.m2i.biblioSpringBoot.bo.Avis;

@Repository
public interface IAvisDAO extends JpaRepository<Avis, Integer> {

	// public List<Avis> findByContentContaining(String expression);

}