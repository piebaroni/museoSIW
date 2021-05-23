package it.uniroma3.siw.museo.repository;

import java.time.Year;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.museo.model.*;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	public List<Opera> findByTitolo(String titolo);
	
	public List<Opera> findByAnno(Year anno);
	
	public List<Opera> findByArtista(Artista artista);
	
	public List<Opera> findByArtistaAndTitolo(Artista artista, String titolo);

	public List<Opera> findByCollezione(Collezione c);
}
