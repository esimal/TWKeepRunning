package tallerweb.keeprunning.test.dao;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServiciosImpl;

public class UsuarioDaoTest extends SpringTest{

	@Test
	public void testQueBuscaUnEmailYPasswordValidosParaLoguearse(){
		UsuarioServiciosImpl usuarioServiciosImpl = new UsuarioServiciosImpl();
		Usuario usuario = new Usuario("TestNombre", "TestApellido", 12345679L, "test@gmail.com", "123", "123", "22/07/1992");
		Usuario usuario2 = new Usuario("TestNombre", "TestApellido", 12345679L, "hola@gmail.com", "456", "123", "22/07/1992");
		UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
		List <Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		usuarios.add(usuario2);
		when(usuarioDaoMock.obtenerUsuarios()).thenReturn(usuarios);
		usuarioServiciosImpl.setUsuarioDAO(usuarioDaoMock);
		Usuario actual = usuarioServiciosImpl.buscarUsuario("test@gmail.com", "123");
		Usuario actual2 = usuarioServiciosImpl.buscarUsuario("chau@gmail.com", "789");
		Usuario actual3 = usuarioServiciosImpl.buscarUsuario("hola@gmail.com", "456");
		assertEquals(actual,usuario);
		assertThat(actual2).isNotEqualTo(usuario2);
		assertEquals(actual3,usuario2);
		//assertThat(usuarios).hasSize(2);
	}
	
	@Inject
	private UsuarioDAO usuarioDao;
	
	@Test
	@Rollback @Transactional
	public void testQuePruebaQueRegistreUnUsuarioCorrectamenteYQuedaElRegistroGrabadoEnLaBase(){
		Usuario usuario = new Usuario("Test", "Test", 123456789L, "test@gmail.com", "123", "123", "02/08/1993");
		Usuario usuario2 = new Usuario("prueba", "prueba", 987654321L, "prueba@gmail.com", "456", "456", "08/02/1993");
		usuarioDao.grabarUsuario(usuario);
		usuarioDao.grabarUsuario(usuario2);
		List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
		assertThat(usuarios).hasSize(4);
	}
}
