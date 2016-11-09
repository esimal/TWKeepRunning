package tallerweb.keeprunning.modelo;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SpringTest {
	@Inject
	protected SessionFactory sessionFactory;
	protected Session getSession() {
	return this.sessionFactory.getCurrentSession();
	}
}
