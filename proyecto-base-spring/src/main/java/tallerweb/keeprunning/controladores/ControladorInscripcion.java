package tallerweb.keeprunning.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.servicios.RegistrarInscripcion;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorInscripcion {

	@RequestMapping(value = "/inscripcion/{carreraId}", method = RequestMethod.GET)
	public ModelAndView datosInscripcion(@PathVariable("carreraId") Long carreraId) {
		Carrera carrera = new Carrera();		
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("nombre", carrera.getNombre());
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(datosCarrera);
		vistaCarrera.setViewName("inscripcion");
		return vistaCarrera;
		}
	
	@RequestMapping(value = "/inscripcion-pago", method = RequestMethod.GET)
	public ModelAndView vistaInscripcionPago() {
		return new ModelAndView("inscripcion-pago");
	}
	
	//modificar para que tome el id de la carrera y del usuario
	@Inject
	private RegistrarInscripcion registrarInscripcion;
	@RequestMapping(value = "/inscripcion-fin", method = RequestMethod.GET)
	public ModelAndView guardarInscripcion(@ModelAttribute("inscripcion") Inscripcion inscripcion, HttpServletRequest request) {
		registrarInscripcion.grabarInscripcion(inscripcion.getCarrera(), inscripcion.getUsuario(), inscripcion.getFechaPago(), inscripcion.getNroCorredor());
		ModelMap ins = new ModelMap();
		Integer nroCorredor = inscripcion.getNroCorredor().nextInt(10000) + 1;
		System.out.println(inscripcion.getCarrera());
   		System.out.println(inscripcion.getUsuario());
   		System.out.println(inscripcion.getFechaPago());
   		ins.addAttribute("nroCorredor", nroCorredor);
   		System.out.println(nroCorredor);
		return new ModelAndView("inscripcion-fin", ins);
	}
}
