package edu.cesur.fullstack.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import edu.cesur.fullstack.dtos.EstudianteDTO;
import edu.cesur.fullstack.persistence.entities.CursoEntity;
import edu.cesur.fullstack.persistence.entities.EstudianteEntity;


@Mapper(componentModel = "spring")
public interface EstudianteMapper {
    
	@Mapping(source = "curso", target = "cursoId", qualifiedByName = "mapCursoId")
    EstudianteDTO toDto(EstudianteEntity estudiante);

    EstudianteEntity toEntity(EstudianteDTO estudianteDTO);

    @Named("mapCursoId")
    default Long mapCursoId(CursoEntity curso) {
        if (curso == null) {
            return null;
        }
        return curso.getCursoId();
    }
	
}
