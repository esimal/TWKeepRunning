package tallerweb.keeprunning.dao;

public interface UsuarioDAO {
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf);
}
