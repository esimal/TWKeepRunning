package tallerweb.keeprunning.servicios;

import java.util.Date;
import java.util.List;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.modelo.Usuario;

public interface RegistrarInscripcion {
	public List<Inscripcion> grabarInscripcion(Carrera carrera, Usuario usuario, Date fechaPago);
}
