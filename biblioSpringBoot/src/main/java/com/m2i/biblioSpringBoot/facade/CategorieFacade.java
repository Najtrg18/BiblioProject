/**
 * 
 */
package com.m2i.biblioSpringBoot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.biblioSpringBoot.bo.Categorie;
import com.m2i.biblioSpringBoot.dao.ICategorieDAO;

/**
 * @author Administrateur
 *
 */
@Service
public class CategorieFacade {

	@Autowired
	private ICategorieDAO categorieDAO;

	public List<Categorie> findAll() {
		return categorieDAO.findAll();
	}

	public Categorie get(Integer id) {
		return categorieDAO.getReferenceById(id);
	}

//	public List<Categorie> getCategoryByName(String name) {
//		return categorieDAO.findByName(name);
//	}
//
//	public List<Categorie> getCategoriesByProductName(String name) {
//		return categorieDAO.findByProductsName(name);
//	}

	public Categorie save(Categorie categorie) {
		return categorieDAO.save(categorie);
	}

	public void update(Categorie categorie) {
		categorieDAO.save(categorie);
	}

	public void delete(Integer id) {
		categorieDAO.deleteById(id);
	}
}
