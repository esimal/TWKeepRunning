package tallerweb.keeprunning.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

	@Autowired
 	private SessionFactory sessionFactory;	

	@Transactional
	public void grabarUsuario(Usuario usuario){	
		Session s = sessionFactory.openSession();
		s.save(usuario);		
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerUsuarios(){
		List <Usuario> usuarios = sessionFactory.openSession().createCriteria(Usuario.class).list();
		return usuarios;
	}
	
	@Transactional
	public Long obtenerUsuarioIdPorEmail(String email){
		Long usuarioId = (Long)sessionFactory.getCurrentSession()
				.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
		return usuarioId;
	}
}	