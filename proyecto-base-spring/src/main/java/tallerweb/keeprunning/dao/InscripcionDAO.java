package tallerweb.keeprunning.dao;

import java.util.Date;
import java.util.Random;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Usuario;

public interface InscripcionDAO {
	public void grabarInscripcion(Carrera carrera, Usuario usuario, Date fechaPago, Random nroCorredor);
}
