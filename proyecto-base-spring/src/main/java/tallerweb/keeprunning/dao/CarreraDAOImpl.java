package tallerweb.keeprunning.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.Carrera;

@Repository
public class CarreraDAOImpl implements CarreraDAO{
	
	@Autowired
 	private SessionFactory sessionFactory;
	
	@Transactional
	public Carrera obtenerDatosCarreras(Long carreraId){
		Carrera carrera = (Carrera)sessionFactory.getCurrentSession()
							.createCriteria(Carrera.class)
							.add(Restrictions.eq("carreraId", carreraId))
							.uniqueResult();
		return carrera;
		/*Criteria cr = sessionFactory.openSession().createCriteria(Carrera.class);
		cr.add(Restrictions.eq("carreraId", carreraId));
		List<Carrera> resultado = cr.list(); 
		return resultado;*/
	}
}
