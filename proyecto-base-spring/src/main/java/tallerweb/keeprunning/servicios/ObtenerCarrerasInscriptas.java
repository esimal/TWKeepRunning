package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Inscripcion;

public interface ObtenerCarrerasInscriptas {
	public List<Inscripcion> obtenerCarrerasInscriptas(Long usuarioId);
}
