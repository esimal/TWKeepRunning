package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface UsuarioServicios {
	public Usuario validarUsuario(String email, String password);
	
	public void grabarUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
}