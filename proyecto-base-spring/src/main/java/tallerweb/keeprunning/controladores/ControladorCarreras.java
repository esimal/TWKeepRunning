package tallerweb.keeprunning.controladores;

import java.util.List;
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
	public ModelAndView cargarDatosCarrera(@PathVariable("carreraId") long carreraId, HttpServletRequest request) {
		List<Carrera> datosCarrera = obtenerDatosCarrera.obtenerDatosCarreras(carreraId);
		if(datosCarrera != null){
			request.getSession().setAttribute("nombre",datosCarrera.get(0).getNombre());
			request.getSession().setAttribute("lugar",datosCarrera.get(0).getLugar());
			request.getSession().setAttribute("fecha",datosCarrera.get(0).getFechaInicio());
			request.getSession().setAttribute("hora",datosCarrera.get(0).getHoraInicio());
			request.getSession().setAttribute("imagenFlyer",datosCarrera.get(0).getImagenFlyer());
			request.getSession().setAttribute("imagenRecorrido",datosCarrera.get(0).getImagenRecorrido());
			request.getSession().setAttribute("valor",datosCarrera.get(0).getValor());			
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