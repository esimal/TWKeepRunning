package tallerweb.keeprunning.servicios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.servicios.ObtenerDatosCarrera;;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class ObtenerDatosCarrerasImpl implements ObtenerDatosCarrera{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Carrera> obtenerDatosCarreras(Long carreraId){
		Criteria cr = sessionFactory.openSession().createCriteria(Carrera.class);
		cr.add(Restrictions.eq("carreraId", carreraId));
		List<Carrera> resultado = cr.list(); 
		return resultado;
	}

	/*public ObtenerDatosCarrera getObtenerDatosCarrera(){
		return obtenerDatosCarrera;
	}
	
	public void setObtenerDatosCarrera(ObtenerDatosCarrera obtenerDatosCarrera){
		this.obtenerDatosCarrera = obtenerDatosCarrera;
	}*/
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}