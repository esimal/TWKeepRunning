package tallerweb.keeprunning.test.dao;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import tallerweb.keeprunning.dao.CarreraDAO;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.servicios.CarreraServiciosImpl;

public class ConsultaCarrerasTest extends SpringTest{

	@Test
	public void probarQueTraigaDatosDeCarreraCorrectamente(){
		CarreraServiciosImpl carreraServiciosImpl = new CarreraServiciosImpl();
		Carrera carrera = new Carrera("nombre","lugar","fecha","hora","iamgen1","imagen2",100);
		CarreraDAO carreraDaoMock = mock(CarreraDAO.class);
		carreraDaoMock.obtenerDatosCarreras(carrera.getCarreraId());
		carreraServiciosImpl.setCarreraDao(carreraDaoMock);
		carreraServiciosImpl.obtenerDatosCarreras(carrera.getCarreraId());
		assertThat(carrera.getNombre()).isEqualTo("nombre");
	}
}