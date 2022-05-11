package co.edu.uco.arquisw.aplicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaseProyectoDTO
{
    private int codigo;
    private FaseDetalladaDTO faseDetallada;
    private FaseEjecucionDTO faseEjecucion;
}
