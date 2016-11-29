/*package tallerweb.keeprunning.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.modelo.Usuario;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerUsuario(String email, String password){
		Criteria cr = sessionFactory.openSession().createCriteria(Usuario.class);
		Criterion mail = Restrictions.eq("email", email);
		Criterion pass = Restrictions.eq("password", password);
		LogicalExpression validar = Restrictions.and(mail, pass);
		cr.add(validar);
		List<Usuario> resultado = cr.list();
		return resultado;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
*/