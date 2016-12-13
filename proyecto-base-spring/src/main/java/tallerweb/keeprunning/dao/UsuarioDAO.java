package tallerweb.keeprunning.dao;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface UsuarioDAO {
	public void grabarUsuario(Usuario usuario);

	//public Usuario validarUsuario(String email, String password);
	
	public List<Usuario> obtenerUsuarios();
}