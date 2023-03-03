/**
 * 
 */
package com.m2i.biblioSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.biblioSpringBoot.bo.Livre;
import com.m2i.biblioSpringBoot.facade.LivreFacade;

/**
 * @author Administrateur
 *
 */
@Service
public class LivreService {

	@Autowired
	private LivreFacade livreFacade;

	public List<Livre> findAll() {
		return livreFacade.findAll();
	}

	public Livre get(Integer id) {
		Livre livre = null;
		livre = livreFacade.get(id);
		return livre;
	}

//	public List<Livre> findByTitle(String title) {
//		return livreFacade.findByTitle(title);
//	}

//	public List<Livre> findByCategorie(String categorie) {
//		return livreFacade.findByCategorie(categorie);
//	}

	public Livre update(Livre livre) {
		return livreFacade.save(livre);
	}

	public Livre save(Livre livre) {
		return livreFacade.save(livre);
	}

	public void delete(Integer id) {
		livreFacade.delete(id);
	}

	public void delete(Livre livre) {
		livreFacade.delete(livre);
	}

}
