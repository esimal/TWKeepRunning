package tallerweb.keeprunning.servicios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.modelo.Inscripcion;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class ObtenerCarrerasInscriptasImpl implements ObtenerCarrerasInscriptas{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Inscripcion> obtenerCarrerasInscriptas(Long usuarioId){
		Criteria cr = sessionFactory.openSession().createCriteria(Inscripcion.class);
		cr.add(Restrictions.eq("usuario", usuarioId));
		List<Inscripcion> resultado = cr.list(); 
		return resultado;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}