package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.siw.museo.model.Amministratore;
import it.uniroma3.siw.museo.service.AmministratoreService;

@Controller
public class AmministratoreController {
	
	@Autowired
	private AmministratoreService service;

	@RequestMapping(value = "/accessoAmministratore", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("amministratore", service.trovaPerId("pietro"));
		System.out.println("ANDANDO ALLA PAGINA DI ACCESSO");
		return "accesso.html";
	}
	
	@RequestMapping(value = "/amministratore/{amministratore}", method = RequestMethod.POST)
	public String effettuaLogin(Model model, @RequestParam(value = "amministratore") Amministratore a) {
		if(a.getPassword().equals("password")) {
			System.out.println("ANDANDO ALLA PAGINA DELL'ADMIN");
			return "adminPage.html";
		}
		System.out.println("ANDANDO ALLA PAGINA DI ACCESSO");
		return "accesso.html";
	}
}
