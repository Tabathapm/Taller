package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import ar.edu.unlam.tallerweb1.modelo.Grafico;
import ar.edu.unlam.tallerweb1.modelo.Vuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTripulante;
import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

import java.util.List;

@Controller
public class ControladorHome {
	
	private ServicioVuelo servicioVuelo;
	private ServicioTripulante servicioTripulante;
	
	@Autowired
	public ControladorHome(ServicioVuelo servicioVuelo,ServicioTripulante servicioTripulante) {
		this.servicioVuelo = servicioVuelo;
		this.servicioTripulante = servicioTripulante;
	}

    @RequestMapping("/home")
    public ModelAndView irHome(){
        ModelMap modelo = new ModelMap();

//        List<Grafico> destinoConMasVuelos = servicioVuelo.destinoConMasVuelos();

        modelo.put("destinos", servicioVuelo.destinoConMasVuelos());

        return new ModelAndView("homeDos", modelo);
    }

    @RequestMapping("/perfil")
    public ModelAndView miPerfil(){
        return new ModelAndView("miPerfil");
    }

//    @RequestMapping("/hangares")
//    public ModelAndView irHangares(){
//        return new ModelAndView("hangares");
//    }

    @RequestMapping("/vuelos")
    public ModelAndView verVuelos(HttpServletRequest request){
    	
    	ModelMap modelo = new ModelMap();
    	
    	modelo.put("vuelo", servicioVuelo.obtenerTodosLosVuelos());
    	
        return new ModelAndView("vuelos",modelo);
    }
    

    @RequestMapping("/tripulacion")
    public ModelAndView irTripulacion(){
    	
    	ModelMap modelo = new ModelMap();
    	
    	modelo.put("tripulantes",servicioTripulante.listarTodosLosTripulantes());
    	
        return new ModelAndView("tripulacion",modelo);
    }

    @RequestMapping("/pasajes")
    public ModelAndView irPasajes(){
        return new ModelAndView("pasajes");
    }


}
