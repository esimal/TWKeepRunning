package tallerweb.keeprunning.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.RegistrarUsuario;

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
	private RegistrarUsuario registarUsuario;
	@RequestMapping(value="/registracion",  method = RequestMethod.POST)
	public ModelAndView guardarUsuario(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		registarUsuario.grabarUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getDni(), usuario.getFechaNac(), usuario.getEmail(), usuario.getPassword(), usuario.getPasswordConf());
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
}