package tallerweb.keeprunning.modelopersona;

import org.springframework.stereotype.Service;

import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.serviciocarreras.ServicioCarreras;

@Service
public class SaludarPersonaImpl implements ServicioCarreras{
	public String validarUsuario(Usuario email, Usuario password){
		return "Hola!!";
	}
}
