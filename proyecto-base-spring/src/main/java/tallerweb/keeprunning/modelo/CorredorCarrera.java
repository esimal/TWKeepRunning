package tallerweb.keeprunning.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="Corredor_Carrera")

public class CorredorCarrera {
	
	@Id
	@Column(name="Id")
	private Integer ID;
	
	@Column(name="Nro_Remera")
	private Integer nro_remera;
	
	@Column(name="Puesto")
	private Integer puesto;
	
	@Column(name="Tiempo")
	private String tiempo;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getNro_remera() {
		return nro_remera;
	}
	public void setNro_remera(Integer nro_remera) {
		this.nro_remera = nro_remera;
	}
	public Integer getPuesto() {
		return puesto;
	}
	public void setPuesto(Integer puesto) {
		this.puesto = puesto;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	
	
	
}
