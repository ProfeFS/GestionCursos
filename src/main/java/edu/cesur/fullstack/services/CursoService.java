package edu.cesur.fullstack.services;

import edu.cesur.fullstack.dtos.CursoDTO;

public interface CursoService {
	
	CursoDTO createCourse(CursoDTO cursoDTO);
	
	CursoDTO getCurso(Long cursoId);


	

	

}
