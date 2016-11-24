package tallerweb.keeprunning.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Carrera;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorInscripcion {

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
}
