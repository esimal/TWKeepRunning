package tallerweb.keeprunning.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import tallerweb.keeprunning.servicios.ServicioCarrera;
import tallerweb.keeprunning.servicios.UsuarioService;

//import tallerweb.keeprunning.modelo.Carrera;

//import tallerweb.keeprunning.serviciocarreras.ServicioCarreras;


@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorCarreras {
	/*
	@Inject
	private ServicioCarrera servicioCarrera;
	@RequestMapping(path="/carrera={id}", method = RequestMethod.POST)

	public ModelAndView index(@ModelAttribute Carrera carrera, HttpServletRequest request, @PathVariable("id") Integer id) {
	
		servicioCarrera.obtenerDatosCarreras(carrera);
	
		ModelMap datosCarrera = new ModelMap();
		
		datosCarrera.addAttribute("id", carrera.getId());		
		datosCarrera.addAttribute("nombre", carrera.getNombre());
		datosCarrera.addAttribute("lugar", carrera.getLugar());
		datosCarrera.addAttribute("fecha", carrera.getFechaInicio());
		datosCarrera.addAttribute("hora", carrera.getHoraInicio());
		datosCarrera.addAttribute("imagenFlyer", carrera.getImagenFlyer());
		datosCarrera.addAttribute("imagenRecorrido", carrera.getImagenRecorrido());
		datosCarrera.addAttribute("valor", carrera.getValor());
		return new ModelAndView("vistaCarrera",datosCarrera);
	}*/
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
	
	@RequestMapping(value = "/carrera={id}", method = RequestMethod.GET)
	public ModelAndView cargarDatosCarrera(@PathVariable("id") Long id) {
		Carrera c1 = new Carrera();
		c1.abrirDetalleDeCarreraPorId(id);
		ModelMap datosCarrera = new ModelMap();
		datosCarrera.put("id", c1.getCarreraId());		
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
}