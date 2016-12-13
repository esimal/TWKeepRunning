package tallerweb.keeprunning.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.modelo.Usuario;

@Repository
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
	
	@SuppressWarnings("unchecked")
	public List<Usuario> validarUsuario(String email, String password){
		Criteria cr = sessionFactory.openSession().createCriteria(Usuario.class);
		Criterion mail = Restrictions.eq("email", email);
		Criterion pass = Restrictions.eq("password", password);
		LogicalExpression validar = Restrictions.and(mail, pass);
		cr.add(validar);
		List<Usuario> resultado = cr.list();
		return resultado;
	}
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerUsuarios(){
		Criteria cr = sessionFactory.openSession().createCriteria(Usuario.class);
		cr.add(Restrictions.isNotNull("usuarioId"));
		List<Usuario> resultado = cr.list(); 
		return resultado;
	}
}	