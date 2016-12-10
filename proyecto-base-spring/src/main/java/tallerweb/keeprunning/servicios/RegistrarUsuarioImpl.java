package tallerweb.keeprunning.servicios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.servicios.RegistrarUsuario;;

@Service
public class RegistrarUsuarioImpl implements RegistrarUsuario {
		
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Transactional
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf){
		usuarioDao.grabarUsuario(nombre, apellido, dni, fechaNac, email, password, passwordConf);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}