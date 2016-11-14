package tallerweb.keeprunning.controladores;


import javax.inject.Inject;
import javax.inject.Scope;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.hibernate.Session;
import org.junit.runner.Request;

/*import javax.inject.Inject;*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.serviciocarreras.ServicioCarreras;

//import tallerweb.keeprunning.modelo.Carrera;

//import tallerweb.keeprunning.serviciocarreras.ServicioCarreras;


@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorCarreras {
	/*@RequestMapping("/init")
	public ModelAndView cargarDatos(){
		//Carrera carrera = Carrera.getInstance();
		
	Carrera c1 = new Carrera();
	c1.setNombre("Carrera de la Mujer");
	c1.setLugar("Campus Universidad de San Andrés (Vito Dumas 284, Victoria 1644 Buenos Aires)");
	c1.setFechaInicio("Domingo 23 de octubre de 2016");
	c1.setImagenFlyer("/proyecto-base-spring/img/carrera-mujer-2016.jpg");
	
	ModelAndView modeloReturn = new ModelAndView();
	modeloReturn.setViewName("redirect:./");
	return modeloReturn;
}*/
	
	@RequestMapping(value = "/carrera={carrera}", method = RequestMethod.GET)
	public ModelAndView cargarDatosCarrera(@PathVariable("carrera") int id) {
		Carrera c1 = new Carrera();
		c1.abrirDetalleDeCarreraPorId(id);
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("id", c1.getID());		
		datosCarrera.put("nombre", c1.getNombre());
		datosCarrera.put("lugar", c1.getLugar());
		datosCarrera.put("fecha", c1.getFechaInicio());
		datosCarrera.put("hora", c1.getHoraInicio());
		datosCarrera.put("imagenFlyer", c1.getImagenFlyer());
		datosCarrera.put("imagenRecorrido", c1.getImagenRecorrido());
		datosCarrera.put("valor", c1.getValor());
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(datosCarrera);
		vistaCarrera.setViewName("carreraElegida");
		return vistaCarrera;
	}
	
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
	/*
	@RequestMapping(value = "/miPerfil", method = RequestMethod.GET)
	public ModelAndView cargaDatosSession() {
		ModelMap datos = new ModelMap();
		datos.put("nombre", "nombre");
		ModelAndView vistaDatos = new ModelAndView();
		vistaDatos.addAllObjects(datos);
		vistaDatos.setViewName("miPerfil");
		return vistaDatos;
		}
		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView vistaLogin() {
		return new ModelAndView("login");
	}*/

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView vistaLogin (Model modelo) {
		ModelAndView login = new ModelAndView();
		modelo.addAttribute("classLogin", new Usuario());
		login.setViewName("login");
		return login;
	}	
	
	@RequestMapping(value="/login",  method = RequestMethod.POST)
	/* hay que meter el servicio y buscar los datos en la base!!!! */
	public ModelAndView ingresarUsuario(@ModelAttribute("classLogin") Usuario usuario, HttpServletRequest request) {
		if(usuario.getEmail().equals("mariano9@hotmail.com") && usuario.getPassword().equals("dmc")){
			ModelMap model = new ModelMap();
			request.getSession().setAttribute("logueo", "usuario-logueado");
			return new ModelAndView("inscripcion", model);
		} else {
			ModelMap model = new ModelMap();
			model.put("error", "usuario-invalido");
			return new ModelAndView("login", model);
		}		
	}
	
	@RequestMapping(value = "/inscripcion/{id}", method = RequestMethod.GET)
	public ModelAndView datosInscripcion(@PathVariable("id") int id) {
		Carrera c1 = new Carrera();
		c1.abrirDetalleDeCarreraPorId(id);		
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("nombre", c1.getNombre());
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(datosCarrera);
		vistaCarrera.setViewName("inscripcion");
		return vistaCarrera;
		}
	
	@RequestMapping(value = "/inscripcion-pago/{logueo}", method = RequestMethod.GET)
	public ModelAndView vistaInscripcion(@PathVariable("logueo") String logueo) {
		ModelMap model = new ModelMap();
		model.put("logueo", logueo);
		return new ModelAndView("inscripcion-pago", model);
	}
	
	/*@RequestMapping(value="/carrera1",  method = RequestMethod.GET)
	public ModelAndView vista() {
		ModelAndView detalleCarrera = new ModelAndView();
		detalleCarrera.setViewName("carreraElegida");
		/*modelAndView.addObject("message", "Infografia");
		return detalleCarrera;
	}*/
	
	
	/*@Inject
	private ServicioCarreras saludoAPersona;*/
	
	/*
	@RequestMapping(value="/proyecto-base-spring/proyecto-base-spring/login")
	public ModelAndView vistaLogin() { ModelAndView modelAndView2 = new
	ModelAndView(); modelAndView2.setViewName("login"); return modelAndView2;
	}
	 */
}