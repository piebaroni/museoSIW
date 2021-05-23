package it.uniroma3.siw.museo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.model.Curatore;
import it.uniroma3.siw.museo.repository.CollezioneRepository;

@Service
public class CollezioneService {
	
	@Autowired
	private CollezioneRepository cr;
	
	@Transactional
	public Collezione inserisci(Collezione c) {
		return cr.save(c);
	}
	
	public List<Collezione> trovaPerNome(String nome){
		return cr.findByNome(nome);
	}
	
	public List<Collezione> trovaPerCuratore(Curatore c){
		return cr.findByCuratore(c);
	}
	
	public List<Collezione> trovaPerNomeECuratore(String nome, Curatore c){
		return cr.findByNomeAndCuratore(nome, c);
	}
	
	public List<Collezione> findAll(){
		return (List<Collezione>) cr.findAll();
	}
	
	@Transactional
	public Collezione trovaPerId(Long id) {
		Optional<Collezione> optional = cr.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
	@Transactional
	public boolean alreadyExists(Collezione c) {
		List<Collezione> collezioni = cr.findByNomeAndCuratore(c.getNome(), c.getCuratore());
		if(collezioni.size()>0) return true;
		return false;
	}
}
