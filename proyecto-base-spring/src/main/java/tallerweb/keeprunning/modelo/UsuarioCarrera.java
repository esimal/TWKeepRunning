package tallerweb.keeprunning.modelo;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuarioCarrera", catalog = "keeprunning")
@AssociationOverrides({
		@AssociationOverride(name = "pk.usuarioId",
			joinColumns = @JoinColumn(name = "usuarioId")),
		@AssociationOverride(name = "pk.carreraId",
			joinColumns = @JoinColumn(name = "carreraId")) })

public class UsuarioCarrera implements java.io.Serializable{

	private UsuarioCarreraId pk = new UsuarioCarreraId();
	private Long nroRemera;
	private Long puesto;
	private String tiempo;
 
	public UsuarioCarrera() {
	}
	
	@EmbeddedId
	public UsuarioCarreraId getPk() {
		return this.pk;
	}

	public void setPk(UsuarioCarreraId pk) {
		this.pk = pk;
	}

	@Transient
	public Usuario getUsuario() {
		return getPk().getUsuario();
	}

	public void setUsuario(Usuario usuario) {
		getPk().setUsuario(usuario);
	}

	@Transient
	public Carrera getCarrera() {
		return getPk().getCarrera();
	}

	public void setCarrera(Carrera carrera) {
		getPk().setCarrera(carrera);
	}

	@Column(name = "nroRemera", nullable = false)
    public Long nroRemera() {
        return this.nroRemera;
    }
    public void nroRemera(Long nroRemera) {
        this.nroRemera = nroRemera;
    }
    
    @Column(name = "puesto")
    public Long puesto() {
        return this.puesto;
    }
    public void puesto(Long puesto) {
        this.nroRemera = puesto;
    }
    
    @Column(name = "tiempo")
    public String tiempo() {
        return this.tiempo;
    }
    public void tiempo(String tiempo) {
        this.tiempo = tiempo;
    }
	

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UsuarioCarrera that = (UsuarioCarrera) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}