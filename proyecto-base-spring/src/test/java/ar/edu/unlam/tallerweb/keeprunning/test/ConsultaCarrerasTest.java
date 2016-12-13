package ar.edu.unlam.tallerweb.keeprunning.test;

import org.junit.Test;

import org.junit.Assert;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.dao.CarreraDAO;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.servicios.UsuarioServicios;

public class ConsultaCarrerasTest extends SpringTest{

	//@Autowired
	//private CarreraDAO carreraDaoMock;

	@Test
	@Transactional
	//Se prueba viendo que la cantidad de registros en la tabla Usuario sea la correcta luego de registrar el nuevo usuario
	public void probarQueTraigaDatosDeCarreraCorrectamente(){
		CarreraDAO carreraDaoMock = mock(CarreraDAO.class);
		List<Carrera> carreras = carreraDaoMock.obtenerDatosCarreras(8L);
		when(carreraDaoMock.obtenerDatosCarreras(anyLong())).thenReturn(carreras);
		Assert.assertEquals(12, carreras.size());
		//Assert.assertEquals("Carrera 21K Runderful", carreras.get(1).getNombre());
		//assertThat(carrera.getNombre());
	}
}