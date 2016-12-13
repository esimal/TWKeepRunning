package tallerweb.keeprunning.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServicios;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorRegistracion {

	@RequestMapping(value="/registracion",  method = RequestMethod.GET)
	public ModelAndView vistaRegistrar(Model modelo) {
		ModelAndView altaUsuario = new ModelAndView();
		modelo.addAttribute("classRegistrarse", new Usuario());
		altaUsuario.setViewName("registracion");
		return altaUsuario;
	}

	@Inject
	private UsuarioServicios registarUsuario;
	
	@RequestMapping(value="/registracion",  method = RequestMethod.POST)
	public ModelAndView guardarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		registarUsuario.grabarUsuario(usuario);
		ModelAndView registracion = new ModelAndView();
		registracion.addObject("nombre", usuario.getNombre());
		registracion.addObject("apellido", usuario.getApellido());
		registracion.addObject("dni", usuario.getDni());
		registracion.addObject("fechaNac", usuario.getFechaNac());
		registracion.addObject("email", usuario.getEmail());
		registracion.addObject("password", usuario.getPassword());
		registracion.setViewName("registracionOk");
        return registracion;
	}

	public void setRegistrarUsuario(UsuarioServicios registrarUsuario) {
		this.registarUsuario = registrarUsuario;
	}
}