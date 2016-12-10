package tallerweb.keeprunning.dao;

import java.util.List;

import tallerweb.keeprunning.modelo.Carrera;

public interface CarreraDAO {
	public List<Carrera> obtenerDatosCarreras(Long carreraId);
}
