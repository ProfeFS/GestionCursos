package edu.cesur.fullstack.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cesur.fullstack.dtos.EstudianteDTO;
import edu.cesur.fullstack.mappers.EstudianteMapper;
import edu.cesur.fullstack.persistence.entities.CursoEntity;
import edu.cesur.fullstack.persistence.entities.EstudianteEntity;
import edu.cesur.fullstack.persistence.repositories.CursoRepository;
import edu.cesur.fullstack.persistence.repositories.EstudianteRepository;
import jakarta.transaction.Transactional;

@Service
public class EstudianteServiceImpl  implements EstudianteService{
	
	@Autowired
	EstudianteRepository estudianteRepository;
	@Autowired
	EstudianteMapper estudianteMapper;
	@Autowired
	CursoRepository cursoRepository;


	@Override
	public EstudianteDTO createEstudiante(EstudianteDTO estudianteDTO) {
		
		EstudianteEntity estE = estudianteRepository.save(estudianteMapper.toEntity(estudianteDTO));
		return estudianteMapper.toDto(estE);
	}
	
	

	@Override
	@Transactional
	public EstudianteDTO createEstudianteWhithCourse(EstudianteDTO estudianteDTO) {
		EstudianteEntity estudiante = estudianteMapper.toEntity(estudianteDTO);
	    
		if (estudianteDTO.getCursoId() != null) {
	        CursoEntity curso = cursoRepository.findById(estudianteDTO.getCursoId())
	                            .orElseThrow(() -> new RuntimeException("curso no encontrado"));
	        
	        estudiante.setCurso(curso);
	    }
		
	    estudiante = estudianteRepository.save(estudiante);
	    return estudianteMapper.toDto(estudiante);
	}
	

	@Override
	public EstudianteDTO inscribirEstudianteAunCurso(Long estudianteId, Long cursoId) {
		
		EstudianteEntity estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        CursoEntity curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        estudiante.setCurso(curso);
        estudiante = estudianteRepository.save(estudiante);
        
        return estudianteMapper.toDto(estudiante);
		
	}

	


}
