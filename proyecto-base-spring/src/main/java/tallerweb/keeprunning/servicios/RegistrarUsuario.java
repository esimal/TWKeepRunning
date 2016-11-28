package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Usuario;

public interface RegistrarUsuario {
	public List<Usuario> grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf);
}