package tallerweb.keeprunning.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

/*import javax.inject.Inject;*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.pruebas.SpringTest;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Usuario;

//import tallerweb.keeprunning.modelo.Carrera;

//import tallerweb.keeprunning.serviciocarreras.ServicioCarreras;


@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorCarreras extends SpringTest{
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
		
	@RequestMapping(value = "/todasLasCarreras", method = RequestMethod.GET)
	public ModelAndView cargarTodasLasCarreras() {
		Carrera c1 = new Carrera(1, "Carrera Triathlon");
		ModelMap datosCarrera = new ModelMap();
		
		datosCarrera.put("id", c1.getID());		
		datosCarrera.put("nombre", c1.getNombre());

		/*Session s = getSession();

		s.save(c1);*/
		
		ModelAndView vistaCarreras = new ModelAndView("carreraElegida2");
		vistaCarreras.addAllObjects(datosCarrera);
		return vistaCarreras;
	}
	
	@RequestMapping(value = "/todasLasCarreras_de_ref", method = RequestMethod.GET)
	public ModelAndView cargarTodasLasCarreras2() {
		List<String> list = getList();
		ModelAndView model = new ModelAndView("carreraElegida2");
		model.addObject("lists", list);

		return model;
	}
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("List A");
		list.add("List B");
		list.add("List C");
		list.add("List D");
		list.add("List 1");
		list.add("List 2");
		list.add("List 3");

		return list;

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

	@RequestMapping(value = "/login={nombre}", method = RequestMethod.GET)
	public ModelAndView vistaLogin (Model modelo) {
		ModelAndView login = new ModelAndView();
		modelo.addAttribute("classLogin", new Usuario());
		login.setViewName("login");
		return login;
	}	
	
	@RequestMapping(value="/login={nombre}",  method = RequestMethod.POST)
	/* hay que meter el servicio y buscar los datos en la base!!!! */
	public ModelAndView ingresarUsuario(@ModelAttribute("classLogin") Usuario usuario, HttpServletRequest request, @PathVariable("nombre") String nombre) {
		if(usuario.getEmail().equals("mariano9@hotmail.com") && usuario.getPassword().equals("dmc")){
			ModelMap model = new ModelMap();
			model.put("nombre", nombre);
			request.getSession().setAttribute("logueo", "mariano9@hotmail.com");
			if (nombre.equals("0")){
				return new ModelAndView("redirect:/");
			}else{
				return new ModelAndView("inscripcion", model);				
			}

		} else {
			ModelMap model = new ModelMap();
			model.put("error", "usuario-invalido");
			request.getSession().invalidate();
			return new ModelAndView("login", model);
		}		
	}

	@RequestMapping(value = "/0", method = RequestMethod.GET)
	public ModelAndView vistaLogout (HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/proyecto-base-spring/0", method = RequestMethod.GET)
	public ModelAndView vistaLogout2 (HttpServletRequest request) {
		request.getSession().invalidate();
		return new ModelAndView("redirect:/");
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

	@RequestMapping(value = "/proyecto-base-spring/inscripcion/{id}", method = RequestMethod.GET)
	public ModelAndView datosInscripcion2(@PathVariable("id") int id) {
		Carrera c1 = new Carrera();
		c1.abrirDetalleDeCarreraPorId(id);		
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("nombre", c1.getNombre());
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(datosCarrera);
		vistaCarrera.setViewName("inscripcion");
		return vistaCarrera;
		}
	
	/*@RequestMapping(value = "/inscripcion/{id}", method = RequestMethod.GET)
	public ModelAndView vistaInscripcion(Model modelo) {
		ModelAndView Inscripcion = new ModelAndView();
		modelo.addAttribute("classInscripcion", new Usuario());
		Inscripcion.setViewName("Inscripcion");
		return Inscripcion;
	}
	
	
	@RequestMapping(value="/inscripcion={id}",  method = RequestMethod.POST)
	public ModelAndView inscribir(@ModelAttribute("classInscripcion") Usuario usuario, @PathVariable("id") String id) {
			ModelMap model = new ModelMap();
			return new ModelAndView("inscripcion", model);	
	}*/
	
	@RequestMapping(value = "/inscripcion-pago", method = RequestMethod.GET)
	public ModelAndView vistaInscripcion() {
		ModelMap model = new ModelMap();
		return new ModelAndView("inscripcion-pago", model);
	}

	@RequestMapping(value = "/proyecto-base-spring/inscripcion-pago", method = RequestMethod.GET)
	public ModelAndView vistaInscripcion2() {
		ModelMap model = new ModelMap();
		return new ModelAndView("inscripcion-pago", model);
	}
	
	@RequestMapping(value = "/inscripcion-fin", method = RequestMethod.GET)
	public ModelAndView vistaInscripcionFin() {
		return new ModelAndView("inscripcion-fin");
	}

	@RequestMapping(value = "/proyecto-base-spring/inscripcion-fin", method = RequestMethod.GET)
	public ModelAndView vistaInscripcionFin2() {
		return new ModelAndView("inscripcion-fin");
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