package tallerweb.keeprunning.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.dao.InscripcionDAO;
import tallerweb.keeprunning.modelo.Inscripcion;

@Service
public class InscripcionServiciosImpl implements InscripcionServicios {

	@Autowired
	private InscripcionDAO inscripcionDao;
	
	@Transactional
	public void grabarInscripcion(Inscripcion inscripcion){
		inscripcionDao.grabarInscripcion(inscripcion);
	}

}