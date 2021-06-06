package it.uniroma3.siw.museo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascita;
	
	@Column(nullable = false)
	private String luogoNascita;
	
	private LocalDate dataMorte;
	
	private String luogoMorte;
	
	@Column(nullable = false)
	private String nazione;

	@OneToMany(mappedBy = "artista")
	private List<Opera> opere;
	
	private String linkFoto;
	
	public Artista(Long id,String nome,String cognome,LocalDate dataNascita,String luogoNascita,LocalDate dataMorte,
			String luogoMorte,String nazione) {
		this.id=id;
		this.nome=nome;
		this.cognome=cognome;
		this.dataNascita=dataNascita;
		this.luogoNascita=luogoNascita;
		this.dataMorte=dataMorte;
		this.luogoMorte=luogoMorte;
		this.nazione=nazione;
		this.opere=new ArrayList<>();
	}
	/*COSTRUTTORE*/
	public Artista() {
		this.opere = new ArrayList<>();
	}
	
	/*GETTERS E SETTERS*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public LocalDate getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(LocalDate dataMorte) {
		this.dataMorte = dataMorte;
	}

	public String getLuogoMorte() {
		return luogoMorte;
	}

	public void setLuogoMorte(String luogoMorte) {
		this.luogoMorte = luogoMorte;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
}
