package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Carrera;

public interface ObtenerDatosCarrera {
	public List<Carrera> obtenerDatosCarreras(Long carreraId);
}
