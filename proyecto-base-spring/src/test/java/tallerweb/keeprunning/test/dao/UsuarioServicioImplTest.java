package tallerweb.keeprunning.test.dao;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServiciosImpl;

public class UsuarioServicioImplTest extends SpringTest{

	@Test
	public void testQueBuscaUnEmailYPasswordValidosParaLoguearse(){
		UsuarioServiciosImpl usuarioServiciosImpl = new UsuarioServiciosImpl();
		Usuario usuario = new Usuario("TestNombre", "TestApellido", 12345679L, "test@gmail.com", "123", "123", "22/07/1992");
		UsuarioDAO usuarioDaoMock = mock(UsuarioDAO.class);
		List <Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(usuario);
		when(usuarioDaoMock.obtenerUsuarios()).thenReturn(usuarios);
		usuarioServiciosImpl.setUsuarioDAO(usuarioDaoMock);
		Usuario actual = usuarioServiciosImpl.buscarUsuario("test@gmail.com", "123");
		assertEquals(usuario,actual);
	}
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Test
	@Rollback @Transactional
	//Se prueba viendo que la cantidad de registros en la tabla Usuario sea la correcta luego de registrar el nuevo usuario
	public void testQuePruebaQueRegistreUnUsuarioCorrectamenteYQuedaElRegistroGrabadoEnLaBase(){
		Usuario usuario = new Usuario("Test", "Test", 12345679L, "test@gmail.com", "123", "123", "02/08/1993");
		usuarioDao.grabarUsuario(usuario);
		List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
		Assert.assertEquals(6, usuarios.size());
	}
}
