package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface UsuarioServicios {
	public List<Usuario> validarUsuario(String email, String password);
	
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf);
	
	public List<Usuario> obtenerUsuarios();
}