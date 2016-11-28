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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="inscripcion", catalog="keeprunning")
public class Inscripcion {
	
	private Long inscripcionId;
	private Carrera carrera;
	private Usuario usuario;
	private Date fechaPago = new Date();
	
	public Inscripcion(Carrera carrera, Usuario usuario, Date fechaPago) {
		this.carrera = carrera;
		this.usuario = usuario;
		this.fechaPago = fechaPago;
	}
	
	public Inscripcion() {
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "inscripcionId", unique=true, nullable=false)
	public Long getInscripcionId() {
		return this.inscripcionId;
	}
	public void setInscripcionId(Long inscripcionId) {
		this.inscripcionId = inscripcionId;
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
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fechaPago", nullable=false)
	public Date getFechaPago() {
		return this.fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
}
