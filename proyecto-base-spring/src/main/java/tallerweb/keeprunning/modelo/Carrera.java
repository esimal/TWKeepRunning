package tallerweb.keeprunning.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table (name="carrera", catalog="keeprunning")

public class Carrera implements java.io.Serializable{
	
	private Long carreraId;
	private String nombre;
	private String lugar;
	private String fechaInicio;
	private String horaInicio;
	private String imagenFlyer;
	private String imagenRecorrido;
	private Integer valor;
	private Set<Inscripcion> inscripcion = new HashSet<Inscripcion>();
	private Set<UsuarioCarrera> usuarioCarrera = new HashSet<UsuarioCarrera>(0);
	
	public Carrera(String nombre, String lugar, String fechaInicio, String horaInicio, String imagenFlyer, String imagenRecorrido, Integer valor, Set<Inscripcion> inscripcion, Set<UsuarioCarrera> usuarioCarrera){
		this.nombre = nombre;
		this.lugar = lugar;
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.imagenFlyer = imagenFlyer;
		this.imagenRecorrido = imagenRecorrido;
		this.valor = valor;
		this.inscripcion = inscripcion;
		this.usuarioCarrera = usuarioCarrera;
	}
	
	public Carrera() {
	}
	
	public Carrera(String nombre) {
		this.nombre = nombre;
	}
	
	public Carrera(Long carreraId, String nombre) {
		this.carreraId = carreraId;
		this.nombre = nombre;
	}
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "carreraId", unique=true, nullable=false)
	public Long getCarreraId() {
		return this.carreraId;
	}
	public void setCarreraId(Long carreraId) {
		this.carreraId = carreraId;
	}
	
	@Column(name = "nombre", nullable=false)
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "lugar", nullable=false)
	public String getLugar() {
		return this.lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	@Column(name = "fechaInicio", nullable=false)
	public String getFechaInicio() {
		return this.fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	@Column(name = "horaInicio", nullable=false)
	public String getHoraInicio() {
		return this.horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	@Column(name = "imagenFlyer")
	public String getImagenFlyer() {
		return this.imagenFlyer;
	}
	public void setImagenFlyer(String imagenFlyer) {
		this.imagenFlyer = imagenFlyer;
	}
	
	@Column(name = "imagenRecorrido")
	public String getImagenRecorrido() {
		return this.imagenRecorrido;
	}
	public void setImagenRecorrido(String imagenRecorrido) {
		this.imagenRecorrido = imagenRecorrido;
	}
	
	@Column(name = "valor", nullable=false)
	public Integer getValor() {
		return this.valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
	public Set<Inscripcion> getInscripcion() {
		return this.inscripcion;
	}
	
	public void setInscripcion(Set<Inscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.carrera")
	public Set<UsuarioCarrera> getUsuarioCarrera() {
		return this.usuarioCarrera;
	}
	
	public void setUsuarioCarrera(Set<UsuarioCarrera> usuarioCarrera) {
		this.usuarioCarrera = usuarioCarrera;
	}
}
