package it.uniroma3.siw.museo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.service.ArtistaService;

@Component
public class ArtistaValidator implements Validator{
	
	@Autowired
	private ArtistaService service;
	
	private static final Logger logger = LoggerFactory.getLogger(ArtistaValidator.class);

	@Override
	public boolean supports(Class<?> aClass) {
		return Artista.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cognome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nazione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dataNascita", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "luogoNascita", "required");
		if(!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if(this.service.alreadyExists((Artista) target)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}
	
	
}
