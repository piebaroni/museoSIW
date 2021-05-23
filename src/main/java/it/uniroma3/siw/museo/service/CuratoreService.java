package it.uniroma3.siw.museo.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.uniroma3.siw.museo.model.Curatore;
import it.uniroma3.siw.museo.repository.CuratoreRepository;

@Service
public class CuratoreService {

	@Autowired
	private CuratoreRepository cr;
	
	@Transactional
	public Curatore inserisci(Curatore c) {
		return cr.save(c);
	}
	
	public List<Curatore> trovaPerNome(String nome){
		return cr.findByNome(nome);
	}
	
	public List<Curatore> trovaPerNomeOCognome(String nome, String cognome){
		return cr.findByNomeOrCognome(nome, cognome);
	}
	
	public List<Curatore> trovaPerNomeECognome(String nome, String cognome){
		return cr.findByNomeAndCognome(nome, cognome);
	}
	
	public List<Curatore> trovaPerMatricola(int matricola){
		return cr.findByMatricola(matricola);
	}
	
	public List<Curatore> findAll(){
		return (List<Curatore>) cr.findAll();
	}
	
	@Transactional
	public Curatore trovaPerId(Long id) {
		Optional<Curatore> optional = cr.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
	@Transactional
	public boolean alreadyExists(Curatore c) {
		List<Curatore> curatori = cr.findByNomeAndCognome(c.getNome(), c.getCognome());
		if(curatori.size()>0) return true;
		return false;
	}
}
