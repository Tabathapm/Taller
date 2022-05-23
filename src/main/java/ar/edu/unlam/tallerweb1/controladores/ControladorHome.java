package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

@Controller
public class ControladorHome {
	
	private ServicioVuelo servicioVuelo;
	
	@Autowired
	public ControladorHome(ServicioVuelo servicioVuelo) {
		this.servicioVuelo = servicioVuelo;
	}

    @RequestMapping("/home")
    public ModelAndView irHome(){
        return new ModelAndView("homeDos");
    }

    @RequestMapping("/perfil")
    public ModelAndView miPerfil(){
        return new ModelAndView("miPerfil");
    }

    @RequestMapping("/hangares")
    public ModelAndView irHangares(){
        return new ModelAndView("hangares");
    }

    @RequestMapping("/vuelos")
    public ModelAndView verVuelos(HttpServletRequest request){
    	
    	ModelMap modelo = new ModelMap();
    	
    	modelo.put("vuelo", servicioVuelo.obtenerTodosLosVuelos());
    	
        return new ModelAndView("vuelos",modelo);
    }

    @RequestMapping("/tripulacion")
    public ModelAndView irTripulacion(){
        return new ModelAndView("tripulacion");
    }

    @RequestMapping("/pasajes")
    public ModelAndView irPasajes(){
        return new ModelAndView("pasajes");
    }


}
