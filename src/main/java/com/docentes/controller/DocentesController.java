package com.docentes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.docentes.model.Docentes;
import com.docentes.service.IDocenteService;

@Controller
public class DocentesController {
	
	@Autowired
	private IDocenteService docentesService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Docentes docentes){
		return ResponseEntity.status(HttpStatus.CREATED).body(docentesService.save(docentes));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long docentesId){
		Optional<Docentes> oDocentes=docentesService.findById(docentesId);
		
		if(!oDocentes.isPresent()) {
			return ResponseEntity.notFound().build();
		}
			
		return ResponseEntity.ok(oDocentes);
	}
		
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Docentes>docentes=(List<Docentes>) docentesService.findAll();
		model.addAttribute("docentes", docentes);
		return "index";
	}
	
	@GetMapping("/del/{id}")
	public String del(Model model, @PathVariable Long id) {
		docentesService.deleteById(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model){
		Optional<Docentes> alumnos=docentesService.findById(id);
		model.addAttribute("docentes", alumnos.get());
		return "form";
	}
	
	@GetMapping("/new")
	public String add(Model model){
		model.addAttribute("docentes",new Docentes());
		return "form";
	}
	
	@PostMapping("/listar")
	public String save(@Validated Docentes a, Model model){
		docentesService.save(a);
		//List<AlumnosVista>docentes=(List<AlumnosVista>) alumnosService.findAll();
		model.addAttribute("docentes",new Docentes());
		return "redirect:/listar";
	}

}
