package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.service.CollezioneService;
import it.uniroma3.siw.museo.service.CuratoreService;
import it.uniroma3.siw.museo.service.OperaService;

@Controller
public class CollezioneController {

	@Autowired
	private CollezioneService service;
	
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private CollezioneValidator validator;
	
	@Autowired
	private CuratoreService curatoreService;
	
	@RequestMapping(value = "/collezione/{id}", method = RequestMethod.GET)
    public String getPersona(@PathVariable("id") Long id, Model model) {
    	Collezione c = this.service.trovaPerId(id);
		model.addAttribute("collezione", c);
		model.addAttribute("opere", operaService.trovaPerCollezioneId(c.getId()));
    	return "collezione.html";
    }

    @RequestMapping(value = "/listaCollezioni", method = RequestMethod.GET)
    public String getCollezioni(Model model) {
    		model.addAttribute("collezioni", this.service.findAll());
    		return "listaCollezioni.html";
    }
    
    @RequestMapping(value = "/admin/addCollezione", method = RequestMethod.GET)
	public String addOpera(Model model) {
		model.addAttribute("collezione", new Collezione());
		model.addAttribute("curatori", curatoreService.findAll());
		return "collezioneForm.html";
	}
    
    @RequestMapping(value = "/admin/collezione", method = RequestMethod.POST)
	public String newOpera(@ModelAttribute("collezione") Collezione collezione, Model model, BindingResult bindingResult) {
		this.validator.validate(collezione, bindingResult);
		if(!bindingResult.hasErrors()) {
			this.service.inserisci(collezione);
			model.addAttribute("collezioni", this.service.findAll());
			return "listaCollezioni.html";
		}
		return "collezioneForm.html";
	}
}
