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
	
	/*Incluyo pasaje de objetos a traves de diferentes jsp : Pag 53 pdf de elias*/
	@RequestMapping(value="/registracion",  method = RequestMethod.POST)
	public ModelAndView guardarUsuario(Usuario classRegistrarse) {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("registrarseObj", classRegistrarse);
        modelAndView.setViewName("miPerfil");
        return modelAndView;
	}
	/*FIN LOGICA FORMULARIO REGISTRACION*/
}
