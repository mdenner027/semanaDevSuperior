package com.devsuperior.dspesquisa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dspesquisa.dtos.RecordDTO;
import com.devsuperior.dspesquisa.dtos.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;

@RestController
@RequestMapping(value = "/records")
public class RecordController {

	@Autowired
	private RecordService service;

	@PostMapping
	public ResponseEntity<RecordDTO> save(@RequestBody RecordInsertDTO record) {
		return ResponseEntity.ok().body(service.save(record));
	}

	@GetMapping
	public ResponseEntity<List<RecordDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
}
