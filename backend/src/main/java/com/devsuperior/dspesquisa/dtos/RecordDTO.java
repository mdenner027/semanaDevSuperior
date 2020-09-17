package com.devsuperior.dspesquisa.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.enums.Plataforma;

public class RecordDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idRecord;
	private Instant momentoRecord;
	private String nomeJogador;
	private Integer idadeJogador;
	private String tituloJogo;
	private Plataforma plataformaJogo;
	private String generoJogo;

	public RecordDTO() {

	}

	public RecordDTO(Record entity) {
		idRecord = entity.getIdRecord();
		momentoRecord = entity.getMomentoRecord();
		nomeJogador = entity.getNomeRecord();
		idadeJogador = entity.getIdadeRecord();
		tituloJogo = entity.getJogoRecord().getTituloJogo();
		plataformaJogo = entity.getJogoRecord().getPlataformaJogo();
		generoJogo = entity.getJogoRecord().getGeneroJogo().getNomeGenero();
	}

	public Long getIdRecord() {
		return idRecord;
	}

	public void setIdRecord(Long idRecord) {
		this.idRecord = idRecord;
	}

	public Instant getMomentoRecord() {
		return momentoRecord;
	}

	public void setMomentoRecord(Instant momentoRecord) {
		this.momentoRecord = momentoRecord;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public Integer getIdadeJogador() {
		return idadeJogador;
	}

	public void setIdadeJogador(Integer idadeJogador) {
		this.idadeJogador = idadeJogador;
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

	public String getGeneroJogo() {
		return generoJogo;
	}

	public void setGeneroJogo(String generoJogo) {
		this.generoJogo = generoJogo;
	}
}