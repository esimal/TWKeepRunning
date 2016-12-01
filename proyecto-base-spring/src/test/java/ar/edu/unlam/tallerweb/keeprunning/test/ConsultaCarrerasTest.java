package ar.edu.unlam.tallerweb.keeprunning.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.controladores.ControladorCarreras;
import tallerweb.keeprunning.modelo.Carrera;

import tallerweb.keeprunning.servicios.ObtenerDatosCarrera;;

public class ConsultaCarrerasTest {
	
	@Test
	@Transactional	
	public void pruebaQueSiLePasoUnIdDeCarreraInexistenteDaNull() {
		ControladorCarreras controlador = new ControladorCarreras();		
		Carrera carrera = new Carrera();
		carrera.setCarreraId((long) 12);
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		ObtenerDatosCarrera servicioMock = mock(ObtenerDatosCarrera.class);		
		when (servicioMock.obtenerDatosCarreras(carrera.getCarreraId())).thenReturn(null);
		controlador.setObtenerDatosCarrera(servicioMock);
		ModelAndView mav = controlador.cargarDatosCarrera(carrera.getCarreraId(), requestMock);
		assertThat(mav.getViewName()).isEqualTo("carreraElegida");
	}
}