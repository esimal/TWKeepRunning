package ar.edu.unlam.tallerweb.keeprunning.test;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import tallerweb.keeprunning.controladores.ControladorLogin;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServicios;

public class ControladorLoginTest {
	
	@Test
	//por el camino que sigue en el controlador parecería que da null para la condicion if(usuarioValidado != null)
	public void loguearseConUsuarioYPassIncorrectosDeberiaIrALaVistaIngresoIncorrecto(){
		ControladorLogin controlador = new ControladorLogin();
		Usuario usuario = new Usuario();
		usuario.setEmail("mailIncorrecto@gmail.com");
		usuario.setPassword("passwordIncorrecta");
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		UsuarioServicios servicioMock = mock(UsuarioServicios.class);
		when (servicioMock.validarUsuario(anyString(), anyString())).thenReturn(null);
		controlador.setValidarUsuario(servicioMock);
		ModelAndView mav = controlador.login(usuario, requestMock, 0);
		assertThat(mav.getModel().get("error")).isEqualTo("usuario-invalido");
		assertThat(mav.getViewName()).isEqualTo("ingresoIncorrecto");
	}
	
	@Test
	public void loguearseConUsuarioYPassCorrectosDeberiaIrAlInicio(){
		ControladorLogin controlador = new ControladorLogin();
		Usuario usuario = new Usuario();
		usuario.setEmail("gonza@gmail.com");
		usuario.setPassword("123");
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		UsuarioServicios servicioMock = mock(UsuarioServicios.class);
		when (servicioMock.validarUsuario(anyString(), anyString())).thenReturn(null);
		controlador.setValidarUsuario(servicioMock);
		ModelAndView mav = controlador.login(usuario, requestMock, 0);
		assertThat(mav.getModel().get("correcto")).isEqualTo("usuario-valido");
		assertThat(mav.getViewName()).isEqualTo("login");
	}
}