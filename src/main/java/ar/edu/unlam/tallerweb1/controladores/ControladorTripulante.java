package ar.edu.unlam.tallerweb1.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioTripulante;
import ar.edu.unlam.tallerweb1.servicios.ServicioVuelo;

@Controller
public class ControladorTripulante {
	
	private ServicioTripulante servicioTripulante;
	private ServicioVuelo servicioVuelo;
	
	@Autowired
	public ControladorTripulante(ServicioTripulante servicioTripulante,ServicioVuelo servicioVuelo) {
		this.servicioVuelo = servicioVuelo;
		this.servicioTripulante = servicioTripulante;
	}
	
	@RequestMapping("/tripulantes")
    public ModelAndView traerTripulantes(){
        ModelMap modelo = new ModelMap();

        modelo.put("tripulantes",servicioTripulante.listarTodosLosTripulantes());
        
        return new ModelAndView("tripulantes",modelo);

    }
	
	@RequestMapping("/asignarTripulante")
    public ModelAndView asignarTripulacionAVuelo() {
    	
    	ModelMap modelo = new ModelMap();
    	
    	modelo.put("tripulantes",servicioTripulante.listarTodosLosTripulantes());
    	
    	return new ModelAndView("asignarTripulante",modelo);  		
    }

	@RequestMapping("/asignarTripulante/asignar")
	public ModelAndView asignarTripulanteAVuelo(
			@RequestParam(value="tripulanteId") Long tripulanteId,
			HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		request.getSession().setAttribute("tripulante", tripulanteId);
		
		modelo.put("tripulante", servicioTripulante.traerTripulante(tripulanteId));
		modelo.put("vuelos",servicioVuelo.obtenerTodosLosVuelos());
		
		
		return new ModelAndView("asignar",modelo);
	}
	
	@RequestMapping("/asignarTripulante/exitoso")
	public ModelAndView tripulanteAsignadoAVuelo(
			@RequestParam(value="vueloId") Long vueloId,
			HttpServletRequest request) {
		
		Long t = (Long) request.getSession().getAttribute("tripulante");
		
		
	    this.servicioTripulante.asignarUnTripulanteAvuelo(vueloId,t);
	      
		
		return new ModelAndView("tripulanteAsignadoConExito");
	}


}
