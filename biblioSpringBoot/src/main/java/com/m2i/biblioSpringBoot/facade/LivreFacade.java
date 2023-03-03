package com.m2i.biblioSpringBoot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m2i.biblioSpringBoot.bo.Livre;
import com.m2i.biblioSpringBoot.dao.ILivreDAO;

@Component
public class LivreFacade {

	@Autowired
	private ILivreDAO livreDAO;

	public List<Livre> findAll() {
		return livreDAO.findAll();
	}

	public Livre get(Integer id) {
		Livre livre = null;
		livre = livreDAO.getReferenceById(id);
		return livre;
	}

//	public List<Livre> findByTitle(String title) {
//		return livreDAO.findByTitle(title);
//	}

//	public List<Livre> findByCategorie(String categorie) {
//		return livreDAO.findByCategorie(categorie);
//	}

	public Livre update(Livre livre) {
		return livreDAO.save(livre);
	}

	public Livre save(Livre livre) {
		return livreDAO.save(livre);
	}

	public void delete(Integer id) {
		livreDAO.deleteById(id);
	}

	public void delete(Livre livre) {
		livreDAO.delete(livre);
	}
}