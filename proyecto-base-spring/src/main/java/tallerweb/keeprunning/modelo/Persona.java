package tallerweb.keeprunning.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Persona {
	private long id; /*lo defino como autoincremental (@Id @GeneratedValue ...)*/
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
