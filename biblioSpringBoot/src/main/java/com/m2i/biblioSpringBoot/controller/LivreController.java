package com.m2i.biblioSpringBoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.m2i.biblioSpringBoot.bo.Livre;
import com.m2i.biblioSpringBoot.service.LivreService;

import lombok.Data;

@Data
@Controller
public class LivreController {

	@Autowired
	private LivreService livreService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Livre> livres = livreService.findAll();
		model.addAttribute("livres", livres);
		System.out.println(livres);
		return "index";
	}

	@RequestMapping(value = "/createLivre", method = RequestMethod.GET)
	public String createLivre(Model model) {
		Livre livre = new Livre();
		model.addAttribute("livre", livre);
		return "formNewLivre";
	}

	@RequestMapping(value = "/updateLivre/{id}", method = RequestMethod.GET)
	public String updateEmployee(@PathVariable("id") final int id, Model model) {
		Livre livre = livreService.get(id);
		model.addAttribute("livre", livre);
		return "formUpdateLivre";
	}

	@RequestMapping(value = "/deleteLivre/{id}", method = RequestMethod.GET)
	public ModelAndView deleteLivre(@PathVariable("id") final int id) {
		livreService.delete(id);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/saveLivre", method = RequestMethod.POST)
	public ModelAndView saveLivre(@ModelAttribute Livre livre) {
		livreService.save(livre);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/updateLivre", method = RequestMethod.POST)
	public ModelAndView updateLivre(@ModelAttribute Livre livre) {
		livreService.update(livre);
		return new ModelAndView("redirect:/");
	}

}
