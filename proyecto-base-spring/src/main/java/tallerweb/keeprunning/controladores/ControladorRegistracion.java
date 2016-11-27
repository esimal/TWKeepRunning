package tallerweb.keeprunning.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Usuario;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorRegistracion {

	/*INICIO LOGICA FORMULARIO REGISTRACION*/
	@RequestMapping(value="/registracion",  method = RequestMethod.GET)
	public ModelAndView vistaRegistrar(Model modelo) {
		ModelAndView altaUsuario = new ModelAndView();
		modelo.addAttribute("classRegistrarse", new Usuario());
		altaUsuario.setViewName("registracion");
		return altaUsuario;
	}
	
	@RequestMapping(value="/registracion",  method = RequestMethod.POST)
	public ModelAndView guardarUsuario(Usuario classRegistrarse) {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("registrarseObj", classRegistrarse);
        modelAndView.setViewName("miPerfil");
        return modelAndView;
	}
	/*
	@Inject
	public RegistrarUsuario registrarUsuario;
	/*INICIO LOGICA FORMULARIO REGISTRACION
	@RequestMapping(value="/registracion",  method = RequestMethod.POST)
	public ModelAndView crearUsuario(@ModelAttribute Usuario usuario, ModelMap model, HttpServletRequest req) {
		registrarUsuario.registrarUsuario(usuario);
		req.getSession().setAttribute("usuario", usuario.getNombre());
		model.addAttribute("nombre", usuario.getNombre());
		model.addAttribute("apellido", usuario.getApellido());
		model.addAttribute("dni", usuario.getDni());
		model.addAttribute("email", usuario.getEmail());
		model.addAttribute("fechaNac", usuario.getFechaNac());
		model.addAttribute("password", usuario.getPassword());
		model.addAttribute("passwordConf", usuario.getPasswordConf());
		return new ModelAndView("vistaRegistracion",model);
	}*/
	/*FIN LOGICA FORMULARIO REGISTRACION*/
}
