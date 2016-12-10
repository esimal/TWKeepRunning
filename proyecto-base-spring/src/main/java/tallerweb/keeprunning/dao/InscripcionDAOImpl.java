package tallerweb.keeprunning.dao;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.modelo.Usuario;

@Service
public class InscripcionDAOImpl implements InscripcionDAO  {
		
	@Autowired
 	private SessionFactory sessionFactory;
	
	@Transactional
	public void grabarInscripcion(Carrera carrera, Usuario usuario, Date fechaPago, Random nroCorredor){
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCarrera(carrera);
		inscripcion.setUsuario(usuario);
		inscripcion.setFechaPago(fechaPago);
		inscripcion.setNroCorredor(nroCorredor);
		Session s = sessionFactory.openSession();
		s.save(inscripcion);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}