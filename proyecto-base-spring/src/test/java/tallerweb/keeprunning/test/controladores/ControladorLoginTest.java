package tallerweb.keeprunning.test.controladores;

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
	public void testQuePruebaLoguearseConUsuarioYPassIncorrectosDeberiaIrALaVistaIngresoIncorrecto() {
		ControladorLogin controladorLogin = new ControladorLogin();
		Usuario usuario = new Usuario();
		usuario.setEmail("mailIncorrecto@gmail.com");
		usuario.setPassword("passwordIncorrecta");
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		UsuarioServicios servicioMock = mock(UsuarioServicios.class);
		when (servicioMock.buscarUsuario(anyString(), anyString())).thenReturn(null);
		controladorLogin.setValidarUsuario(servicioMock);
		ModelAndView mav = controladorLogin.login(usuario, requestMock);
		assertThat(mav.getModel().get("error")).isEqualTo("usuario-invalido");
		assertThat(mav.getViewName()).isEqualTo("ingresoIncorrecto");
	}
}