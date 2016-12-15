package tallerweb.keeprunning.test.controladores;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import tallerweb.keeprunning.controladores.ControladorLogin;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServicios;

public class ControladorLoginTest {
	
	@Test
	public void testLoguearseConUsuarioYPassIncorrectosDeberiaIrALaVistaIngresoIncorrecto() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
		Usuario usuario = new Usuario();
		usuario.setEmail("mailIncorrecto@gmail.com");
		usuario.setPassword("passwordIncorrecta");
		
		UsuarioServicios servicioMock = mock(UsuarioServicios.class);
		//when (servicioMock.buscarUsuario(usuario.getEmail(), usuario.getPassword())).thenReturn(null);
		when (servicioMock.buscarUsuario(anyString(), anyString())).thenReturn(null);
		
		ControladorLogin controladorLogin = new ControladorLogin();
		controladorLogin.setValidarUsuarioMock(servicioMock);
		
		ModelAndView mav = controladorLogin.login(usuario, requestMock);
		assertThat(mav.getModel().get("error")).isEqualTo("usuario-invalido");
		assertThat(mav.getViewName()).isEqualTo("ingresoIncorrecto");
	}
	
	@Test
	public void testLoguearseConUsuarioYPassCorrectosDeberiaIrALaVistaIndex() {
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		when(requestMock.getSession()).thenReturn(mock(HttpSession.class));
		
		Usuario usuario = new Usuario("TestNombre", "TestApellido", 12345679L, "test@gmail.com", "123", "123", "22/07/1992");
		
		UsuarioServicios servicioMock = mock(UsuarioServicios.class);
		//when (servicioMock.buscarUsuario(usuario.getEmail(), usuario.getPassword())).thenReturn(usuario);
		when (servicioMock.buscarUsuario(anyString(), anyString())).thenReturn(usuario);
		
		ControladorLogin controladorLogin = new ControladorLogin();
		controladorLogin.setValidarUsuarioMock(servicioMock);

		ModelAndView mav = controladorLogin.login(usuario, requestMock);
		/*assertThat(usuario.getNombre()).isEqualTo("TestNombre");
		assertThat(usuario.getApellido()).isEqualTo("TestApellido");
		assertThat(usuario.getDni()).isEqualTo(12345679L);
		assertThat(usuario.getEmail()).isEqualTo("test@gmail.com");
		assertThat(usuario.getPassword()).isEqualTo("123");
		assertThat(usuario.getPasswordConf()).isEqualTo("123");
		assertThat(usuario.getFechaNac()).isEqualTo("22/07/1992");*/
		assertThat(mav.getViewName()).isEqualTo("redirect:/");
	}
}