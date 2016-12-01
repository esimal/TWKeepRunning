package ar.edu.unlam.tallerweb.keeprunning.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;
import tallerweb.keeprunning.controladores.ControladorCarreras;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.servicios.ObtenerDatosCarrerasImpl;


public class ConsultaCarrerasTest extends SpringTest{
	@Test
	@Transactional
	public void pruebaQueSiLePasoUnIdDeCarreraInexistenteDaNull() {
	Carrera carreraMock = mock(Carrera.class);
	HttpServletRequest requestMock = mock(HttpServletRequest.class);
	ObtenerDatosCarrerasImpl servicioMock = mock(ObtenerDatosCarrerasImpl.class);
	Carrera carrera = new Carrera();
	carrera.setCarreraId((long) 11);
	ControladorCarreras controlador = new ControladorCarreras();
	when (controlador.cargarDatosCarrera(carreraMock.getCarreraId(), requestMock)).thenReturn(null);
	}
}