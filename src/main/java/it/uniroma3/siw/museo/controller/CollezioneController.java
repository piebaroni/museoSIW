package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.service.CollezioneService;

@Controller
public class CollezioneController {

	@Autowired
	private CollezioneService service;
	
	@RequestMapping(value = "/collezione/{id}", method = RequestMethod.GET)
    public String getPersona(@PathVariable("id") Long id, Model model) {
    	Collezione c = this.service.trovaPerId(id);
		model.addAttribute("collezione", c);
    	return "collezione.html";
    }

    @RequestMapping(value = "/listaCollezioni", method = RequestMethod.GET)
    public String getPersone(Model model) {
    		model.addAttribute("collezioni", this.service.findAll());
    		return "listaCollezioni.html";
    }
}
