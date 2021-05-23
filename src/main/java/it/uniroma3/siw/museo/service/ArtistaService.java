package it.uniroma3.siw.museo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository ar;
	
	@Transactional
	public Artista inserisci(Artista a) {
		return ar.save(a);
	}
	
	public List<Artista> trovaPerNome(String nome){
		return ar.findByNome(nome);
	}
	
	public List<Artista> trovaPerNomeOCognome(String nome, String cognome){
		return ar.findByNomeOrCognome(nome, cognome);
	}
	
	public List<Artista> trovaPerNomeECognome(String nome, String cognome){
		return ar.findByNomeAndCognome(nome, cognome);
	}
	
	public List<Artista> findAll(){
		return (List<Artista>) ar.findAll();
	}
	
	@Transactional
	public Artista trovaPerId(Long id) {
		Optional<Artista> optional = ar.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
	@Transactional
	public boolean alreadyExists(Artista a) {
		List<Artista> artisti = ar.findByNomeAndCognome(a.getNome(), a.getCognome());
		if(artisti.size()>0) return true;
		return false;
	}
}
