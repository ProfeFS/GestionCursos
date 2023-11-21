package edu.cesur.fullstack.dtos;

import java.util.ArrayList;
import java.util.List;

import edu.cesur.fullstack.persistence.entities.EstudianteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

	private Long curso_id;
	private String nombre;
	private String codigoCurso;
	private String descripcion;

	private List<EstudianteDTO> estudiantes;
}
