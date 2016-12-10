package tallerweb.keeprunning.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tallerweb.keeprunning.dao.UsuarioDAO;
import tallerweb.keeprunning.servicios.RegistrarUsuario;;

@Service
public class RegistrarUsuarioImpl implements RegistrarUsuario {

	@Autowired
	private UsuarioDAO usuarioDao;
	
	@Transactional
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf){
		usuarioDao.grabarUsuario(nombre, apellido, dni, fechaNac, email, password, passwordConf);
	}
}