package tallerweb.keeprunning.servicios;

import java.util.Date;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.dao.InscripcionDAO;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Usuario;

@Service
public class RegistrarInscripcionImpl implements RegistrarInscripcion {
		
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private InscripcionDAO inscripcionDao;
	
	@Transactional
	public void grabarInscripcion(Carrera carrera, Usuario usuario, Date fechaPago, Random nroCorredor){
		inscripcionDao.grabarInscripcion(carrera, usuario, fechaPago, nroCorredor);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}