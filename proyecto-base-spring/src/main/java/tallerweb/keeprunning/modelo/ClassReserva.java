package tallerweb.keeprunning.modelo;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Reserva")

public class ClassReserva {
	
	@Id
	@Column(name="Id")
	private Integer ID;
	
	@Column(name="Fecha")
	private String fecha;
	
	@Column(name="ID_Corredor")
	private Integer id_corredor;
	
	@Column(name="Id_Carrera")
	private Integer id_carrera;
	
	@Column(name="Fecha_Pago")
	private Date fecha_pago;
	
	@Column(name="Nro_Comprobante")
	private Integer nro_comprobante;
	
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getId_corredor() {
		return id_corredor;
	}
	public void setId_corredor(Integer id_corredor) {
		this.id_corredor = id_corredor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Integer getId_carrera() {
		return id_carrera;
	}
	public void setId_carrera(Integer id_carrera) {
		this.id_carrera = id_carrera;
	}
	public Date getFecha_pago() {
		return fecha_pago;
	}
	public void setFecha_pago(Date fecha_pago) {
		this.fecha_pago = fecha_pago;
	}
	public Integer getNro_comprobante() {
		return nro_comprobante;
	}
	public void setNro_comprobante(Integer nro_comprobante) {
		this.nro_comprobante = nro_comprobante;
	}

	
	
	
}
