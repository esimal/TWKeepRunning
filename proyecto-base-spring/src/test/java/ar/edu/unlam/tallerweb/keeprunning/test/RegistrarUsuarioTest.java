package ar.edu.unlam.tallerweb.keeprunning.test;

import org.junit.Test;

import org.junit.Assert;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServiciosImpl;

public class RegistrarUsuarioTest extends SpringTest{
	
	@Test
	public void testQueRegistreUnUsuarioTesteandoUnMetodoDeUnServicioQueLlamaUnMetodoDao(){
		UsuarioServiciosImpl usuarioServiciosImpl = new UsuarioServiciosImpl();
		Usuario usuario = new Usuario("TestNombre", "TestApellido", 12345679L, "test@gmail.com", "123", "123", "22/07/1992");
		UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
		usuarioDaoMock.grabarUsuario(usuario);
		usuarioServiciosImpl.setUsuarioDAO(usuarioDaoMock);
		usuarioServiciosImpl.grabarUsuario(usuario);
		assertThat(usuario.getNombre()).isEqualTo("TestNombre");
		assertThat(usuario.getApellido()).isEqualTo("TestApellido");
		assertThat(usuario.getDni()).isEqualTo(12345679L);
		assertThat(usuario.getEmail()).isEqualTo("test@gmail.com");
		assertThat(usuario.getPassword()).isEqualTo("123");
		assertThat(usuario.getPasswordConf()).isEqualTo("123");
		assertThat(usuario.getFechaNac()).isEqualTo("22/07/1992");
	}
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Test
	//Se prueba viendo que la cantidad de registros en la tabla Usuario sea la correcta luego de registrar el nuevo usuario
	public void testQuePruebaQueRegistreUnUsuarioCorrectamenteYQuedaElRegistroGrabadoEnLaBase(){
		Usuario usuario = new Usuario("Test", "Test", 12345679L, "test@gmail.com", "123", "123", "02/08/1993");
		usuarioDao.grabarUsuario(usuario);
		List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
		Assert.assertEquals(20, usuarios.size());
	}
}