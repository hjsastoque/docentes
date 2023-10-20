package com.docentes.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.docentes.model.Docentes;

public interface IDocenteService {
	
	public Iterable<Docentes> findAll();
	
	public Page<Docentes> findAll(Pageable pageable);
	
	public Optional<Docentes> findById(Long id);
	
	public Docentes save1(Docentes docentes);
	
	public void deleteById(Long id);
	
	public int save(Docentes docentes);

}
