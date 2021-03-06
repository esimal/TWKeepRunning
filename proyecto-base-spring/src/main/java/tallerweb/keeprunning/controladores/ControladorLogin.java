package tallerweb.keeprunning.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.keeprunning.modelo.Usuario;
import tallerweb.keeprunning.servicios.UsuarioServicios;

@Controller
@RequestMapping("/proyecto-base-spring/")
public class ControladorLogin {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView vistaLogin (Model modelo) {
		ModelAndView login = new ModelAndView();
		modelo.addAttribute("classLogin", new Usuario());
		login.setViewName("login");
		return login;
	}
	
	@Inject
	private UsuarioServicios validar;
	/*
	@RequestMapping(path="/login={param}", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request, @PathVariable("param") Integer param) {

		List<Usuario> usuarioValidado = validar.buscarUsuario(usuario.getEmail(), usuario.getPassword());
		ModelMap model = new ModelMap();
		if(usuarioValidado != null){
			if (param.equals(0)){
				try{
					if(request.getSession() != null) {
						request.getSession().setAttribute("email",usuarioValidado.get(0).getEmail());
						request.getSession().setAttribute("password",usuarioValidado.get(0).getPassword());
					}
				}catch(Exception e){
					System.out.println("El usuario no existe en la base");
					model.put("param", param);
					return new ModelAndView("ingresoIncorrecto");
				}
				System.out.println("Usuario existente");
				return new ModelAndView("redirect:/", model);
			} else {
				try{
					if(request.getSession() != null) {
						request.getSession().setAttribute("email",usuarioValidado.get(0).getEmail());
						request.getSession().setAttribute("password",usuarioValidado.get(0).getPassword());
					}
				}catch(Exception e){
					System.out.println("El usuario no existe en la base");
					model.put("param", param);
					return new ModelAndView("ingresoIncorrecto");
				}
				System.out.println("Usuario Existente.");		
				return new ModelAndView("inscripcion", model);			
			}
		} else {
			System.out.println("El usuario no existe en la base");
			model.put("error", "usuario-invalido");
			return new ModelAndView("ingresoIncorrecto", model);
		}
	}*/
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {

		Usuario usuarioValidado = validar.buscarUsuario(usuario.getEmail(), usuario.getPassword());
		
		ModelMap model = new ModelMap();
		if(usuarioValidado != null){
			request.getSession().setAttribute("email",usuarioValidado.getEmail());
			request.getSession().setAttribute("password",usuarioValidado.getPassword());
			request.getSession().setAttribute("usuarioId",usuarioValidado.getUsuarioId());
			model.put("UsuarioLogueado", usuarioValidado);
			return new ModelAndView("redirect:/",model);
		}else {
			System.out.println("El usuario no existe en la base");
			model.put("error", "usuario-invalido");
			return new ModelAndView("ingresoIncorrecto", model);
		}
	}
	
	@RequestMapping(value = "/0", method = RequestMethod.GET)
	public ModelAndView vistaLogout (HttpServletRequest request) {
		if(request.getSession() != null) {
			request.getSession().invalidate();
		}
		return new ModelAndView("redirect:/");
	}

	public void setValidarUsuarioMock(UsuarioServicios validar) {
		this.validar = validar;
	}
}
