package tallerweb.keeprunning.modelo;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class UsuarioCarreraId implements java.io.Serializable{

	private Usuario usuario;
	private Carrera carrera;

	@ManyToOne
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne
	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public boolean equals(Object o) {
		if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    UsuarioCarreraId that = (UsuarioCarreraId) o;

	    if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
	    if (carrera != null ? !carrera.equals(that.carrera) : that.carrera != null)
	    	return false;

	    return true;
    }

    public int hashCode() {
        int result;
        result = (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (carrera != null ? carrera.hashCode() : 0);
        return result;
    }
}