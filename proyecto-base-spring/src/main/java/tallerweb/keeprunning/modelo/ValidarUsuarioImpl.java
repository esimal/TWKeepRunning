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
	//hay que cambiar el tipo de dato
	public List<Usuario> validarUsuario(String email, String password){
		//hay que pasarlo al dao
		Criteria criteria = sessionFactory.openSession().createCriteria(Usuario.class)
			.add(Restrictions.eq("email", email));
			return (List<Usuario>) criteria.list();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*@Override
	public List<Usuario> grabarUsuario(String nombre, String apellido, Integer dni, String fechaNac, String email,
			String password) {
		Criteria criteria = sessionFactory.openSession().createCriteria(Usuario.class)
		.add(Restrictions.eq("email", email));
		return (List<Usuario>) criteria.list();
	}*/
}

