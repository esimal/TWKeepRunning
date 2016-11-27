package tallerweb.keeprunning.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.ValidarUsuario;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorLogin {

	@Inject
	private ValidarUsuario usuarioService;
	@RequestMapping(path="/login={nombre}", method = RequestMethod.POST)

	public ModelAndView login(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request, @PathVariable("nombre") String nombre) {

	List<Usuario> usuarioValidado = usuarioService.validarUsuario(usuario.getEmail(), usuario.getPassword());

	if(usuarioValidado != null){
		ModelMap model = new ModelMap();
		if (nombre.equals("0")){
			try{
				request.getSession().setAttribute("email",usuarioValidado.get(0).getEmail());
				request.getSession().setAttribute("password",usuarioValidado.get(0).getPassword());
			}catch(Exception e){
				System.out.println("El usuario no existe en la base");
				return new ModelAndView("redirect:/proyecto-base-spring/login={nombre}");	
			}
			return new ModelAndView("redirect:/");
		}else{
			return new ModelAndView("inscripcion", model);
		}
			} else {
				ModelMap model2 = new ModelMap();
				model2.put("error", "usuario-invalido");
				request.getSession().invalidate();
				return new ModelAndView("login", model2);
			}	
		}
	public void setUsuarioService(ValidarUsuario servicioMock) {
	// TODO Auto-generated method stub

	}
	
	@RequestMapping(value = "/login={nombre}", method = RequestMethod.GET)
	public ModelAndView vistaLogin (Model modelo) {
		ModelAndView login = new ModelAndView();
		modelo.addAttribute("classLogin", new Usuario());
		login.setViewName("login");
		return login;
	}	
	
	/*@RequestMapping(value="/login={nombre}",  method = RequestMethod.POST)
	/* hay que meter el servicio y buscar los datos en la base!!!! 
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
	}*/

	
	
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
}
