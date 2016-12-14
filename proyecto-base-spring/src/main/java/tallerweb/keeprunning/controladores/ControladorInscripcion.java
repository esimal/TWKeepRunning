package tallerweb.keeprunning.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.InscripcionServicios;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorInscripcion {

	@RequestMapping(value = "/inscripcion/{carreraId}/{usuarioId}", method = RequestMethod.GET)
	public ModelAndView datosInscripcion(@PathVariable("carreraId") Long carreraId, @PathVariable("usuario") Long usuarioId) {
		Carrera carrera = new Carrera();
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("nombre", carrera.getNombre());
		datosCarrera.put("carreraId", carreraId);
		datosCarrera.put("usuarioId", usuarioId);
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(datosCarrera);
		vistaCarrera.setViewName("inscripcion");
		return vistaCarrera;
		}
	/*
	@RequestMapping(value = "/inscripcion-pago", method = RequestMethod.GET)
	public ModelAndView vistaInscripcionPago() {
		return new ModelAndView("inscripcion-pago");
	}*/
	
	@RequestMapping(value = "/inscripcion-pago/{carreraId}/{usuarioId}", method = RequestMethod.GET)
	public ModelAndView vistaInscripcionPago(@PathVariable("carreraId") Long carreraId, @PathVariable("usuario") Long usuarioId) {
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("carreraId", carreraId);
		datosCarrera.put("usuarioId", usuarioId);
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(datosCarrera);
		return new ModelAndView("inscripcion-pago",datosCarrera);
	}
	
	//modificar para que tome el id de la carrera y del usuario
	@Inject
	private InscripcionServicios registrarInscripcion;
	
	@RequestMapping(value = "/inscripcion-fin/{carreraId}/{usuarioId}", method = RequestMethod.GET)
	public ModelAndView guardarInscripcion(@PathVariable("carreraId") Long carreraId, @PathVariable("usuario") Long usuarioId, @ModelAttribute("inscripcion") Inscripcion inscripcion) {
		Carrera carrera = new Carrera();
		carrera.setCarreraId(carreraId);
		//Usuario usuario = new Usuario();
		//usuario.setUsuarioId(usuarioId);
		registrarInscripcion.grabarInscripcion(carrera, inscripcion.getUsuario(), inscripcion.getFechaPago(), inscripcion.getNroCorredor());
		ModelMap ins = new ModelMap();
		Integer nroCorredor = inscripcion.getNroCorredor().nextInt(10000) + 1;
		System.out.println(carreraId);
   		System.out.println(usuarioId);
   		System.out.println(inscripcion.getFechaPago());
   		ins.put("nroCorredor", nroCorredor);
   		//ins.put("carreraId", carreraId);
   		System.out.println(nroCorredor);
   		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(ins);
		return new ModelAndView("inscripcion-fin", ins);
	}

	public void setRegistrarInscripcion(InscripcionServicios registrarInscripcion) {
		this.registrarInscripcion = registrarInscripcion;
	}
}
