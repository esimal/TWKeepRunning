package tallerweb.keeprunning.modelo;

public class Carrera {
	
	private Integer ID;
	private String nombre;
	private String lugar;
	private String fechaInicio;
	private String horaInicio;
	private String imagenFlyer;
	private String imagenRecorrido;
	private Integer valor;
	
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
		this.nombre = "Carrera de la Mujer";
		this.lugar = "Campus Universidad de San Andrés (Vito Dumas 284, Victoria 1644 Buenos Aires)";
		this.fechaInicio = "Domingo 23 de octubre de 2016";
		this.horaInicio = "10KM y 3KM 9:00hs.";
		if (this.ID == 1) {
		this.imagenFlyer = "/proyecto-base-spring/img/carrera-mujer-2016.jpg";
		}else if (this.ID == 2){
		this.imagenFlyer = "/proyecto-base-spring/img/carrera-neon.jpg";
		}else if (this.ID == 3){
		this.imagenFlyer = "/proyecto-base-spring/img/carrera-educacion.jpg";
		}else if (this.ID == 4){
		this.imagenFlyer = "/proyecto-base-spring/img/carrera21.jpg";
		}else if (this.ID == 5){
		this.imagenFlyer = "/proyecto-base-spring/img/flyer-1.jpg";
		}else if (this.ID == 6){
		this.imagenFlyer = "/proyecto-base-spring/img/kitcompetencia.jpg";
		}else if (this.ID == 7){
		this.imagenFlyer = "/proyecto-base-spring/img/maraton-lasrozas.jpg";
		}else if (this.ID == 8){
		this.imagenFlyer = "/proyecto-base-spring/img/carrera22.png";
		}else if (this.ID == 9){
		this.imagenFlyer = "/proyecto-base-spring/img/rioja-winerun.jpg";
		}else if (this.ID == 10){
		this.imagenFlyer = "/proyecto-base-spring/img/the-north-face.jpg";
		}else if (this.ID == 11){
		this.imagenFlyer = "/proyecto-base-spring/img/uch-10k-2016.jpg";		
		}else{
		this.imagenFlyer = "/proyecto-base-spring/img/vitoria.jpg";	
		}
		this.imagenRecorrido = "/proyecto-base-spring/img/circuito21kba.jpg";
		this.valor = 250;
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
