package it.uniroma3.siw.museo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.service.CollezioneService;

@Component
public class CollezioneValidator implements Validator{

	@Autowired
	private CollezioneService collezioneService;

	private static final Logger logger = LoggerFactory.getLogger(ArtistaValidator.class);

	@Override
	public boolean supports(Class<?> aClass) {
		return Collezione.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "curatore.id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione.termineMostra", "required");
		if(!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if(this.collezioneService.alreadyExists((Collezione) target)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

}
