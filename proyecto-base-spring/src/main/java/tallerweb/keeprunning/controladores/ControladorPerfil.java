package tallerweb.keeprunning.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.modelo.Inscripcion;
import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.ObtenerCarrerasInscriptas;
import tallerweb.keeprunning.servicios.ObtenerDatosCarrera;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorPerfil {
	
	@Inject
	private ObtenerCarrerasInscriptas datosCarrerasInscriptas;
	@RequestMapping(value = "/miPerfil")
	public ModelAndView login(HttpServletRequest request) {
		List<Inscripcion> datosCarreraIscriptas = datosCarrerasInscriptas.obtenerCarrerasInscriptas((long) 1);
		request.getSession().setAttribute("email",datosCarreraIscriptas.get(0).getUsuario().getEmail());
		ModelAndView miPerfil = new ModelAndView();
		miPerfil.addObject(datosCarreraIscriptas);
		miPerfil.setViewName("miPerfil");
        return miPerfil;
	} 
	/*
	@Inject
	private ObtenerDatosCarrera obtenerDatosCarrera;	
	@RequestMapping(value = "/miPerfil={carreraId}", method = RequestMethod.GET)
	public ModelAndView cargarDatosCarrera(@PathVariable("carreraId") long carreraId, HttpServletRequest request) {
		List<Carrera> datosCarreraIscriptas = obtenerDatosCarrera.obtenerDatosCarreras(carreraId);
		request.getSession().setAttribute("nombre",datosCarreraIscriptas.get(0).getNombre());
		request.getSession().setAttribute("lugar",datosCarreraIscriptas.get(0).getLugar());
		request.getSession().setAttribute("fecha",datosCarreraIscriptas.get(0).getFechaInicio());
		request.getSession().setAttribute("hora",datosCarreraIscriptas.get(0).getHoraInicio());
		request.getSession().setAttribute("imagenFlyer",datosCarreraIscriptas.get(0).getImagenFlyer());
		request.getSession().setAttribute("imagenRecorrido",datosCarreraIscriptas.get(0).getImagenRecorrido());
		request.getSession().setAttribute("valor",datosCarreraIscriptas.get(0).getValor());			
		ModelAndView vistaCarrerasInscriptas = new ModelAndView();
		vistaCarrerasInscriptas.addObject(datosCarreraIscriptas);
		vistaCarrerasInscriptas.setViewName("miPerfil");
		return vistaCarrerasInscriptas;
	}*/
}
