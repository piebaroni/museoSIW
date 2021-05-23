package it.uniroma3.siw.museo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.museo.model.Amministratore;
import it.uniroma3.siw.museo.repository.AmministratoreRepository;

@Service
public class AmministratoreService {

	@Autowired
	private AmministratoreRepository repo;
	
	@Transactional
	public Amministratore trovaPerId(String id) {
		Optional<Amministratore> optional = repo.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
}
