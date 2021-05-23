package it.uniroma3.siw.museo.service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.repository.OperaRepository;

@Service
public class OperaService {
	
	@Autowired
	private OperaRepository or;
	
	@Transactional
	public Opera inserisci(Opera o) {
		return or.save(o);
	}
	
	public List<Opera> trovaPerTitolo(String titolo){
		return or.findByTitolo(titolo);
	}
	
	public List<Opera> trovaPerAnno(Year anno){
		return or.findByAnno(anno);
	}
	
	public List<Opera> trovaPerArtista(Artista artista){
		return or.findByArtista(artista);
	}
	
	public List<Opera> trovaPerArtistaETitolo(Artista artista,String titolo){
		return or.findByArtistaAndTitolo(artista, titolo);
	}
	
	public List<Opera> findAll(){
		return (List<Opera>) or.findAll();
	}
	
	@Transactional
	public Opera trovaPerId(Long id) {
		Optional<Opera> optional = or.findById(id);
		if(optional.isPresent()) return optional.get();
		return null;
	}
	
	@Transactional
	public boolean alreadyExists(Opera o) {
		List<Opera> opere = or.findByTitolo(o.getTitolo());
		if(opere.size()>0) return true;
		return false;
	}

	
	public List<Opera> trovaPerCollezione(Collezione c) {
		return or.findByCollezione(c);
	}
}
