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
	
	public List<Usuario> validarUsuario(String email, String password){
		return usuarioDao.validarUsuario(email, password);
	}
	
	@Transactional
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf){
		usuarioDao.grabarUsuario(nombre, apellido, dni, fechaNac, email, password, passwordConf);
	}
}