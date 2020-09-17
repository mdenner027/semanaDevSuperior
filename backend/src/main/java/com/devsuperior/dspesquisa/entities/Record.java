package com.devsuperior.dspesquisa.entities;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "records")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_record")
	private Long idRecord;

	@Column(name = "nome_record")
	private String nomeRecord;
	@Column(name = "idade_record")
	private Integer idadeRecord;

	@Column(name = "momento_record")
	private Instant momentoRecord;
	
	@JsonBackReference
	@ManyToOne(targetEntity = Jogo.class)
	@JoinColumn(name = "id_jogo_record")
	private Jogo jogoRecord;

	public Record() {

	}

	public Record(Long idRecord, String nomeRecord, Integer idadeRecord, Instant momentoRecord, Jogo jogoRecord) {
		this.idRecord = idRecord;
		this.nomeRecord = nomeRecord;
		this.idadeRecord = idadeRecord;
		this.momentoRecord = momentoRecord;
		this.jogoRecord = jogoRecord;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRecord == null) ? 0 : idRecord.hashCode());
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
		Record other = (Record) obj;
		if (idRecord == null) {
			if (other.idRecord != null)
				return false;
		} else if (!idRecord.equals(other.idRecord))
			return false;
		return true;
	}

	public Long getIdRecord() {
		return idRecord;
	}

	public void setIdRecord(Long idRecord) {
		this.idRecord = idRecord;
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

	public Instant getMomentoRecord() {
		return momentoRecord;
	}

	public void setMomentoRecord(Instant momentoRecord) {
		this.momentoRecord = momentoRecord;
	}

	public Jogo getJogoRecord() {
		return jogoRecord;
	}

	public void setJogoRecord(Jogo jogoRecord) {
		this.jogoRecord = jogoRecord;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}