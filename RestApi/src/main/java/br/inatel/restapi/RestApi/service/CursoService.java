package br.inatel.restapi.RestApi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import br.inatel.restapi.RestApi.model.Curso;

@Service
public class CursoService {

	private Map<Long, Curso> mapa = new HashMap<>();

	@PostConstruct
	private void setup() {
		Curso c1 = new Curso(1L, "Curso 1", 40);
		Curso c2 = new Curso(2L, "Curso 2", 30);
		Curso c3 = new Curso(3L, "Curso 3", 20);
		Curso c4 = new Curso(4L, "Curso 4", 10);

		mapa.put(c1.getId(), c1);
		mapa.put(c2.getId(), c2);
		mapa.put(c3.getId(), c3);
		mapa.put(c4.getId(), c4);
	}

	public List<Curso> pesquisarCurso() {
		return mapa.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
	}

	public Curso buscarCursoPeloId(Long cursoId) {
		Curso cursoEncontrado = mapa.get(cursoId);
		return cursoEncontrado;
	}

	public Curso criarCurso(Curso curso) {
		Long cursoId = gerarCursoIdUnico();
		curso.setId(cursoId);
		mapa.put(curso.getId(), curso);
		return curso;
	}

	private Long gerarCursoIdUnico() {
		return System.currentTimeMillis();
	}

	public void atualizarCurso(Curso curso) {
		mapa.put(curso.getId(), curso);
	}

	public void removerCurso(Long cursoId) {
		mapa.remove(cursoId);
	}

}
