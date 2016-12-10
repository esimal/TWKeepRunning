package tallerweb.keeprunning.dao;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface UsuarioDAO {
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf);

	public List<Usuario> validarUsuario(String email, String password);
}