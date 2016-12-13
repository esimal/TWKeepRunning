package ar.edu.unlam.tallerweb.keeprunning.test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Random;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.controladores.ControladorInscripcion;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.InscripcionServicios;

public class ControladorInscripcionTest {
	
	@Test
	public void testQuePruebaQueLuegoDeRealizarUnaInscripcionVaALaVistaInscripcionFin(){
		ControladorInscripcion controladorInscripcion = new ControladorInscripcion();
		Carrera carrera = new Carrera();
		Usuario usuario = new Usuario();
		Date fechaPago = new Date();
		Random nroCorredor = new Random();
		Inscripcion inscripcion = new Inscripcion(carrera, usuario, fechaPago, nroCorredor);
		InscripcionServicios servicioMock = mock(InscripcionServicios.class);
		servicioMock.grabarInscripcion(inscripcion);
		controladorInscripcion.setRegistrarInscripcion(servicioMock);
		ModelAndView mav = controladorInscripcion.guardarInscripcion(inscripcion);
		assertThat(mav.getViewName()).isEqualTo("inscripcion-fin");
	}
}
