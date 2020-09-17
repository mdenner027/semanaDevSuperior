package com.devsuperior.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.devsuperior.dspesquisa.dtos.JogoDTO;
import com.devsuperior.dspesquisa.repositories.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository jogoRepository;

	@Transactional(readOnly = true)
	public List<JogoDTO> findAll() {
		return jogoRepository.findAllByOrderByTituloJogo().stream().map(x -> new JogoDTO(x)).collect(Collectors.toList());
	}
	
}
