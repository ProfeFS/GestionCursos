package edu.cesur.fullstack.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.cesur.fullstack.dtos.CursoDTO;
import edu.cesur.fullstack.persistence.entities.CursoEntity;

@Mapper(componentModel = "spring", uses = {EstudianteMapper.class})
public interface CursoMapper {
	
	//@Mapping(target = "estudiantes", ignore = true)
    CursoDTO toDto(CursoEntity curso);
    CursoEntity toEntity(CursoDTO cursoDTO);
    
    @Mapping(target = "estudiantes", ignore = true)
    CursoDTO toDtoWithoutStudents(CursoEntity curso);
}
