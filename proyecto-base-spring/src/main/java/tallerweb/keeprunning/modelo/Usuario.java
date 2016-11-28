package tallerweb.keeprunning.modelo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario", catalog = "keeprunning")

public class Usuario implements java.io.Serializable{

	private Long usuarioId;
	private String nombre;
	private String apellido;
	private Long dni;
	private String email;
	private String password;
	private String passwordConf;
	private String fechaNac;
	private Set<Inscripcion> inscripcion = new HashSet<Inscripcion>(0);
	private Set<UsuarioCarrera> usuarioCarrera = new HashSet<UsuarioCarrera>(0);
	
	public Usuario(String nombre, String apellido, Long dni, String email, String password, String passwordConf, Date fechaNac, Set<Inscripcion> inscripcion, Set<UsuarioCarrera> usuarioCarrera){
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.passwordConf = passwordConf;
		this.inscripcion = inscripcion;
		this.usuarioCarrera = usuarioCarrera;
	}
	
	public Usuario() {
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "usuarioId", unique=true, nullable=false)
	public Long getUsuarioId() {
		return this.usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name = "apellido", nullable = false)
	public String getApellido() {
		return this.apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@Column(name = "dni", nullable = false)
	public Long getDni() {
		return this.dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	@Column(name = "email", nullable = false)
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "fechaNac", nullable = false)
	public String getFechaNac() {
		return this.fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "passwordConf", nullable = false)
	public String getPasswordConf() {
		return this.passwordConf;
	}
	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Inscripcion> getInscripcion() {
		return this.inscripcion;
	}
	
	public void setInscripcion(Set<Inscripcion> inscripcion) {
		this.inscripcion = inscripcion;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.usuario", cascade=CascadeType.ALL)
	public Set<UsuarioCarrera> getUsuarioCarrera() {
		return this.usuarioCarrera;
	}

	public void setUsuarioCarrera(Set<UsuarioCarrera> usuarioCarrera) {
		this.usuarioCarrera = usuarioCarrera;
	}
}