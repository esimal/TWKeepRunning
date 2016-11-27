package tallerweb.keeprunning.modelo;

import java.util.List;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.servicios.ValidarUsuario;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class ValidarUsuarioImpl implements ValidarUsuario{
	
	@Inject
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Usuario> validarUsuario(String email, String password){
		//hay que pasarlo al dao
		Criteria cr = sessionFactory.openSession().createCriteria(Usuario.class);
		Criterion mail = Restrictions.eq("email", email);
		Criterion pass = Restrictions.eq("password", password);
		LogicalExpression validar = Restrictions.and(mail, pass);
		cr.add(validar);
		return (List<Usuario>) cr.list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}