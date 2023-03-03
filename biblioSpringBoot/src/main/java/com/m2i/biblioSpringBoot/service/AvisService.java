/**
 * 
 */
package com.m2i.biblioSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.biblioSpringBoot.bo.Avis;
import com.m2i.biblioSpringBoot.facade.AvisFacade;

/**
 * @author Administrateur
 *
 */
@Service
public class AvisService {

	@Autowired
	private AvisFacade avisFacade;

	public List<Avis> get() {
		return avisFacade.get();
	}

	public Avis get(Integer id) {
		return avisFacade.get(id);
	}

//	public List<Avis> getAvisContaining(String expression) {
//		return avisFacade.getAvisContaining(expression);
//	}

	public Avis save(Avis avis) {
		return avisFacade.save(avis);
	}

	public void update(Avis avis) {
		avisFacade.save(avis);
	}

	public void delete(Integer id) {
		avisFacade.delete(id);
	}
}
