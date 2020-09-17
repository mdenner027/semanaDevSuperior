package com.devsuperior.dspesquisa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dtos.JogoDTO;
import com.devsuperior.dspesquisa.services.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoController {

	@Autowired
	private JogoService jogoService;

	@GetMapping
	public ResponseEntity<List<JogoDTO>> findAll() {
		return ResponseEntity.ok().body(jogoService.findAll());
	}
	

//	@GetMapping(value = "{id}")
//	public ResponseEntity<Jogo> findById(@PathVariable Long id){
//		//return ResponseEntity.ok().body(jogoRepository.findByIdJogo(id));
//	}
}
