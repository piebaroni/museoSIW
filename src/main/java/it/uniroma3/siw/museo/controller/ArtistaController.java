package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.service.ArtistaService;
import it.uniroma3.siw.museo.service.OperaService;

@Controller
public class ArtistaController {

	@Autowired
	private ArtistaService service;
	
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private ArtistaValidator artistaValidator;
	
	@RequestMapping(value = "/listaArtisti", method = RequestMethod.GET)
    public String getArtisti(Model model) {
    		model.addAttribute("artisti", this.service.findAll());
    		return "listaArtisti.html";
    }
	
	@RequestMapping(value = "/admin/listaArtisti", method = RequestMethod.GET)
    public String getArtistiAdmin(Model model) {
    		model.addAttribute("artisti", this.service.findAll());
    		return "listaArtisti.html";
    }
	
	@RequestMapping(value = "/artista/{id}", method = RequestMethod.GET)
    public String getArtista(@PathVariable("id") Long id, Model model) {
    	Artista a = this.service.trovaPerId(id);
    	model.addAttribute("artista", a);
    	model.addAttribute("opere", operaService.trovaPerArtistaId(a.getId()));
    	return "artista.html";
    }
	
	@RequestMapping(value = "/addArtista", method = RequestMethod.GET)
	public String addArtista(Model model) {
		model.addAttribute("artista", new Artista());
		return "artistaForm.html";
	}
	
	@RequestMapping(value = "/admin/artista", method = RequestMethod.POST)
	public String newArtista(@ModelAttribute("artista") Artista artista, Model model, BindingResult bindingResult) {
		this.artistaValidator.validate(artista, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.service.inserisci(artista);
			model.addAttribute("artisti", this.service.findAll());
			return "listaArtisti.html";
		}
		return "artistaForm.html";
	}
	
	@RequestMapping(value = "/admin/artista/{id}", method = RequestMethod.GET)
    public String getArtistaAdmin(@PathVariable("id") Long id, Model model) {
    	Artista a = this.service.trovaPerId(id);
    	model.addAttribute("artista", a);
    	model.addAttribute("opere", operaService.trovaPerArtistaId(a.getId()));
    	return "admin/artista.html";
    }
}
