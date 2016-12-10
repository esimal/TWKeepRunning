package tallerweb.keeprunning.servicios;

public interface RegistrarUsuario {
	public void grabarUsuario(String nombre, String apellido, Long dni , String fechaNac, String email, String password, String passwordConf);
}