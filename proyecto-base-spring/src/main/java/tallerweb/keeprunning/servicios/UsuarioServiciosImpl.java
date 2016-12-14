package tallerweb.keeprunning.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServicios;

@Service
public class UsuarioServiciosImpl implements UsuarioServicios{
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	public Usuario buscarUsuario(String email, String password){
		List <Usuario> usuarios = usuarioDao.obtenerUsuarios();
		for(int i=0;i<usuarios.size();i++){
			if(email.equals(usuarios.get(i).getEmail()) && password.equals(usuarios.get(i).getPassword())){
				Usuario usuario = usuarios.get(i);
				return usuario;
			}
		}
		Usuario usuario=null;
		return usuario;
	}
	
	@Transactional
	public void grabarUsuario(Usuario usuario){
		usuarioDao.grabarUsuario(usuario);
	}
	
	@Transactional
	public List<Usuario> obtenerUsuarios(){
		return usuarioDao.obtenerUsuarios();
	}

	@Transactional
	public Usuario obtenerUsuarioPorId(Long usuarioId){
		return usuarioDao.obtenerUsuarioPorId(usuarioId);
	}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}