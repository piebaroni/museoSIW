package it.uniroma3.siw.museo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.service.OperaService;

@Component
public class OperaValidator implements Validator {

	@Autowired
	private OperaService operaService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Opera.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titolo", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "anno", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "artista.id", "required");
		if(!errors.hasErrors()) {
			logger.debug("confermato: valori non nulli");
			if(this.operaService.alreadyExists((Opera) target)) {
				logger.debug("e' un duplicato");
				errors.reject("duplicato");
			}
		}
	}

}
