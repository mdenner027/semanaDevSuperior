package com.devsuperior.dspesquisa.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dspesquisa.dtos.RecordDTO;
import com.devsuperior.dspesquisa.dtos.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.JogoRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository repository;

	@Autowired
	private JogoRepository jogoRepository;

	@Transactional
	public RecordDTO save(RecordInsertDTO dto) {
		Record entity = new Record();

		entity.setIdadeRecord(dto.getIdadeRecord());
		entity.setNomeRecord(dto.getNomeRecord());
		entity.setJogoRecord(jogoRepository.getOne(dto.getIdJogo()));
		entity.setMomentoRecord(Instant.now());

		return new RecordDTO(repository.save(entity));
	}

	public List<RecordDTO> findAll() {
		return (repository.findAllByOrderByMomentoRecordDesc().stream().map(x -> new RecordDTO(x))
				.collect(Collectors.toList()));
	}
}
