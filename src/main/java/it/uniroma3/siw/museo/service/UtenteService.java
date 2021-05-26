package it.uniroma3.siw.museo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.siw.museo.model.Utente;
import it.uniroma3.siw.museo.repository.UtenteRepository;

public class UtenteService {
	
	@Autowired
    protected UtenteRepository utenteRepository;
	
	@Transactional
    public Utente getUtenteById(Long id) {
        Optional<Utente> result = this.utenteRepository.findById(id);
        return result.orElse(null);
    }
	
	@Transactional
    public Utente saveUtente(Utente utente) {
        return this.utenteRepository.save(utente);
    }
	
	@Transactional
    public List<Utente> getAllUsers() {
        List<Utente> result = new ArrayList<>();
        Iterable<Utente> iterable = this.utenteRepository.findAll();
        for(Utente utente : iterable)
            result.add(utente);
        return result;
    }
}
