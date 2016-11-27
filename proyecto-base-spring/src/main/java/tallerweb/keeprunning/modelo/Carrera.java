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
	private Set<Reserva> reserva = new HashSet<Reserva>();
	private Set<UsuarioCarrera> usuarioCarrera = new HashSet<UsuarioCarrera>(0);
	
	public Carrera(String nombre, String lugar, String fechaInicio, String horaInicio, String imagenFlyer, String imagenRecorrido, Integer valor, Set<Reserva> reserva, Set<UsuarioCarrera> usuarioCarrera){
		this.nombre = nombre;
		this.lugar = lugar;
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.imagenFlyer = imagenFlyer;
		this.imagenRecorrido = imagenRecorrido;
		this.valor = valor;
		this.reserva = reserva;
		this.usuarioCarrera = usuarioCarrera;
	}
	
	public Carrera() {
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
	public Set<Reserva> getReserva() {
		return this.reserva;
	}
	
	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.carrera")
	public Set<UsuarioCarrera> getUsuarioCarrera() {
		return this.usuarioCarrera;
	}
	
	public void setUsuarioCarrera(Set<UsuarioCarrera> usuarioCarrera) {
		this.usuarioCarrera = usuarioCarrera;
	}
	
	public void abrirDetalleDeCarreraPorId(Long carreraId){
		this.carreraId = carreraId;
		this.lugar = "Campus Universidad de San Andrés (Vito Dumas 284, Victoria 1644 Buenos Aires)";
		this.fechaInicio = "Domingo 23 de octubre de 2016";
		this.horaInicio = "10KM y 3KM 9:00hs.";
		if (this.carreraId == 1) {
			this.nombre = "Carrera de la Mujer";
			this.imagenFlyer = "/proyecto-base-spring/img/carrera-mujer-2016.jpg";
		}else if (this.carreraId == 2){
			this.nombre = "Carrera de Neon";	
			this.imagenFlyer = "/proyecto-base-spring/img/carrera-neon.jpg";
		}else if (this.carreraId == 3){
			this.nombre = "Carrera por la Educacion";
			this.imagenFlyer = "/proyecto-base-spring/img/carrera-educacion.jpg";
		}else if (this.carreraId == 4){
			this.nombre = "Carrera My Run";
			this.imagenFlyer = "/proyecto-base-spring/img/carrera21.jpg";
		}else if (this.carreraId == 5){
			this.nombre = "Carrera Tandil";
			this.imagenFlyer = "/proyecto-base-spring/img/flyer-1.jpg";
		}else if (this.carreraId == 6){
			this.nombre = "Carrera XEU";	
			this.imagenFlyer = "/proyecto-base-spring/img/kitcompetencia.jpg";
		}else if (this.carreraId == 7){
			this.nombre = "Carrera Nocturna";	
			this.imagenFlyer = "/proyecto-base-spring/img/maraton-lasrozas.jpg";
		}else if (this.carreraId == 8){
			this.nombre = "Carrera Runderful";	
			this.imagenFlyer = "/proyecto-base-spring/img/carrera22.png";
		}else if (this.carreraId == 9){
			this.nombre = "Carrera Espiritu del Vino";	
			this.imagenFlyer = "/proyecto-base-spring/img/rioja-winerun.jpg";
		}else if (this.carreraId == 10){
			this.nombre = "Carrera Bariloche";	
			this.imagenFlyer = "/proyecto-base-spring/img/the-north-face.jpg";
		}else if (this.carreraId == 11){
			this.nombre = "Carrera UCH";	
			this.imagenFlyer = "/proyecto-base-spring/img/uch-10k-2016.jpg";		
		}else{
			this.nombre = "Carrera Triathlon";	
			this.imagenFlyer = "/proyecto-base-spring/img/vitoria.jpg";	
		}
		this.imagenRecorrido = "/proyecto-base-spring/img/circuito21kba.jpg";
		this.valor = 250;
	}		
}
