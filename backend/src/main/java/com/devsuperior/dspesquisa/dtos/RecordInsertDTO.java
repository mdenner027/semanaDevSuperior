package com.devsuperior.dspesquisa.dtos;

import java.io.Serializable;

public class RecordInsertDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long idJogo;
	private String nomeRecord;
	private Integer idadeRecord;
	
	public RecordInsertDTO() {
		
	}

	public Long getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Long idJogo) {
		this.idJogo = idJogo;
	}

	public String getNomeRecord() {
		return nomeRecord;
	}

	public void setNomeRecord(String nomeRecord) {
		this.nomeRecord = nomeRecord;
	}

	public Integer getIdadeRecord() {
		return idadeRecord;
	}

	public void setIdadeRecord(Integer idadeRecord) {
		this.idadeRecord = idadeRecord;
	}
}