package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface UsuarioService {
	public List<Usuario> validarUsuario(String email, String password);
}
