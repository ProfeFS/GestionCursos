package edu.cesur.fullstack.services;

import edu.cesur.fullstack.dtos.EstudianteDTO;

public interface EstudianteService {
	
	EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO);
	
	EstudianteDTO inscribirEstudianteAunCurso(Long estudianteId, Long cursoId);


}
