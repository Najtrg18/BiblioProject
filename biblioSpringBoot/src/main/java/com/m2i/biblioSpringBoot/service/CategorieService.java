/**
 * 
 */
package com.m2i.biblioSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.biblioSpringBoot.bo.Categorie;
import com.m2i.biblioSpringBoot.facade.CategorieFacade;

/**
 * @author Administrateur
 *
 */
@Service
public class CategorieService {

	@Autowired
	private CategorieFacade categorieFacade;

	public List<Categorie> findAll() {
		return categorieFacade.findAll();
	}

	public Categorie get(Integer id) {
		return categorieFacade.get(id);
	}

//	public List<Categorie> getCategoryByName(String name) {
//		return categorieFacade.getCategoryByName(name);
//	}
//
//	public List<Categorie> getCategoriesByProductName(String name) {
//		return categorieFacade.getCategoriesByProductName(name);
//	}

	public Categorie save(Categorie categorie) {
		return categorieFacade.save(categorie);
	}

	public void update(Categorie categorie) {
		categorieFacade.save(categorie);
	}

	public void delete(Integer id) {
		categorieFacade.delete(id);
	}

}
