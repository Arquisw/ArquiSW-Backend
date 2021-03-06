package co.edu.uco.arquisw.dominio.usuario.puerto.comando;

import co.edu.uco.arquisw.dominio.usuario.modelo.HojaDeVidaPersona;
import co.edu.uco.arquisw.dominio.usuario.modelo.Persona;

public interface PersonaRepositorioComando
{
    Long guardar(Persona persona);
    Long actualizar(Persona persona, Long id);
    void eliminar(Long id);
    Long guardarHojaDeVida(HojaDeVidaPersona hojaDeVida,Long usuarioId);
    Long actualizarHojaDeVida(HojaDeVidaPersona hojaDeVida,Long usuarioId);
    void crearNotificacionEliminacion(Long id);
}