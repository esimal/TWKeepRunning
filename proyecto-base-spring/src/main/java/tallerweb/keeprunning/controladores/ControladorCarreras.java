package tallerweb.keeprunning.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import tallerweb.keeprunning.modelo.Carrera;
import tallerweb.keeprunning.servicios.CarreraServicios;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorCarreras {
	
	@Inject
	private CarreraServicios obtenerDatosCarrera;	
	@RequestMapping(value = "/carrera={carreraId}", method = RequestMethod.GET)
	public ModelAndView cargarDatosCarrera(@PathVariable("carreraId") Long carreraId, HttpServletRequest request) {
		Carrera datosCarrera = obtenerDatosCarrera.obtenerDatosCarreras(carreraId);
		if(datosCarrera != null){
			request.getSession().setAttribute("nombre",datosCarrera.getNombre());
			request.getSession().setAttribute("lugar",datosCarrera.getLugar());
			request.getSession().setAttribute("fecha",datosCarrera.getFechaInicio());
			request.getSession().setAttribute("hora",datosCarrera.getHoraInicio());
			request.getSession().setAttribute("imagenFlyer",datosCarrera.getImagenFlyer());
			request.getSession().setAttribute("imagenRecorrido",datosCarrera.getImagenRecorrido());
			request.getSession().setAttribute("valor",datosCarrera.getValor());
			ModelAndView vistaCarrera = new ModelAndView();
			vistaCarrera.addObject(datosCarrera);
			vistaCarrera.setViewName("carreraElegida");
			return vistaCarrera;
		}else{
			ModelMap model = new ModelMap();
			model.put("error", "carrera-invalida");
			return new ModelAndView("carreraElegida", model);
		}
	}
	
	public void setObtenerDatosCarrera(CarreraServicios servicioMock) {	
		this.obtenerDatosCarrera = servicioMock;
	}	
}