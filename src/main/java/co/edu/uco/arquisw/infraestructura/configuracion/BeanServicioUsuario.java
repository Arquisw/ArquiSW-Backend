package co.edu.uco.arquisw.infraestructura.configuracion;

import co.edu.uco.arquisw.dominio.asociacion.puerto.consulta.AsociacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.postulacion.puerto.consulta.PostulacionRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.arquisw.dominio.usuario.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.arquisw.dominio.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioUsuario
{
    @Bean
    public ServicioGuardarPersona servicioGuardarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioGuardarPersona(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarPersona servicioActualizarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioActualizarPersona(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarPersonaPorAdministrador servicioEliminarPersonaPorAdministrador(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioEliminarPersonaPorAdministrador(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioEliminarPersona servicioEliminarUsuario(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, AsociacionRepositorioConsulta asociacionRepositorioConsulta, PostulacionRepositorioConsulta postulacionRepositorioConsulta)
    {
        return new ServicioEliminarPersona(personaRepositorioComando, personaRepositorioConsulta, asociacionRepositorioConsulta, postulacionRepositorioConsulta);
    }


    @Bean
    public ServicioConsultarPersonaPorId servicioConsultarUsuarioPorId(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioConsultarPersonaPorId(personaRepositorioConsulta);
    }

    @Bean
    public ServicioActualizarHojaDeVida servicioActualizarHojaDeVida(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioActualizarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ServicioConsultarHojaDeVidaPorIdUsuario servicioConsultarHojaDeVidaPorIdUsuario(PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioConsultarHojaDeVidaPorIdUsuario(personaRepositorioConsulta);
    }

    @Bean
    public ServicioGuardarHojaDeVida servicioGuardarHojaDeVida(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta)
    {
        return new ServicioGuardarHojaDeVida(personaRepositorioComando, personaRepositorioConsulta);
    }
}