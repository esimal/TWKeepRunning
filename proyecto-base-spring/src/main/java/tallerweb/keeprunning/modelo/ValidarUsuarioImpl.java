package tallerweb.keeprunning.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.servicios.UsuarioService;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class ValidarUsuarioImpl implements UsuarioService{
	
	@Inject
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	public List<Usuario> validarUsuario(String email, String password){
		Criteria criteria = sessionFactory.openSession().createCriteria(Usuario.class)
			.add(Restrictions.eq("email", email));
			return (List<Usuario>) criteria.list();

		/*List<Usuario> resultado = sessionFactory.openSession().createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.list();
		return resultado;*/
		/*Query query = sessionFactory.openSession().createQuery("SELECT u.email FROM Usuario u where u.email ='" +email+"'");
		List<Usuario> resultado = query.list();
		return resultado;*/
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}

