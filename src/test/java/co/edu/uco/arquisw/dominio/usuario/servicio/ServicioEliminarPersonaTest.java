package co.edu.uco.arquisw.dominio.usuario.servicio;

import co.edu.uco.arquisw.dominio.asociacion.dto.AsociacionDTO;
import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.dto.PostulacionDTO;
import co.edu.uco.arquisw.dominio.postulacion.dto.SeleccionDTO;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.transversal.excepciones.AutorizacionExcepcion;
import co.edu.uco.arquisw.dominio.transversal.excepciones.ValorInvalidoExcepcion;
import co.edu.uco.arquisw.dominio.transversal.utilitario.Mensajes;
import co.edu.uco.arquisw.dominio.usuario.dto.PersonaDTO;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarPersonaTest {
    @Test
    void ValidarEliminacionExitosa()
    {
        var persona= new PersonaDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta =Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta,asociacionRepositorioConsulta,postulacionRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);

        var id =servicio.ejecutar(1L);
        Mockito.verify(personaRepositorioComando,Mockito.times(1)).eliminar(1L);

        Assertions.assertEquals(1L,id);
    }
    @Test
    void ValidarEliminacionFallidaNoExisteUsuario()
    {
        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta =Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta,asociacionRepositorioConsulta,postulacionRepositorioConsulta);

        Assertions.assertEquals(Mensajes.NO_EXISTE_USUARIO_CON_EL_ID + 1,
                Assertions.assertThrows(ValorInvalidoExcepcion.class,() -> servicio.ejecutar(1L)).getMessage());
    }
    @Test
    void ValidarEliminacionFallidaExisteAsociacion()
    {
        var persona= new PersonaDTO();
        var asociacion = new AsociacionDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta =Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta,asociacionRepositorioConsulta,postulacionRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(asociacionRepositorioConsulta.consultarPorID(Mockito.anyLong())).thenReturn(asociacion);

        Assertions.assertEquals(Mensajes.NO_PUEDE_ELIMINAR_POR_TENER_ASOCIACION_A_CARGO,
                Assertions.assertThrows(AutorizacionExcepcion.class,() -> servicio.ejecutar(1L)).getMessage());
    }
    @Test
    void ValidarEliminacionFallidaEstaSeleccionado()
    {
        var persona= new PersonaDTO();
        var seleccionado = new SeleccionDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta =Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta,asociacionRepositorioConsulta,postulacionRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(postulacionRepositorioConsulta.consultarSeleccionPorUsuarioId(Mockito.anyLong())).thenReturn(seleccionado);

        Assertions.assertEquals(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_SELECCIONADO_EN_UN_PROYECTO,
                Assertions.assertThrows(AutorizacionExcepcion.class,() -> servicio.ejecutar(1L)).getMessage());
    }
    @Test
    void ValidarEliminacionFallidaEstaPostulado()
    {
        var persona= new PersonaDTO();
        var postulacion = new PostulacionDTO();

        var personaRepositorioComando = Mockito.mock(PersonaRepositorioComando.class);
        var personaRepositorioConsulta = Mockito.mock(PersonaRepositorioConsulta.class);
        var asociacionRepositorioConsulta = Mockito.mock(AsociacionRepositorioConsulta.class);
        var postulacionRepositorioConsulta =Mockito.mock(PostulacionRepositorioConsulta.class);

        var servicio = new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta,asociacionRepositorioConsulta,postulacionRepositorioConsulta);

        Mockito.when(personaRepositorioConsulta.consultarPorId(Mockito.anyLong())).thenReturn(persona);
        Mockito.when(postulacionRepositorioConsulta.consultarPostulacionPorUsuarioId(Mockito.anyLong())).thenReturn(postulacion);

        Assertions.assertEquals(Mensajes.NO_PUEDE_ELIMINAR_POR_ESTAR_EN_UN_PROCESO_DE_POSTULACION,
                Assertions.assertThrows(AutorizacionExcepcion.class,() -> servicio.ejecutar(1L)).getMessage());
    }
}
