package it.uniroma3.siw.museo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.museo.model.Credentials;
import it.uniroma3.siw.museo.model.Utente;
import it.uniroma3.siw.museo.service.CollezioneService;
import it.uniroma3.siw.museo.service.CredentialsService;
import it.uniroma3.siw.museo.service.UtenteService;

@Controller
public class AuthenticationController {

	@Autowired
	private CredentialsService credentialsService;

	@Autowired
	private UtenteValidator utenteValidator;
	
	@Autowired
	private UtenteService utenteService;

	@Autowired
	private CredentialsValidator credentialsValidator;
	
	@Autowired
	private CollezioneService collezioneService;

	@RequestMapping(value = "/register", method = RequestMethod.GET) 
	public String showRegisterForm (Model model) {
		model.addAttribute("user", new Utente());
		model.addAttribute("credentials", new Credentials());
		return "registerUser.html";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET) 
	public String showLoginForm (Model model) {
		return "login.html";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET) 
	public String logout(Model model) {
		return "index.html";
	}
	
	@RequestMapping(value = "/default", method = RequestMethod.GET)
	public String defaultAfterLogin(Model model) {

		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Credentials credentials = credentialsService.getCredentialsByUsername(userDetails.getUsername());
		if (credentials.getRole().equals(Credentials.ADMIN_ROLE)) {
			return "admin/home.html";
		}
		model.addAttribute("collezioni", collezioneService.findAll());
		return "home.html";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") Utente utente, BindingResult userBindingResult,
			@ModelAttribute("credentials") Credentials credentials, BindingResult credentialsBindingResult, Model model) {
		this.utenteValidator.validate(utente, userBindingResult);
		this.credentialsValidator.validate(credentials, credentialsBindingResult);
		if(!userBindingResult.hasErrors() && ! credentialsBindingResult.hasErrors()) {
			credentials.setUtente(utente);
			utenteService.saveUtente(utente);
			credentialsService.saveCredentials(credentials);
			return "registrationSuccessful.html";
		}
		return "registerUser.html";
	}

}
