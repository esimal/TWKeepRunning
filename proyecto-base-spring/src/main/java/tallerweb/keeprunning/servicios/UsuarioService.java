package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface UsuarioService {
	public List<Usuario> validarUsuario(String email, String password);
	
	/*public List<Usuario> grabarUsuario(String nombre, String apellido, Integer dni , String fechaNac,String email, String password);*/
}
