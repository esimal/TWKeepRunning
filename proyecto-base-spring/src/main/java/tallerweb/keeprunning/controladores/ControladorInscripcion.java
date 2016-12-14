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
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.InscripcionServicios;
import tallerweb.keeprunning.servicios.UsuarioServicios;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorInscripcion {

	@RequestMapping(value = "/inscripcion/{carreraId}", method = RequestMethod.GET)
	public ModelAndView datosInscripcion(@PathVariable("carreraId") Long carreraId) {
		Carrera carrera = new Carrera();
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("nombre", carrera.getNombre());
		datosCarrera.put("carreraId", carreraId);
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
	
	@RequestMapping(value = "/inscripcion-pago/{carreraId}", method = RequestMethod.GET)
	public ModelAndView vistaInscripcionPago(@PathVariable("carreraId") Long carreraId) {
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("carreraId", carreraId);
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(datosCarrera);
		return new ModelAndView("inscripcion-pago",datosCarrera);
	}
	
	//modificar para que tome el id de la carrera y del usuario
	@Inject
	private InscripcionServicios registrarInscripcion;
	@Inject
	private UsuarioServicios obtenerUsuario;
	
	@RequestMapping(value = "/inscripcion-fin/{carreraId}", method = RequestMethod.GET)
	public ModelAndView guardarInscripcion(@PathVariable("carreraId") Long carreraId, @ModelAttribute("inscripcion") Inscripcion inscripcion, HttpServletRequest request) {
		Carrera carrera = new Carrera();
		carrera.setCarreraId(carreraId);
		ModelMap ins = new ModelMap();
		Integer nroCorredor = inscripcion.getNroCorredor().nextInt(10000) + 1;
   		ins.put("nroCorredor", nroCorredor);		
		long usuarioId = (long) request.getSession().getAttribute("usuarioId");
		Usuario usuario = obtenerUsuario.obtenerUsuarioPorId(usuarioId);
		System.out.println(carreraId);
		System.out.println(usuarioId);
   		System.out.println(inscripcion.getFechaPago());
   		System.out.println(nroCorredor);
		registrarInscripcion.grabarInscripcion(carrera, usuario, inscripcion.getFechaPago(), inscripcion.getNroCorredor());
		ModelAndView vistaCarrera = new ModelAndView();
		vistaCarrera.addAllObjects(ins);
		return new ModelAndView("inscripcion-fin", ins);
	}

	public void setRegistrarInscripcion(InscripcionServicios registrarInscripcion) {
		this.registrarInscripcion = registrarInscripcion;
	}
}
