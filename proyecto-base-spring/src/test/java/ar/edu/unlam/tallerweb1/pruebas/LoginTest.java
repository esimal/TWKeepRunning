package ar.edu.unlam.tallerweb1.pruebas;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import tallerweb.keeprunning.controladores.ControladorLogin;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.ValidarUsuario;;

public class LoginTest {
	
	@Test
	public void loginConUsuarioYPassIncorrectosDeberiaVolverAlLoginNuevamente(){
		ControladorLogin controlador = new ControladorLogin();
		Usuario usuario = new Usuario();
		usuario.setEmail("mailIncorrecto@gmail.com");
		usuario.setPassword("passwordIncorrecta");
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		ValidarUsuario servicioMock = mock(ValidarUsuario.class);
		when (servicioMock.validarUsuario(anyString(), anyString())).thenReturn(null);
		controlador.setValidarUsuario(servicioMock);
		ModelAndView mav = controlador.login(usuario, requestMock, param);
		assertThat(mav.getModel().get("error")).isEqualTo("usuario-invalido");
		assertThat(mav.getViewName()).isEqualTo("login");		
	}
}
