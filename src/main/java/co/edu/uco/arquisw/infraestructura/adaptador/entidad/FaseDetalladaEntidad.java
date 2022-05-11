package co.edu.uco.arquisw.infraestructura.adaptador.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "fasedetallada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FaseDetalladaEntidad
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nombre;
    private String descripcion;
    private int orden;
}