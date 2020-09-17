package com.devsuperior.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dspesquisa.enums.Plataforma;

@Entity
@Table(name = "jogos")
public class Jogo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_jogo")
	private Long idJogo;

	@Column(name = "titulo_jogo", nullable = false)
	private String tituloJogo;

	@ManyToOne(targetEntity = Genero.class)
	@JoinColumn(name = "id_genero_jogo")
	private Genero generoJogo;

	@Column(name = "plataforma_jogo")
	private Plataforma plataformaJogo;

	@OneToMany(mappedBy = "jogoRecord", targetEntity = Record.class)
	private List<Record> records = new ArrayList<>();

	public Jogo() {

	}

	public Jogo(Long idJogo, String tituloJogo, Genero generoJogo, Plataforma plataformaJogo) {
		this.idJogo = idJogo;
		this.tituloJogo = tituloJogo;
		this.generoJogo = generoJogo;
		this.plataformaJogo = plataformaJogo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idJogo == null) ? 0 : idJogo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogo other = (Jogo) obj;
		if (idJogo == null) {
			if (other.idJogo != null)
				return false;
		} else if (!idJogo.equals(other.idJogo))
			return false;
		return true;
	}

	public Long getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Long idJogo) {
		this.idJogo = idJogo;
	}

	public String getTituloJogo() {
		return tituloJogo;
	}

	public void setTituloJogo(String tituloJogo) {
		this.tituloJogo = tituloJogo;
	}

	public Genero getGeneroJogo() {
		return generoJogo;
	}

	public void setGeneroJogo(Genero generoJogo) {
		this.generoJogo = generoJogo;
	}

	public Plataforma getPlataformaJogo() {
		return plataformaJogo;
	}

	public void setPlataformaJogo(Plataforma plataformaJogo) {
		this.plataformaJogo = plataformaJogo;
	}

	public List<Record> getRecords() {
		return records;
	}
}