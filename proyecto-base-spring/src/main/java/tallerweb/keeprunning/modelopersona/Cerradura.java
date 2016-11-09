package tallerweb.keeprunning.modelopersona;

public class Cerradura {
	
	private Integer clave;
	private Integer intentos;
	private Integer cantIntentosFallidos;
			
	public boolean abrir(Integer claveActual){
		if (this.clave.equals(claveActual))
			return true;
		else 
		{	
			cantIntentosFallidos++;
			return false;
		}	
	}

	public boolean estaBloqueada(){
		if (this.intentos.equals(cantIntentosFallidos))
			return true;
		else
			return false;
	}
	
	public Cerradura(Integer clave){
		this.clave = 1234;
		this.intentos = 3;
		this.cantIntentosFallidos = 0;
	}
}
