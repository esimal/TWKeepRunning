package tallerweb.keeprunning.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.List;

import tallerweb.keeprunning.modelo.Carrera;

public abstract class ClasePersistente {

	Session session = null;
	List resultado = (List) session.createCriteria(Carrera.class)
			.list();
	private SessionFactory sessionFactory;
	private EntityManager manager;
	
}
