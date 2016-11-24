package tallerweb.keeprunning.modelo;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.servicios.ServicioCarrera;
import tallerweb.keeprunning.servicios.UsuarioService;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class ObtenerDatosCarrerasImpl implements ServicioCarrera{
	
	@Inject
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	public List<Carrera> obtenerDatosCarreras(String carrera){
		Query query = sessionFactory.openSession().createQuery("SELECT * FROM Carrera c where c.id ='" +carrera+"'");
		List<Carrera> resultado = query.list();
		return resultado;
		//Ver como devolver todos los campos necesarios, y llevarlos al controladoCarreras
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

