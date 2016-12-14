package tallerweb.keeprunning.dao;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface UsuarioDAO {
	
	public void grabarUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
	
	public Usuario obtenerUsuarioPorId(Long usuarioId);
}