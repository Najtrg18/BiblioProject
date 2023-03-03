/**
 * 
 */
package com.m2i.biblioSpringBoot.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.biblioSpringBoot.bo.Avis;
import com.m2i.biblioSpringBoot.dao.IAvisDAO;

/**
 * @author Administrateur
 *
 */
@Service
public class AvisFacade {

	@Autowired
	private IAvisDAO avisDAO;

	public List<Avis> get() {
		return avisDAO.findAll();
	}

	public Avis get(Integer id) {
		return avisDAO.getReferenceById(id);
	}

//	public List<Avis> getAvisContaining(String expression) {
//		return avisDAO.findByContentContaining(expression);
//	}

	public Avis save(Avis avis) {
		return avisDAO.save(avis);
	}

	public void update(Avis avis) {
		avisDAO.save(avis);
	}

	public void delete(Integer id) {
		avisDAO.deleteById(id);
	}
}
