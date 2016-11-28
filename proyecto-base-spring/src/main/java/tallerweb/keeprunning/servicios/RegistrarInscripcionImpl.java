package tallerweb.keeprunning.servicios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.modelo.Usuario;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class RegistrarInscripcionImpl implements RegistrarInscripcion {
		
	@Inject
	private SessionFactory sessionFactory;
	
	public List<Inscripcion> grabarInscripcion(Carrera carrera, Usuario usuario, Date fechaPago){
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCarrera(carrera);
		inscripcion.setUsuario(usuario);
		inscripcion.setFechaPago(fechaPago);
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(inscripcion);
		s.getTransaction().commit();
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