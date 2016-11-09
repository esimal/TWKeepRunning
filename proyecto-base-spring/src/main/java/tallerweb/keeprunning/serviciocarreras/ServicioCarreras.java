package tallerweb.keeprunning.serviciocarreras;

import tallerweb.keeprunning.modelo.Usuario;

public interface ServicioCarreras {
	public String validarUsuario(Usuario email, Usuario password);
	
}
