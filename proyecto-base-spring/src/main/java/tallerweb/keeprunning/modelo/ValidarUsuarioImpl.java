package tallerweb.keeprunning.modelo;

import org.springframework.stereotype.Service;

import tallerweb.keeprunning.modelopersona.Persona;
import tallerweb.keeprunning.serviciocarreras.ServicioCarreras;

@Service
public class ValidarUsuarioImpl implements ServicioCarreras{
	public String validarUsuario(Usuario email, Usuario password) {
		return null;
	}
}

