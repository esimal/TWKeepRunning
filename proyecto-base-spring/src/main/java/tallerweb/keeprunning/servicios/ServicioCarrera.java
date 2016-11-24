package tallerweb.keeprunning.servicios;

import java.util.List;

import tallerweb.keeprunning.modelo.Carrera;

public interface ServicioCarrera {
	public List<Carrera> obtenerDatosCarreras(String carrera);
}
