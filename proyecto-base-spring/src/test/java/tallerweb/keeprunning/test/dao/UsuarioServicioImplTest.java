package tallerweb.keeprunning.test.dao;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServiciosImpl;

public class UsuarioServicioImplTest {

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
}
