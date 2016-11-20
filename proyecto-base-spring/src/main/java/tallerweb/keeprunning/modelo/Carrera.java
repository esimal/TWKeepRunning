package tallerweb.keeprunning.modelo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Carrera")
public class Carrera {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer ID;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Lugar")
	private String lugar;
	
	@Column(name="FechaInicio")
	private String fechaInicio;
	
	@Column(name="HoraInicio")
	private String horaInicio;
	
	@Column(name="ImagenFlyer")
	private String imagenFlyer;
	
	@Column(name="ImagenRecorrido")
	private String imagenRecorrido;
	
	@Column(name="Valor")
	private Integer valor;

	@PostConstruct
	private void initBean(){
		System.out.println("inicio initBean!!");
	}

	@PreDestroy
	private void destroyBean(){
		System.out.println("fin destroyBean!!!");		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}
	public String getImagenFlyer() {
		return imagenFlyer;
	}
	public void setImagenFlyer(String imagenFlyer) {
		this.imagenFlyer = imagenFlyer;
	}
	public String getImagenRecorrido() {
		return imagenRecorrido;
	}
	public void setImagenRecorrido(String imagenRecorrido) {
		this.imagenRecorrido = imagenRecorrido;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public void abrirDetalleDeCarreraPorId(Integer ID){
		this.ID = ID;
		this.lugar = "Campus Universidad de San Andrés (Vito Dumas 284, Victoria 1644 Buenos Aires)";
		this.fechaInicio = "Domingo 23 de octubre de 2016";
		this.horaInicio = "10KM y 3KM 9:00hs.";
		if (this.ID == 1) {
			this.nombre = "Carrera de la Mujer";
			this.imagenFlyer = "/proyecto-base-spring/img/carrera-mujer-2016.jpg";
		}else if (this.ID == 2){
			this.nombre = "Carrera de Neon";	
			this.imagenFlyer = "/proyecto-base-spring/img/carrera-neon.jpg";
		}else if (this.ID == 3){
			this.nombre = "Carrera por la Educacion";
			this.imagenFlyer = "/proyecto-base-spring/img/carrera-educacion.jpg";
		}else if (this.ID == 4){
			this.nombre = "Carrera My Run";
			this.imagenFlyer = "/proyecto-base-spring/img/carrera21.jpg";
		}else if (this.ID == 5){
			this.nombre = "Carrera Tandil";
			this.imagenFlyer = "/proyecto-base-spring/img/flyer-1.jpg";
		}else if (this.ID == 6){
			this.nombre = "Carrera XEU";	
			this.imagenFlyer = "/proyecto-base-spring/img/kitcompetencia.jpg";
		}else if (this.ID == 7){
			this.nombre = "Carrera Nocturna";	
			this.imagenFlyer = "/proyecto-base-spring/img/maraton-lasrozas.jpg";
		}else if (this.ID == 8){
			this.nombre = "Carrera Runderful";	
			this.imagenFlyer = "/proyecto-base-spring/img/carrera22.png";
		}else if (this.ID == 9){
			this.nombre = "Carrera Espiritu del Vino";	
			this.imagenFlyer = "/proyecto-base-spring/img/rioja-winerun.jpg";
		}else if (this.ID == 10){
			this.nombre = "Carrera Bariloche";	
			this.imagenFlyer = "/proyecto-base-spring/img/the-north-face.jpg";
		}else if (this.ID == 11){
			this.nombre = "Carrera UCH";	
			this.imagenFlyer = "/proyecto-base-spring/img/uch-10k-2016.jpg";		
		}else{
			this.nombre = "Carrera Triathlon";	
			this.imagenFlyer = "/proyecto-base-spring/img/vitoria.jpg";	
		}
		this.imagenRecorrido = "/proyecto-base-spring/img/circuito21kba.jpg";
		this.valor = 250;
	}

	public Carrera(Integer cant, String nombre) {
		this.ID = cant;
		this.nombre = nombre;
	}
	
	public Carrera(String cant) {
		this.nombre = cant;
	}
	
	public Carrera() {
		
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
		
}
