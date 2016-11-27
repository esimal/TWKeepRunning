package tallerweb.keeprunning.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="reserva", catalog="keeprunning")
public class Reserva {
	
	private Long reservaId;
	private Carrera carrera;
	private Usuario usuario;
	private Date fechaPago;
	private Long nroComprobante;
	
	public Reserva(Carrera carrera, Usuario usuario, Date fechaPago, Long nroComprobante) {
		this.carrera = carrera;
		this.usuario = usuario;
		this.fechaPago = fechaPago;
		this.nroComprobante = nroComprobante;
	}
	
	public Reserva() {
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "reservaId", unique=true, nullable=false)
	public Long getReservaId() {
		return this.reservaId;
	}
	public void setReservaId(Long reservaId) {
		this.reservaId = reservaId;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "carreraId", nullable = false)
	public Carrera getCarrera() {
		return this.carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuarioId", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Column(name = "fechaPago", nullable=false)
	public Date getFechaPago() {
		return this.fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	@Column(name = "nroComprobante", nullable=false)
	public Long getNroComprobante() {
		return this.nroComprobante;
	}
	public void setNroComprobante(Long nroComprobante) {
		this.nroComprobante = nroComprobante;
	}
}
