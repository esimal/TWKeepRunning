package tallerweb.keeprunning.test.dao;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
//import static org.mockito.Mockito.*;

import javax.inject.Inject;

import tallerweb.keeprunning.dao.CarreraDAO;
import tallerweb.keeprunning.modelo.Carrera;
//import tallerweb.keeprunning.servicios.CarreraServiciosImpl;

public class CarreraServiciosImplTest extends SpringTest{

	@Inject
	CarreraDAO carreraDAO;
	
	/*
	@Test
	public void probarQueTraigaDatosDeCarreraCorrectamente(){
		CarreraServiciosImpl carreraServiciosImpl = new CarreraServiciosImpl();
		Carrera carrera = new Carrera("nombre","lugar","fecha","hora","iamgen1","imagen2",100);
		CarreraDAO carreraDaoMock = mock(CarreraDAO.class);
		carreraDaoMock.obtenerDatosCarreras(carrera.getCarreraId());
		carreraServiciosImpl.setCarreraDao(carreraDaoMock);
		assertThat(carrera.getNombre()).isEqualTo("nombre");
	}*/
	
	@Test
	@Rollback @Transactional
	public void obtenerDatosDeCarreraPorId(){
		Carrera carrera1 = new Carrera(1L,"Nombre","lugar","fecha","hora","imagenFlyer","imagenRecorrido",100);
		Carrera carrera2 = new Carrera(2L,"Nombre2","lugar2","fecha2","hora2","imagenFlyer2","imagenRecorrido2",200);
		getSession().save(carrera1);
		getSession().save(carrera2);
		Carrera carrera3 = new Carrera();
		Carrera carrera4 = new Carrera();
		carrera3 = carreraDAO.obtenerDatosCarreras(carrera1.getCarreraId());
		carrera4 = carreraDAO.obtenerDatosCarreras(carrera2.getCarreraId());
		assertThat(carrera3).isEqualTo(carrera1);
		assertThat(carrera4).isEqualTo(carrera2);
	}
}