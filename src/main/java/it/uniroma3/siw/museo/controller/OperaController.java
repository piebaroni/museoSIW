package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.service.ArtistaService;
import it.uniroma3.siw.museo.service.OperaService;

@Controller
public class OperaController {

	@Autowired
	private OperaService service;

	@Autowired
	private OperaValidator validator;

	@RequestMapping(value = "/opera/{id}", method = RequestMethod.GET)
	public String getOpera(@PathVariable("id") Long id, Model model) {
		model.addAttribute("opera", this.service.trovaPerId(id));
		return "opera.html";
	}

	@RequestMapping(value = "/listaOpere", method = RequestMethod.GET)
	public String getOpere(Model model) {
		model.addAttribute("opere", this.service.findAll());
		return "listaOpere.html";
	}

	@RequestMapping(value = "/admin/addOpera", method = RequestMethod.GET)
	public String addOpera(Model model) {
		model.addAttribute("opera", new Opera());
		return "operaForm.html";
	}

	@RequestMapping(value = "/admin/opera", method = RequestMethod.POST)
	public String newOpera(@ModelAttribute("opera") Opera opera, Model model, BindingResult bindingResult) {
		this.validator.validate(opera, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.service.inserisci(opera);
			model.addAttribute("opere", this.service.findAll());
			return "listaOpere.html";
		}
		return "operaForm.html";
	}
}
