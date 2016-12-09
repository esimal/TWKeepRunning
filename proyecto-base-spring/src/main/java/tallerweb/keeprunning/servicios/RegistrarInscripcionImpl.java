package tallerweb.keeprunning.servicios;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.modelo.Usuario;

@Service
public class RegistrarInscripcionImpl implements RegistrarInscripcion {
		
	@Inject
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<Inscripcion> grabarInscripcion(Carrera carrera, Usuario usuario, Date fechaPago, Random nroCorredor){
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCarrera(carrera);
		inscripcion.setUsuario(usuario);
		inscripcion.setFechaPago(fechaPago);
		inscripcion.setNroCorredor(nroCorredor);
		Session s = sessionFactory.openSession();
		s.save(inscripcion);
		List<Inscripcion> resultado = null;
		return resultado;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}