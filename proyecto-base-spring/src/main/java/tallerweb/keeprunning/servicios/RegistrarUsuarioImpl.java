package tallerweb.keeprunning.servicios;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.pruebas.SpringTest;
import tallerweb.keeprunning.modelo.Usuario;
/*
@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class RegistrarUsuarioImpl implements RegistrarUsuario{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Transactional
	@Commit
	public void registrarUsuario(Usuario usuario){
		usuario.setNombre(usuario.getNombre());
		usuario.setApellido(usuario.getApellido());
		usuario.setDni(usuario.getDni());
		usuario.setEmail(usuario.getEmail());
		usuario.setFechaNac(usuario.getFechaNac());
		usuario.setPassword(usuario.getPassword());
		usuario.setPasswordConf(usuario.getPasswordConf());
		Session s = (Session) getSessionFactory();
		s.save(usuario);
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}*/
