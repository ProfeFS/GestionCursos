package edu.cesur.fullstack.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDTO {
  
    private Long id;
    private String nombre;   
    private Long cursoId;


}
