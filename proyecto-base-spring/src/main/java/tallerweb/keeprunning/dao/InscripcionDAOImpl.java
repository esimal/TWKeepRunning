package tallerweb.keeprunning.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.Inscripcion;

@Repository
public class InscripcionDAOImpl implements InscripcionDAO  {
		
	@Autowired
 	private SessionFactory sessionFactory;
	
	@Transactional
	public void grabarInscripcion(Inscripcion inscripcion){
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