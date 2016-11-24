package tallerweb.keeprunning.modelo;

import java.util.List;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.servicios.ServicioCarrera;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class ObtenerDatosCarrerasImpl implements ServicioCarrera{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public Carrera obtenerDatosCarreras(Carrera carrera){
		Criteria cr = sessionFactory.openSession().createCriteria(Carrera.class);
		cr.add(Restrictions.eq("id", carrera.getId()));
		List carreras = cr.list();
		return (Carrera) carreras;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}