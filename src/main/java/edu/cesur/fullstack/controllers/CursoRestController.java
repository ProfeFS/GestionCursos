package edu.cesur.fullstack.controllers;

import java.net.URI;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.dtos.CursoDTO;
import edu.cesur.fullstack.dtos.EstudianteDTO;
import edu.cesur.fullstack.services.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoRestController {

	@Autowired
	CursoService cursoService;

	@PostMapping
	ResponseEntity<?> createCourse(@RequestBody CursoDTO cursoDTO) {

		CursoDTO curso = cursoService.createCourse(cursoDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/" + curso.getCursoId())
				.buildAndExpand(curso.getCursoId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@GetMapping("/{cursoId}")
	ResponseEntity<?> getCourse(@PathVariable Long cursoId) {

		return ResponseEntity.ok(cursoService.getCurso(cursoId));
	}

}
