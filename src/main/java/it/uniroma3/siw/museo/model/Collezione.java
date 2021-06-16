package it.uniroma3.siw.museo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Collezione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false, length = 2000)
	private String descrizione;
	
	@Column(length = 2000)
	private String descrizioneCorrente;
	
	@ManyToOne
	private Curatore curatore;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate termineMostra;

	@OneToMany(mappedBy = "collezione")
	private List<Opera> opere;
	
	
	/*COSTRUTTORE*/
	public Collezione() {
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Curatore getCuratore() {
		return curatore;
	}

	public void setCuratore(Curatore curatore) {
		this.curatore = curatore;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}


	public String getDescrizioneCorrente() {
		return descrizioneCorrente;
	}

	public void setDescrizioneCorrente(String descrizioneCorrente) {
		this.descrizioneCorrente = descrizioneCorrente;
	}
	public LocalDate getTermineMostra() {
		return termineMostra;
	}

	public void setTermineMostra(LocalDate termineMostra) {
		this.termineMostra = termineMostra;
	}
}
