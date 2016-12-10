package tallerweb.keeprunning.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.Usuario;

@Service
public class UsuarioDAOImpl implements UsuarioDAO{

	@Autowired
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf){	
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setDni(dni);
		usuario.setFechaNac(fechaNac);
		usuario.setEmail(email);
		usuario.setPassword(password);
		usuario.setPasswordConf(passwordConf);
		Session s = sessionFactory.openSession();
		s.save(usuario);		
	}
}	