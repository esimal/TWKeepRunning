package ar.edu.unlam.tallerweb.keeprunning.test;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import org.junit.Assert;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.assertj.core.api.Assertions;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.controladores.ControladorCarreras;
import tallerweb.keeprunning.dao.CarreraDAO;
import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.CarreraServicios;

public class RegistrarUsuarioTest extends SpringTest{
	
	@Test
	@Transactional	
	public void pruebaQueSiLePasoUnIdDeCarreraInexistenteDaNull(){
		ControladorCarreras controlador = new ControladorCarreras();		
		Carrera carrera = new Carrera();
		carrera.setCarreraId((long) 0);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		CarreraServicios servicioMock = mock(CarreraServicios.class);		
		when (servicioMock.obtenerDatosCarreras(carrera.getCarreraId())).thenReturn(null);
		controlador.setObtenerDatosCarrera(servicioMock);
		ModelAndView mav = controlador.cargarDatosCarrera(carrera.getCarreraId(), requestMock);
		assertThat(mav.getViewName()).isEqualTo("carreraElegida");
	}

	@Autowired
	private UsuarioDAO usuarioDao;
	private UsuarioDAO usuarioDaoMock;
	
	@Test
	@Transactional
	@Rollback
	//Se prueba viendo que la cantidad de registros en la tabla Usuario sea la correcta luego de registrar el nuevo usuario
	public void probarQueRegistreUnUsuarioCorrectamente(){
		usuarioDao.grabarUsuario("Test", "Test", 12345679L, "22/07/1992", "test@gmail.com", "123", "123");
		List<Usuario> usuarios = usuarioDao.obtenerUsuarios();
		Assert.assertEquals(14, usuarios.size());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	//Se prueba viendo que la cantidad de registros en la tabla Usuario sea la correcta luego de registrar el nuevo usuario
	public void probarQueRegistreUnUsuarioCorrectamente2(){
		usuarioDaoMock = mock(UsuarioDAO.class);
		usuarioDaoMock.grabarUsuario("Test", "Test", 12345679L, "22/07/1992", "test@gmail.com", "123", "123");
		List<Usuario> usuarios = usuarioDaoMock.obtenerUsuarios();
		//Assert.assertEquals(12, usuarios.size());
		when (usuarioDaoMock.obtenerUsuarios()).thenReturn(usuarios);
		Assert.assertEquals("Test", usuarios.get(12).getNombre());
		//when (usuarioDaoMock.grabarUsuario(anyString(), anyString(), anyLong(), anyString(), anyString(), anyString(), anyString())).thenReturn(usuarios);
	}
}