package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Carrera;

public interface CarreraServicios {
	public List<Carrera> obtenerDatosCarreras(Long carreraId);
}
