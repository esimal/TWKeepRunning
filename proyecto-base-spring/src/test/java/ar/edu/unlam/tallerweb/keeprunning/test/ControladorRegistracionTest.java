package ar.edu.unlam.tallerweb.keeprunning.test;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.controladores.ControladorRegistracion;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServicios;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ControladorRegistracionTest {

	@Test
	public void testQuePruebaQueLuegoDeRegistrarUnUsuarioVaALaVistaRegistracionOk(){
		ControladorRegistracion controladorRegistracion = new ControladorRegistracion();
		Usuario usuario = new Usuario("TestNombre", "TestApellido", 12345679L, "test@gmail.com", "123", "123", "22/07/1992");
		UsuarioServicios servicioMock = mock(UsuarioServicios.class);
		servicioMock.grabarUsuario(usuario);
		controladorRegistracion.setRegistrarUsuario(servicioMock);
		ModelAndView mav = controladorRegistracion.guardarUsuario(usuario);
		assertThat(mav.getViewName()).isEqualTo("registracionOk");
	}
}
