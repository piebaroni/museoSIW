package it.uniroma3.siw.museo.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false, length = 2000)
	private String descrizione;
	
	@Column(nullable = false)
	private Year anno;
	
	@ManyToOne
	private Collezione collezione;
	
	@ManyToOne
	private Artista artista;
	
	private String linkFoto;
	
	/*COSTRUTTORE*/
	public Opera() {
		
	}
	
	
	/*GETTERS E SETTERS*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Year getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = java.time.Year.of(anno);
	}

	public Collezione getCollezione() {
		return collezione;
	}

	public void setCollezione(Collezione collezione) {
		this.collezione = collezione;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	
	public String getLinkFoto() {
		return this.linkFoto;
	}
	
	public void setLinkFoto(String link) {
		this.linkFoto = link;
	}
	
}

