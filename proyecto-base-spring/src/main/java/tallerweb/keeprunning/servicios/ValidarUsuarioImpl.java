package tallerweb.keeprunning.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.ValidarUsuario;

@Service
public class ValidarUsuarioImpl implements ValidarUsuario{
	
	@Autowired
	private UsuarioDAO usuarioDao;
	
	public List<Usuario> validarUsuario(String email, String password){
		return usuarioDao.validarUsuario(email, password);
	}
}