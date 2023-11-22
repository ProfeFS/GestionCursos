package edu.cesur.fullstack.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.cesur.fullstack.dtos.EstudianteDTO;
import edu.cesur.fullstack.persistence.entities.EstudianteEntity;
import edu.cesur.fullstack.services.EstudianteService;

@RestController
@RequestMapping("/students")
public class EstudianteRestController {

	@Autowired
	EstudianteService estudianteService;

	@PostMapping()
	public ResponseEntity<?> createStudent(@RequestBody EstudianteDTO estudianteDTO) {

		EstudianteDTO est = estudianteService.createEstudiante(estudianteDTO);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + est.getId())
				.buildAndExpand(est.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@PostMapping("/curso")
	public ResponseEntity<?> createStudentWhithCourse(@RequestBody EstudianteDTO estudianteDTO) {

		EstudianteDTO est = estudianteService.createEstudianteWhithCourse(estudianteDTO);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/" + est.getId())
				.buildAndExpand(est.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@PostMapping("/{estudianteId}/inscripcion/{cursoId}")
    public ResponseEntity<EstudianteDTO> inscribirEstudianteACurso(@PathVariable Long estudianteId, @PathVariable Long cursoId) {
        EstudianteDTO estudianteDTO = estudianteService.inscribirEstudianteAunCurso(estudianteId, cursoId);
        return ResponseEntity.ok(estudianteDTO);
    }

}
