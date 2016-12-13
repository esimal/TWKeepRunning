package tallerweb.keeprunning.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	
	/*public Usuario validarUsuario(String email, String password){
		List <Usuario> usuarios = usuarioDAO.obtenerUsuarios();
		for(int i=0;i<usuarios.size();i++){
			if(email.equals(usuarios.get(i).getEmail()) && password.equals(usuarios.get(i).getPassword())){
				Usuario usuario = usuarios.get(i);
				return usuario;
			}
		}
		Usuario usuario=null;
		return usuario;
	}*/
		/*Criteria cr = sessionFactory.openSession().createCriteria(Usuario.class);
		Criterion mail = Restrictions.eq("email", email);
		Criterion pass = Restrictions.eq("password", password);
		LogicalExpression validar = Restrictions.and(mail, pass);
		cr.add(validar);
		Usuario resultado = cr.();
		return resultado;*/
	
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerUsuarios(){
		List <Usuario> usuarios = sessionFactory.openSession().createCriteria(Usuario.class).list();
		//cr.add(Restrictions.isNotNull("usuarioId"));
		//List<Usuario> resultado = cr.list(); 
		return usuarios;
	}
}	