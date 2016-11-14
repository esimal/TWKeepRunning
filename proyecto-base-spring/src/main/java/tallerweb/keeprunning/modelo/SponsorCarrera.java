package tallerweb.keeprunning.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Sponsor_Carrera")

public class SponsorCarrera {
	
	@Id
	@Column(name="Id")
	private Integer ID;
	
	@Column(name="Id_Sponsor")
	private String id_sponsor;
	
	@Column(name="Id_Carrera")
	private Integer id_carrera;
	
	@Column(name="Monto_Invertido")
	private Integer monto_invertido;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getId_sponsor() {
		return id_sponsor;
	}
	public void setId_sponsor(String id_sponsor) {
		this.id_sponsor = id_sponsor;
	}
	public Integer getId_carrera() {
		return id_carrera;
	}
	public void setId_carrera(Integer id_carrera) {
		this.id_carrera = id_carrera;
	}
	public Integer getMonto_invertido() {
		return monto_invertido;
	}
	public void setMonto_invertido(Integer monto_invertido) {
		this.monto_invertido = monto_invertido;
	}
}
