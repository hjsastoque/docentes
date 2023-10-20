package com.docentes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.docentes.model.Docentes;
import com.docentes.repository.IDocentes;

@Service
public class DocentesService implements IDocenteService{
	
	@Autowired
	private IDocentes docentesRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Docentes> findAll() {		
		return docentesRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Docentes> findAll(Pageable pageable) {
		return docentesRepository.findAll(pageable);
	}

	@Override
	@Transactional
	public Optional<Docentes> findById(Long id) {
		return docentesRepository.findById(id);
	}

	@Override
	@Transactional
	public Docentes save1(Docentes docentes) {
		return docentesRepository.save(docentes);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		docentesRepository.deleteById(id);
	}

	@Override
	@Transactional
	public int save(Docentes docentes) {
		int res=0;
		Docentes d = docentesRepository.save(docentes);
		if(!d.equals(null)) {
			res=1;
		}
		return res;
	}

}
