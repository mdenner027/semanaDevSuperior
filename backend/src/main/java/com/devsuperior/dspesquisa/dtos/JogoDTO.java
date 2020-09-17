package com.devsuperior.dspesquisa.dtos;

import java.io.Serializable;

import com.devsuperior.dspesquisa.entities.Jogo;
import com.devsuperior.dspesquisa.enums.Plataforma;

public class JogoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idJogo;
	private String tituloJogo;
	private Plataforma plataformaJogo;

	public JogoDTO() {

	}

	public JogoDTO(Jogo jogo) {
		idJogo = jogo.getIdJogo();
		tituloJogo = jogo.getTituloJogo();
		plataformaJogo = jogo.getPlataformaJogo();
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

	public Plataforma getPlataformaJogo() {
		return plataformaJogo;
	}

	public void setPlataformaJogo(Plataforma plataformaJogo) {
		this.plataformaJogo = plataformaJogo;
	}
}
