package com.docentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docentes.model.Docentes;

@Repository
public interface IDocentes extends JpaRepository<Docentes, Long>{

}
