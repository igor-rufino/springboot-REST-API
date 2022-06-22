package br.inatel.restapi.RestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.restapi.RestApi.model.Curso;
import br.inatel.restapi.RestApi.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	
	@GetMapping
	public List<Curso> listar() {
		List<Curso> listaCurso = service.pesquisarCurso();
		return listaCurso;
	}
	
}
