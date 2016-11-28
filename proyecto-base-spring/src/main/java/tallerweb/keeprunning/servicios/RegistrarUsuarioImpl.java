package tallerweb.keeprunning.servicios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.RegistrarUsuario;;

@Service
@ContextConfiguration(locations={"/hibernateContext.xml"})
public class RegistrarUsuarioImpl implements RegistrarUsuario {
		
	@Inject
	private SessionFactory sessionFactory;
	
	public List<Usuario> grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf){
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDni(dni);
		usuario.setFechaNac(fechaNac);
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setPasswordConf(passwordConf);
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(usuario);
		s.getTransaction().commit();
		List<Usuario> resultado = null;
		return resultado;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}