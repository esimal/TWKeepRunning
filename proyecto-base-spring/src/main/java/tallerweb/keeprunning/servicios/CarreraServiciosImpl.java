package tallerweb.keeprunning.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tallerweb.keeprunning.dao.CarreraDAO;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.servicios.CarreraServicios;;

@Service
public class CarreraServiciosImpl implements CarreraServicios{

	@Autowired
	private CarreraDAO carreraDao;
	
	public List<Carrera> obtenerDatosCarreras(Long carreraId){
		return carreraDao.obtenerDatosCarreras(carreraId);
	}

	public void setCarreraDao(CarreraDAO carreraDAO) {
		this.carreraDao = carreraDAO;
	}
}