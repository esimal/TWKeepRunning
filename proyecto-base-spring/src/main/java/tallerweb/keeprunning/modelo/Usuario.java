package tallerweb.keeprunning.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
@Component
@Scope("session")
@Entity
@Table(name = "Usuario")
public class Usuario {

	/*Esta clase tiene todos los atributos del formulario Registrarse y Esta funcionando*/
	@Id
	@Column(name="email")	
	private String email;
	
	@Column(name="nombre")	
	private String nombre;
	
	@Column(name="apellido")	
	private String apellido;
	
	@Column(name="dni")	
	private Integer dni;
	
	@Column(name="fechaNac")	
	private String fechaNac;
	
	@Column(name="password")	
	private String password;
	
	@Column(name="rol")	
	private String rol;
	
	@Column(name="passwordConf")	
	private String passwordConf;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}	

	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	public String getPasswordConf() {
		return passwordConf;
	}
	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}		
}



/*extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
throws ServletException, IOException {
String user = req.getParameter("user");
String pass = req.getParameter("password");
if ("prueba".equals(user) && "prueba".equals(pass)) {
response(resp, "Logueo Correcto");
} else {
response(resp, "Logueo Incorrecto");
}
}
private void response(HttpServletResponse resp, String msg)
throws IOException {
PrintWriter out = resp.getWriter();
out.println("<html>");
out.println("<body>");
out.println("<t1>" + msg + "</t1>");
out.println("<body>");
out.println("<html>");
}
}*/
