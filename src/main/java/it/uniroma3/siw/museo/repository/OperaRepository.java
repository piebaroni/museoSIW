package it.uniroma3.siw.museo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import it.uniroma3.siw.museo.model.*;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	public List<Opera> findByTitolo(String titolo);
	
	public List<Opera> findByAnno(int anno);
	
	public List<Opera> findByArtistaIdAndTitolo(Long id, String titolo);

	public List<Opera> findByCollezioneId(Long id);

	public List<Opera> findByArtistaId(Long id);
}
